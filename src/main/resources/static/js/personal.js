    function cerrar() {
        document.getElementsByClassName("ventana-modal")[0].style.display = "none";
    }

    function muestraValor() {
        var id = document.activeElement.id;
        var valor = document.getElementById(id).value;
        valor = parseFloat(valor);
        valor = valor/100;
        document.getElementById("valor").innerHTML = valor;
    }

    function validarEdad() {
        let dato = parseInt(document.getElementById("texto3").value);
        let nombre = document.getElementById("texto1").value +" "+ document.getElementById("texto2").value;
        
        if (dato >= 60){
            alert("Gracias por compartir tu gran experiencia con nosotros"+
            "\n\n                             BIENVENIDO"+
            "\n                MAESTRO "+nombre);
            
            
        }else if (dato > 30 && dato < 60){
            alert("Aprenderemos mucho juntos, tu experiencia es muy valiosa"+
            "\n\n                             BIENVENIDO"+
            "\n                PROFESOR "+nombre);
        }else{
            alert("Con nuestra experiencia, creceras mucho profesionalmente"+
            "\n\n                             BIENVENIDO"+
            "\n                PROFESOR "+nombre);
        }
        
    }

    function muestraValorColor() {
        var id = document.activeElement.id;
        var valor = document.getElementById(id).value;
        document.getElementById("valorPiel").innerHTML = valor;
    }

    function clicks(id){
        idElement = document.getElementById(id);
        var count = 2;
        showPopup("logData");
        idElement.onclick = function() {
            if (count % 2 == 0) {
                hidePopup("logData");
            } else {
                showPopup("logData");
            }
            count++;
        }
    }

    function showPopup(id){
        document.getElementById(id).style.display = 'block';
    }

    function hidePopup(id){
        document.getElementById(id).style.display = "none";
    }

    function showPopupAAU1() {
        var popup = document.getElementById("AAU1");
            popup.style.display = "block";
    }

    function hidePopupAAU1() {
        var popup = document.getElementById("AAU1");
        popup.style.display = "none";
    }

    function showPopupAAU2() {
        var popup = document.getElementById("AAU2");
            popup.style.display = "block";
    }

    function hidePopupAAU2() {
        var popup = document.getElementById("AAU2");
        popup.style.display = "none";
    }

    function agarrar(elmnt) {
        var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
        if (document.getElementById(elmnt.id + "header")) {
            document.getElementById(elmnt.id + "header").onmousedown = agarraMouseEnUso;
        } else {
            elmnt.onmousedown = agarraMouseEnUso;
        }
        
        function agarraMouseEnUso(e) {
            e = e || window.event;
            e.preventDefault();
            pos3 = e.clientX;
            pos4 = e.clientY;
            document.onmouseup = cerrarElementoAgarrado;
            document.onmousemove = elementoAgarrado;
        }

        function elementoAgarrado(e) {
            e = e || window.event;
            e.preventDefault();
            pos1 = pos3 - e.clientX;
            pos2 = pos4 - e.clientY;
            pos3 = e.clientX;
            pos4 = e.clientY;
            elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
            elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
        }

        function cerrarElementoAgarrado() {
            document.onmouseup = null;
            document.onmousemove = null;
        }
    }

    function fadeOutEffect(objeto, duracion) {
        var fadeTarget = document.getElementById(objeto);

        var fadeEffect = setInterval(function() {
            if (!fadeTarget.style.opacity) {
                fadeTarget.style.opacity = 1;
            }
            if (fadeTarget.style.opacity > 0) {
                fadeTarget.style.opacity -= duracion;
            } else {
                clearInterval(fadeEffect);
            }
        }, 30);
    }

    function fadeInEffect(objeto, duracion) {
        var fadeTarget = document.getElementById(objeto);
        fadeTarget.style.opacity = 0.1;
        fadeTarget.style.display = "block";
        var fadeEffect = setInterval(function() {
            if (!fadeTarget.style.opacity) {
                fadeTarget.style.opacity = 0;
            }
            if (fadeTarget.style.opacity < 1) {
                fadeTarget.style.opacity = parseFloat(fadeTarget.style.opacity) + duracion;
            } else {
                clearInterval(fadeEffect);
            }
        }, 100);
    }

    function showIframe() {
        var iframe = document.getElementById("formsFrame");
        iframe.style.display = "block";
    }

    function form() {
        var form = document.activeElement.id;
        var iframe = document.getElementById("formsFrame");
        iframe.src = "./view/forms/"+form+".php";
    }

    function userController(){
        window.location.href = "usuario/login";
    }

    function gastoController(){
        var iframe = document.getElementById("formsFrame");
        iframe.src = "/gasto/";
    }

    function show(id){
        document.getElementById(id).style.display = 'inline-block';
    }

    function hide(id){
        document.getElementById(id).style.display = 'none';
        document.getElementById("barra").style.width = '150px';
    }

    function hideElement(id){
        document.getElementById(id).style.display = 'none';
    }

    function enableInputs(ids){
        for (var i = 0; i < ids.length; i++) {
            document.getElementById(ids[i]).disabled = false;
        }
    }

    function userUpdateDB(ids){
        let values = [];
        let request = "";
        
        for (var i = 0; i < ids.length; i++) {
            values[i] = document.getElementById(ids[i]).value;
        }

        for (var i = 0; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        for (var i = 0; i < ids.length; i++) {
            request += ids[i] + "=" + values[i] + "&";
        }

        window.location.href = "../../controller/ControladorUsuario.php?editar&list&"+request;
    }

    function userUpdateDBSpring(ids){
        let values = [];
        let request = "";

        values[0] = ids[0];

        var formularioAEditar = document.getElementById(ids[0]);
        
        for (var i = 1; i < ids.length; i++) {
            values[i] = document.getElementById(ids[i]).value;
        }

        for (var i = 1; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        // //Imprime values[i] por consola
        // for (var i = 0; i < ids.length; i++) {
        //     console.log(ids[i] + ": " + values[i]);
        // }

        //Cambia los name de los formularios para enviar al controlador
        for (var i = 1; i < ids.length; i++) {
            formularioAEditar.elements[i].name = ids[i];
        }

        //Habilita los inputs
        for (var i = 0; i < ids.length; i++) {
            formularioAEditar.elements[i].disabled = false;
        }

        //Envia el formulario
        formularioAEditar.submit();
    }

    function userDeleteDBSpring(ids){
        let values = [];
        let request = "";

        values[0] = ids[0];
        values[1] = ids[1];

        var formularioConDatos = document.getElementById(ids[1]);
        var formularioAEnviar = document.getElementById(ids[0]);

        for (var i = 0, j = 2; j < ids.length; i++, j++) {
            values[i] = document.getElementById(ids[j]).value;
        }

        //Elimina las dos primeras posiciones del array ids
        ids.splice(0, 2);

        for (var i = 0; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        //Cambia los name de los formularios para enviar al controlador
        for (var i = 0, j = 1; i < ids.length; i++, j++) {
            formularioConDatos.elements[j].name = ids[i];
        }

        //Habilita los inputs
        for (var i = 0; i < formularioConDatos.elements.length; i++) {
            formularioConDatos.elements[i].disabled = false;
        }
        
        formularioConDatos.action = "/eliminar";

        //Envia el formulario
        formularioConDatos.submit();
    }

    function userDeleteDB(ids){
        let values = [];
        let request = "";
        
        for (var i = 0; i < ids.length; i++) {
            values[i] = document.getElementById(ids[i]).value;
        }

        for (var i = 0; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        for (var i = 0; i < ids.length; i++) {
            request += ids[i] + "=" + values[i] + "&";
        }

        window.location.href = "../../controller/ControladorUsuario.php?eliminar&"+request;
    }

    function gastoUpdateDB(ids){
        let values = [];
        let request = "";
        
        for (var i = 0; i < ids.length; i++) {
            values[i] = document.getElementById(ids[i]).value;
        }

        for (var i = 0; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        for (var i = 0; i < ids.length; i++) {
            request += ids[i] + "=" + values[i] + "&";
        }

        window.location.href = "../../controller/ControladorGasto.php?editar&list&"+request;
    }

    function gastoDeleteDB(ids){
        let values = [];
        let request = "";
        
        for (var i = 0; i < ids.length; i++) {
            values[i] = document.getElementById(ids[i]).value;
        }

        for (var i = 0; i < ids.length; i++) {
            ids[i] = ids[i].replace(/[0-9]/g, '');
        }

        for (var i = 0; i < ids.length; i++) {
            request += ids[i] + "=" + values[i] + "&";
        }

        window.location.href = "../../controller/ControladorGasto.php?eliminar&"+request;
    }