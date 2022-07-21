<?php
    session_start();
    require_once $_SERVER['DOCUMENT_ROOT'].'/DesarrolloWeb/model/Gasto.php';
    $gastos = @unserialize($_SESSION['gastosUsuario']);
    $todosGastos = @unserialize($_SESSION['gastosTodos']);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/personal.css">
    <script src="../js/personal.js"></script>
</head>

<body>
    <div id="listaGastos">
                <table>
                    <tr>
                        <td>
                            <button name="agregarGastoBtn" onclick="window.location.href='agregar.php?agregarGastoBtn';"><img src="../img/add.png" alt="Agregar">
                        </td>
                            
                        <?php if (isset($_SESSION['admin']) && $_SESSION['admin'] == '1') { ?>
                        <td>
                            <button name="listar" onclick="window.location.href='../../controller/ControladorGasto.php?listar=active';"><img src="../img/list.png" alt="Listar">
                        </td>
                        <?php } ?>
                        <form method="post">
                            <td>
                                <input type="number" name="id" placeholder="Buscar por ID de gasto">
                            </td>
                            <td>
                                <button type="submit" name="buscarGasto"><img src="../img/search.png" alt="buscar">
                            </td>
                        </form>
                    </tr>
                </table>

<?php
    switch ($_REQUEST) {
        case isset($_REQUEST['agregarGasto']):
            echo "<script>alert('GASTO " . $_SESSION['nombre_gasto'] . " AGREGADO CON EXITO')</script>";
            echo "<script>window.location.href='agregar.php'</script>";
            break;

        case isset($_REQUEST['agregarGastoBtn']):
            echo "<script>window.location.href='agregar.php'</script>";
            break;

        case isset($_REQUEST['buscarGasto']):
            $_SESSION['id'] = $_REQUEST['id'];
            header("Location: ../../controller/ControladorGasto.php?buscarGasto=active");
            break;

        case isset($_REQUEST['gastoBuscado']):
            if ($_REQUEST['gastoBuscado'] == '1') {
?>
        <h2 id='tituloGastos' class="tituloForm">GASTOS</h2>
        <table id="tablaGastos" class="tabla2">
            <tr>
                <th>Id</th>
                <th>Usuario Id</th>
                <th>Fecha</th>
                <th>Valor total sin IVA</th>
                <th>IVA total</th>
                <th>Valor total con IVA</th>
                <th>Nombre del gasto</th>
                <th>Lugar</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
            <tr>
                <td><input id='id' type='text' value='<?= $_SESSION['id'] ?>' disabled></td>
                <td><input id='usuario_id' type='text' value='<?= $_SESSION['usuario_id'] ?>' disabled></td>
                <td><input id='fecha' type='text' value='<?= $_SESSION['fecha'] ?>' disabled></td>
                <td><input id='valor_total_sin_iva' type='text' value='<?= $_SESSION['valor_total_sin_iva'] ?>' disabled></td>
                <td><input id='iva_total' type='text' value='<?= $_SESSION['iva_total'] ?>' disabled></td>
                <td><input id='valor_total_con_iva' type='text' value='<?= $_SESSION['valor_total_con_iva'] ?>' disabled></td>
                <td><input id='nombre_gasto' type='text' value='<?= $_SESSION['nombre_gasto'] ?>' disabled></td>
                <td><input id='lugar' type='text' value='<?= $_SESSION['lugar'] ?>' disabled></td>
                <td><input id='descripcion' type='text' value='<?= $_SESSION['descripcion'] ?>' disabled></td>
                <script>
                    ids = ['usuario_id', 'fecha', 'valor_total_sin_iva', 'iva_total', 'valor_total_con_iva', 'nombre_gasto', 'lugar', 'descripcion'];
                    editIds = ['id','usuario_id', 'fecha', 'valor_total_sin_iva', 'iva_total', 'valor_total_con_iva', 'nombre_gasto', 'lugar', 'descripcion'];
                </script>
                <td>
                    <a href='#' onclick="enableInputs(ids);"><img src='../img/edit.png'></a>
                    <a href='#' onclick="gastoUpdateDB(editIds);"><img src='../img/save.png'></a>
                    <a href='#' onclick="gastoDeleteDB(editIds);"><img src='../img/erase.png'></a>
                </td>
            </tr>
            </table>
            </div>
<?php
        } 
        else {
            echo "<script>alert('GASTO NO ENCONTRADO')</script>";
            echo "<script>window.location.href='index.php?gastosUsuario=active'</script>";
        }
        break;
    case isset($_REQUEST['gastosUsuario']):
        if(isset($_REQUEST['actualizar'])){
            echo "<script>window.location.href='#?gastosUsuario=ok'</script>";
        }else{
            
            echo "
            <h2 id='tituloTusGastos' class='tituloForm'>TUS GASTOS</h2>
            <table id='tablaGastos' class='tabla2'>
                <tr>
                <th>Id</th>
                <th>Usuario Id</th>
                <th>Fecha</th>
                <th>Valor total sin IVA</th>
                <th>IVA total</th>
                <th>Valor total con IVA</th>
                <th>Nombre del gasto</th>
                <th>Lugar</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
                <tr>";
                
                foreach ($gastos as $i => $gasto) {
                    echo "<tr>";
                    echo "<td><input id='id".$i."' type='text' value='" . $gasto->id . "' disabled></td>";
                    echo "<td><input id='usuario_id".$i."' type='text' value='" . $gasto->usuario_id . "' disabled></td>";
                    echo "<td><input id='fecha".$i."' type='text' value='" . $gasto->fecha . "' disabled></td>";
                    echo "<td><input id='valor_total_sin_iva".$i."' type='text' value='" . $gasto->valor_total_sin_iva . "' disabled></td>";
                    echo "<td><input id='iva_total".$i."' type='text' value='" . $gasto->iva_total . "' disabled></td>";
                    echo "<td><input id='valor_total_con_iva".$i."' type='text' value='" . $gasto->valor_total_con_iva . "' disabled></td>";
                    echo "<td><input id='nombre_gasto".$i."' type='text' value='" . $gasto->nombre_gasto . "' disabled></td>";
                    echo "<td><input id='lugar".$i."' type='text' value='" . $gasto->lugar . "' disabled></td>";
                    echo "<td><input id='descripcion".$i."' type='text' value='" . $gasto->descripcion . "' disabled></td>";
                    
                        echo "<td>".
                            "<script>
                                ids".$i." = ['usuario_id".$i."', 'fecha".$i."', 'valor_total_sin_iva".$i."', 'iva_total".$i.
                                "', 'valor_total_con_iva".$i."', 'nombre_gasto".$i."', 'lugar".$i."', 'descripcion".$i."'];
                                editIds".$i." = ['id".$i."','usuario_id".$i."', 'fecha".$i."', 'valor_total_sin_iva".$i."', 'iva_total".$i.
                                "', 'valor_total_con_iva".$i."', 'nombre_gasto".$i."', 'lugar".$i."', 'descripcion".$i."'];
                            </script>".
                            "<a href='#' onclick=".'"'."enableInputs(ids".$i.");".'"'." ><img src='../img/edit.png'></a>".
                            "<a href='#' onclick=".'"'."gastoUpdateDB(editIds".$i.");".'"'." ><img src='../img/save.png'></a>"
                            ."<a href='#' onclick=".'"'."gastoDeleteDB(editIds".$i.");".'"'." ><img src='../img/erase.png'></a>"

                            ."</td>
                            </tr>";
                }
            }
        break;

    case isset($_REQUEST['gastosTodos']):
        if(isset($_REQUEST['actualizar'])){
            echo "<script>window.location.href='#?gastosTodos=ok'</script>";
        }else{
            echo "
            <h2 id='tituloTodosGastos' class='tituloForm'>TODOS LOS GASTOS</h2>
            <table id='tablaGastos' class='tabla2'>
                <tr>
                <th>Id</th>
                <th>Usuario Id</th>
                <th>Fecha</th>
                <th>Valor total sin IVA</th>
                <th>IVA total</th>
                <th>Valor total con IVA</th>
                <th>Nombre del gasto</th>
                <th>Lugar</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
                <tr>";
                
                foreach ($todosGastos as $i => $gasto) {
                    echo "<tr>";
                    echo "<td><input id='id".$i."' type='text' value='" . $gasto->id . "' disabled></td>";
                    echo "<td><input id='usuario_id".$i."' type='text' value='" . $gasto->usuario_id . "' disabled></td>";
                    echo "<td><input id='fecha".$i."' type='text' value='" . $gasto->fecha . "' disabled></td>";
                    echo "<td><input id='valor_total_sin_iva".$i."' type='text' value='" . $gasto->valor_total_sin_iva . "' disabled></td>";
                    echo "<td><input id='iva_total".$i."' type='text' value='" . $gasto->iva_total . "' disabled></td>";
                    echo "<td><input id='valor_total_con_iva".$i."' type='text' value='" . $gasto->valor_total_con_iva . "' disabled></td>";
                    echo "<td><input id='nombre_gasto".$i."' type='text' value='" . $gasto->nombre_gasto . "' disabled></td>";
                    echo "<td><input id='lugar".$i."' type='text' value='" . $gasto->lugar . "' disabled></td>";
                    echo "<td><input id='descripcion".$i."' type='text' value='" . $gasto->descripcion . "' disabled></td>";
                    
                        echo "<td>".
                            "<script>
                                ids".$i." = ['usuario_id".$i."', 'fecha".$i."', 'valor_total_sin_iva".$i."', 'iva_total".$i.
                                "', 'valor_total_con_iva".$i."', 'nombre_gasto".$i."', 'lugar".$i."', 'descripcion".$i."'];
                                editIds".$i." = ['id".$i."','usuario_id".$i."', 'fecha".$i."', 'valor_total_sin_iva".$i."', 'iva_total".$i.
                                "', 'valor_total_con_iva".$i."', 'nombre_gasto".$i."', 'lugar".$i."', 'descripcion".$i."'];
                            </script>".
                            "<a href='#' onclick=".'"'."enableInputs(ids".$i.");".'"'." ><img src='../img/edit.png'></a>".
                            "<a href='#' onclick=".'"'."gastoUpdateDB(editIds".$i.");".'"'." ><img src='../img/save.png'></a>"
                            ."<a href='#' onclick=".'"'."gastoDeleteDB(editIds".$i.");".'"'." ><img src='../img/erase.png'></a>"

                            ."</td>
                            </tr>";
                }
            }
        break;
    case isset($_REQUEST['gastoEditado']):
        echo "<script>alert('GASTO " . $_SESSION['nombre_gasto'] . " EDITADO CON EXITO')</script>";
        echo "<script>window.location.href='index.php?gastosUsuario=ok&actualizar=ok'</script>";
        break;

    case isset($_REQUEST['gastoEliminado']):
        echo "<script>alert('GASTO " . $_SESSION['nombre_gasto'] . " ELIMINADO CON EXITO')</script>";
        echo "<script>window.location.href='index.php?gastosUsuario=ok&actualizar=ok'</script>";
        break;
}
?>
</table>
</div>
</body>
</html>