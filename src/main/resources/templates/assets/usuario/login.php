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
    <form method="post" id="log-in" class="contenedorLogin">
        <a id="btn-x" onclick="hideElement('log-in');">x</a>
        <table>
            <tr>
                <br>
                <h2 class="tituloForm">INICIAR SESION</h2>
                <br>
            </tr>
            <tr>
                <center>
                    <input type="text" name="cedula" placeholder="Introduzca su Cédula" required>
                    <input type="password" name="clave" placeholder="Introduzca su Contraseña">
                </center>
            </tr>
            <tr>
                <td>
                    <center>
                        <input type="submit" name="sesion" value="Iniciar sesión">
                        <input type="submit" name="registrar" value="Registrarse">
                        <br>
                        <!-- Make an a tag a submit button -->

                        <input type="submit" id="recoveryPass" name="recoveryPass" value="Olvidaste tu contraseña?"><a  href="login.php?recoveryPass=active"></a>
                    </center>
                </td>
            </tr>
        </table>
    </form>

    <?php
    
        if(count($_REQUEST) != 0){
            
            switch($_REQUEST){
                case isset($_REQUEST['sesion']):
                    echo "<script>console.log('login->sesion')</script>";
                    $_SESSION['cedula'] = $_REQUEST['cedula'];
                    $_SESSION['clave'] = $_REQUEST['clave'];
                    header("Location: ../../controller/ControladorUsuario.php?sesion=active");
                    break;
                case isset($_REQUEST['registrar']):
                    header("Location: ../../controller/ControladorUsuario.php?registrar=active");
                    break;
                case isset($_REQUEST['recoveryPass']):
                    header("Location: ../../controller/ControladorUsuario.php?recovery=active&cedula=".$_REQUEST['cedula']);
                    break;
                default:
                    echo "NO HIZO NADA";
                    break;
            }
        }
    ?>
</body>

</html>
<script>
    window.onload = function() {
        fadeInEffect('log-in', 0.5);
    }
</script>