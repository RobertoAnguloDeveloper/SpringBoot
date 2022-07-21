<?php
    function status(){
        if(count($_SESSION) > 0){
            switch($_SESSION){
                case isset($_SESSION['logStatus']):
                    if($_SESSION['logStatus']){
                        if(isset($_SESSION['admin'])){
                            echo "<script> show('adminCuentas'); </script>";
                        }
                        echo "<script>
                                hide('sesion');
                                show('login-icon');
                                show('gastos');
                            </script>";
                    }else{
                        
                        echo "<script>
                                hide('login-icon');
                            </script>";
                    }
                    break;
            }
        }
        
    }