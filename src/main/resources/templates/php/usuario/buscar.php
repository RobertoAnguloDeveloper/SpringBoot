<?php
    session_start();
    
    switch ($_REQUEST){
        case isset($_REQUEST['sesionBuscar']):
            
            header("Location: ../../controller/ControladorUsuario.php?buscar=active");
            break;
        case isset($_REQUEST['adminCuentas']):
            header("Location: ../../controller/ControladorUsuario.php?listar=active");
            break;
    }
    