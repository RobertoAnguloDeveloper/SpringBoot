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
    <form method="post" id="account" class="contenedorLogin">
        <table>
            <tr>
                <br>
                <h2 class="tituloForm">DATOS CUENTA</h2>
                <br>
            </tr>
            <tr>
                <label for="nombre"><b>Nombre</b></label>
                <input type="text" id="nombre" name="nombre" value="<?= $_SESSION['nombre']; ?>" placeholder="" disabled>

                <label for="cedula"><b>Cédula</b></label>
                <input type="text" id="cedula" name="cedula" value="<?= $_SESSION['cedula']; ?>" placeholder="" disabled>

                <label for="clave"><b>Contraseña</b></label>
                <input type="password" id="clave" name="clave" value="<?= $_SESSION['clave']; ?>" placeholder="" disabled>

                <label for="email"><b>Email</b></label>
                <input type="email" id="email" name="email" value="<?= $_SESSION['email']; ?>" placeholder="" disabled>

                <label for="telefono"><b>Teléfono</b></label>
                <input type="number" id="telefono" name="telefono" value="<?= $_SESSION['telefono']; ?>" placeholder="" disabled>

                <script>
                    ids = ['nombre', 'clave', 'email', 'telefono'];
                </script>
            </tr>
            <tr>
                <td>
                    <input type="button" onclick=" enableInputs(ids);" name="editar" value="Editar">
                </td>
                <td>
                    <input type="submit" name="guardar" value="Guardar">
                </td>
            </tr>
        </table>
    </form>
</body>

</html>

<?php
if (isset($_REQUEST['guardar'])) {
    $_SESSION['nombre'] = $_REQUEST['nombre'];
    $_SESSION['clave'] = $_REQUEST['clave'];
    $_SESSION['email'] = $_REQUEST['email'];
    $_SESSION['telefono'] = $_REQUEST['telefono'];

    header("Location: ../../controller/ControladorUsuario.php?editar");
}
?>