<?php
    session_start();
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
    <form method="post" id="gastoAgregar" class="contenedorSignin">
        <table>
            <tr>
                <br>
            </tr>
            <tr>
                <h2 id="regGasto" class="tituloForm">
                    <center>AGREGAR GASTO</center>
                </h2>
                <input type="number" name="usuario_id" value="<?=$_SESSION['cedula']?>" disabled>
                <input type="date" name="fecha" required>
                <input type="number" step="0.01" name="valor_total_sin_iva" placeholder="Valor total sin IVA" required>
                <input type="number" step="0.01" name="iva_total" placeholder="IVA total" required>
                <input type="number" step="0.01" name="valor_total_con_iva" placeholder="Valor total con IVA" required>
                <input type="text" name="nombre_gasto" placeholder="Introduzca el nombre del gasto" required>
                <input type="text" name="lugar" placeholder="Lugar del gasto" required>
                <input type="text" name="descripcion" placeholder="Descripción del gasto" required>
                <tr>
                    <td>
                        <input type="submit" name="agregarGasto" value="Guardar">
                        <input type="reset" name="limpiar" value="Limpiar campos">
                    </td>
                </tr>
            </tr>
        </table>
    </form>
    <?php
        if(isset($_REQUEST['agregarGasto'])){
            
            $_SESSION['usuario_id'] = $_SESSION['cedula'];
            $_SESSION['fecha'] = $_REQUEST['fecha'];
            $_SESSION['valor_total_sin_iva'] = $_REQUEST['valor_total_sin_iva'];
            $_SESSION['iva_total'] = $_REQUEST['iva_total'];
            $_SESSION['valor_total_con_iva'] = $_REQUEST['valor_total_con_iva'];
            $_SESSION['nombre_gasto'] = $_REQUEST['nombre_gasto'];
            $_SESSION['lugar'] = $_REQUEST['lugar'];
            $_SESSION['descripcion'] = $_REQUEST['descripcion'];
            
            header("Location: ../../controller/ControladorGasto.php?agregarGasto=active");
        }
    ?>
</body>

</html>