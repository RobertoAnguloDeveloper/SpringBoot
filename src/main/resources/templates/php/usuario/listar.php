<?php
session_start();
require_once $_SERVER['DOCUMENT_ROOT'].'/DesarrolloWeb/model/Usuario.php';
$usuarios = @unserialize($_SESSION['usuarios']);
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
    <div id="listaUsuarios">
        <h2 class="tituloForm">USUARIOS</h2>
        <table class="tabla2">
            <tr>
                <th>#</th>
                <th>Cédula</th>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
            <?php
                foreach ($usuarios as $i => $usuario) {
                    echo "<tr>";
                    echo "<td>" . ($i+1) . "</td>";
                    echo "<td><input id='cedula".$i."' type='text' value='" . $usuario->cedula . "' disabled></td>";
                    echo "<td><input id='clave".$i."' type='text' value='" . $usuario->clave . "' disabled></td>";
                    echo "<td><input id='nombre".$i."' type='text' value='" . $usuario->nombre . "' disabled></td>";
                    echo "<td><input id='email".$i."' type='text' value='" . $usuario->email . "' disabled></td>";
                    echo "<td><input id='telefono".$i."' type='text' value='" . $usuario->telefono . "' disabled></td>";
                    if($_SESSION['cedula'] == $usuario->cedula){
                        echo "<td><a href='editar.php'>Editar</a></td>";
                        echo "</tr>";
                    }else{
                        echo "<td>".
                            "<script>
                                ids".$i." = ['cedula".$i."', 'clave".$i."', 'nombre".$i."', 'email".$i."', 'telefono".$i."'];
                                idsEdit".$i." = ['clave".$i."', 'nombre".$i."', 'email".$i."', 'telefono".$i."'];
                            </script>".
                            "<a href='#' onclick=".'"'."enableInputs(idsEdit".$i.");".'"'." ><img src='../img/edit.png'></a>".
                            "<a href='#' onclick=".'"'."userUpdateDB(ids".$i.");".'"'." ><img src='../img/save.png'></a>"
                            ."<a href='#' onclick=".'"'."userDeleteDB(ids".$i.");".'"'." ><img src='../img/erase.png'></a>"

                            ."</td></tr>";
                    }
                    
                }
            ?>

        </table>
    </div>
</body>

</html>

<?php
switch ($_REQUEST){
    case isset($_REQUEST['adminCuentas']):
        header("Location: ../../controller/ControladorUsuario.php?listar=active");
        break;
    case isset($_REQUEST['editOk']):
        echo "<script>alert('Usuario ".$_REQUEST['cedula']." actualizado correctamente');</script>";
        echo "<script>window.location.href='listar.php';</script>";
        break;

    case isset($_REQUEST['eliminar']):
        if($_REQUEST['eliminar'] == '1'){
            echo "<script>alert('Usuario ".$_REQUEST['cedula']." eliminado correctamente');</script>";
            echo "<script>window.location.href='listar.php';</script>";
        }else{
            echo "<script>alert('Error al eliminar usuario ".$_REQUEST['cedula']."');</script>";
            echo "<script>window.location.href='listar.php';</script>";
        }
        break;
    default:
        break;
}
?>