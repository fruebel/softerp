/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//lista_f(tabla SQL,id_campo,texto_campo,where,elemento_html)

function activaTab(tab){
     //$('.nav-tabs a[href="#'+tab+'"]').tab('show');
      
      $( "#tabs" ).tabs({ active: tab });
}
function habilita_deshabilita_Tab(ope,index){
    
    if (ope == "h")
        ope = "enable";
    else
        ope = "disable";
    
    $("#tabs").tabs(ope, index);
}

function mensaje(titulo,texto,tiempo) {

    swal({
        title: titulo,
        text: texto,
        timer: tiempo
    }).then(
            function () {},
            // handling the promise rejection
                    function (dismiss) {
                        if (dismiss === 'timer') {
                            console.log('I was closed by the timer')
                        }
                    }
            );
}

function llenaLista(tabla, id, texto, where, elemento) {


    var lista;

    $.ajax({
        beforeSend: function () {
        },
        url: 'llenalistasSRV',
        type: 'POST',
        async: false,
        data: 'tabla=' + tabla + '&id=' + id + '&texto=' + texto + '&where=' + where,
        error: function (response) {
            alert('Se produjo un error : ');
            console.log('error combos->', response);
        },
        success: function (data) {
            lista = data;
            $('#' + elemento).html(lista);
        }
    })

    return lista;
}

var subeArchivo = function (frm) {

    var respuesta = true;
    var formData = new FormData(document.getElementById(frm));
    var imgContainer = $('#imgContainer');

    $.ajax({
        url: 'FileUploadServlet',
        type: "POST",
        async: false,
        data: formData,
        dataType: 'json',
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false
    }).done(function (data) {
        alert(data.resultado);
        if (data.resultado == 'exito') {
            respuesta = true;
            imgContainer.html('');
            var img = '<img src="data:' + data.imagen + ';base64,'
                    + data.imagen + '"/>';

            //imgContainer.append(img);
        } else
            respuesta = false;
    }).fail(function (jqXHR, textStatus) {
        respuesta = false;
    });

    return respuesta;

}

var isJpg = function (name) {
    return name.match(/jpg$/i)
};

var isPng = function (name) {
    return name.match(/png$/i)
};

