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
    <form method="post" id="sign-in" class="contenedorSignin">
        <a id="btn-x" onclick="hideElement('sign-in');">x</a>
        <table>
            <tr>
                <br>
            </tr>
            <tr>
                <h2 id="regUsuario" class="tituloForm">
                    <center>REGISTRAR USUARIO</center>
                </h2>
                <input type="number" name="cedula" placeholder="Introduzca su Cédula" required>
                <input type="password" name="clave" placeholder="Introduzca su Contraseña" required>
                <input type="email" name="email" placeholder="Introduzca su email" required>
                <input type="text" name="nombre" placeholder="Introduzca su nombre completo" required>
                <input type="number" name="telefono" placeholder="Introduzca su telefono" required>
                <tr>
                    <td>
                        <input type="submit" name="agregar" value="Guardar">
                        <input type="reset" name="limpiar" value="Limpiar campos">
                    </td>
                </tr>
            </tr>
        </table>
    </form>
    <?php
        if(isset($_REQUEST['agregar'])){
            
            $_SESSION['cedula'] = $_REQUEST['cedula'];
            $_SESSION['clave'] = $_REQUEST['clave'];
            $_SESSION['email'] = $_REQUEST['email'];
            $_SESSION['nombre'] = $_REQUEST['nombre'];
            $_SESSION['telefono'] = $_REQUEST['telefono'];

            header("Location: ../../controller/ControladorUsuario.php?".array_keys($_REQUEST)[5]);
        }
    ?>
</body>

</html>