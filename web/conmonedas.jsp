<!DOCTYPE html>
<jsp:include page="verificasession.jsp" />
<jsp:include page="verificaaccesoxpagina.jsp?f=1"/>
<jsp:include page="encabezadopaginas.jsp" /> 

<%
    String servlet = "conmonedasSRV";
%>
<section id="container" >

    <jsp:include page="menuprincipal.jsp" /> 
    <jsp:include page="menuizquierdo.jsp" />

    <form name="frmData" id="frmData" action="<%out.print(servlet);%>" method="post">
        <input type="hidden" id="action" name="action" value="action" /> 
        <input type="hidden" id="idRow" name="idRow" value="idRow" /> 
        <section id="main-content">
            <section class="wrapper site-min-height">

                <div class="row mt">
                    <div class="col-md-5">
                        <h3><i class="fa fa-angle-right"></i> Monto Monedas </h3>
                    </div>
                    <div class="col-md-1">
                        <a  href='#' tooltip="Generar nuevo" ><button type="button" class="btn btn-round btn-info btn-lg " id="btnnuevo">
                                <i class="fa fa-plus" aria-hidden="true"></i>
                            </button>
                        </a>  
                    </div>
                    <div class="col-md-6"></div>
                </div>
                <div class="row mt">
                    <div class="col-md-12">

                        <div id="tabs">
                            <ul>
                                <li><a href="#tabs-1">Lista</a></li>
                                <li><a href="#tabs-2">Datos</a></li>                              
                            </ul>

                            <div id="tabs-1">
                                <div class="row mt">
                                    <div class="col-md-12"> 
                                        <table id="tablainfo" class="nowrap_table table table-striped no-wrap responsive" width="100%" cellspacing="0"></table>
                                    </div>   
                                </div>
                            </div>

                            <div id="tabs-2">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <button type="button" class="btn btn-primary btn-lg btn-block" id="titulo_ope">Nuevo</button>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 control-label" >
                                            ID
                                        </div>
                                        <div class="col-md-4">
                                            <input placeholder="ID" class="form-control" type="text" name="Idmoneda" id="Idmoneda" required>
                                        </div>
                                        <div class="col-md-2 control-label" >
                                            Moneda
                                        </div>
                                        <div class="col-md-4">
                                            <input placeholder="Moneda" class="form-control" type="text" name="Moneda" id="Moneda" required>
                                        </div>                                     
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 control-label" >
                                            Pa&iacute;s
                                        </div>
                                        <div class="col-md-4">
                                            <input placeholder="Pa&iacute;s" class="form-control" type="text" name="Pais" id="Pais" required>
                                        </div>
                                        <div class="col-md-2 control-label" >
                                           Tipo de cambio
                                        </div>
                                        <div class=" col-md-4 " >
                                            <input placeholder="Tipo de Cambio" class="form-control" type="text" name="Tipodecambio" id="Tipodecambio" required>
                                        </div>
                                    </div>                                   
                                    <br />
                                    <div class="row">

                                        <div class="col-md-4">&nbsp;</div>

                                        <div class="col-md-2">
                                            <button type="submit" class="btn btn-round btn-success btn-lg btn-block" id="btnenviar">
                                                <i class="fa fa-chevron-right" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                        <div class="col-md-2">
                                            <button type="button" class="btn btn-round btn-danger btn-lg btn-block" id="btncancelar">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                        <div class="col-md-4">&nbsp;</div>

                                    </div>

                                </div>
                            </div>



                        </div>
                    </div>
                </div>
            </section>
        </section><!-- /MAIN CONTENT -->
    </form>
    <jsp:include page="copyright.jsp" />    
</section>
<jsp:include page="piepaginas.jsp" />   
<script>
    $(function () {
        $("#tabs").tabs();
    });
</script>  
<script type="text/javascript">
    $(document).ready(function(){
        lista_contenido('listar');
        cant_caracteres();
        $('#frmData').submit(function(e){
        e.preventDefault();
            nuevo_contenido('nuevo');
        });
    });
    
   /* $('#titulo_ope').html('Nuevo');
    $('#btnnuevo').attr("disabled", false);
    $('#btnenviar').attr("disabled", true);
    activaTab(0);
    habilita_deshabilita_Tab("d",1);
    
    $('#btncancelar').on('click', function (e) {
        e.preventDefault();
        
        habilita_deshabilita_Tab("h",0);
        habilita_deshabilita_Tab("d",1);
        activaTab(0);
        
        limpiacampos();
        inhabilitacampos(true);
        $('#btnnuevo').attr("disabled", false);
        $('#btnenviar').attr("disabled", true);
        $('#titulo_ope').html('Nuevo');
         
    });

    $('#btnnuevo').on('click', function (e) {
        
        e.preventDefault();
        habilita_deshabilita_Tab("h",1);
        activaTab(1);
        habilita_deshabilita_Tab("d",0);
         
        limpiacampos();
        inhabilitacampos(false);
        $('#action').val('nuevo');
        $('#idRow').val(0);
        $('#idusuario').attr("readonly", false);
        $('#titulo_ope').html('Nuevo');
        $(this).attr("disabled", true);
        $('#btnenviar').attr("disabled", false);
        //$('#tab1').addClass("disabledTab");
    });*/


    function lista_contenido(valor) {
        $.ajax({
                type: 'POST',
                url: $('#frmData').attr('action'),
                data: { 'action': valor },
                //contentType: "application/x-www-form-urlencoded; charset=utf-8",
                //dataType: "json",
                //cache: true,
                //async: false,
                success: function(resp){
                    $('#tablainfo').html(resp);
                },
                complete: function(){
                    /*//$('#tablainfo').DataTable().fnDestroy();
                    $('#tablainfo').DataTable({
                        responsive: true,
                        searching: true,
                        lengthChange: false,
                        pageLength: 10,
                        language: {
                            "url": "assets/json/Spanish.json"
                        }
                    });*/
                },
                error: function(msg){
                    //console.log("Ocurrio un error al procesar la Información. ");
                }
            });
    }

    function nuevo_contenido(valor){
      $('#action').val(valor);
        $.ajax({
            url: $(this).attr('action'),
            type: 'POST',
            data: $(this).serialize(),
            //async: false,
            //dataType: 'json',
            beforeSend: function () {
                $('#btnEviar').attr('disabled', true);
            },
            success: function(resp){
                console.log(resp);
                if(resp.respuesta === 'true'){
                    pinta_contenido('listar');
                    activaTab(0);
                    //habilita_deshabilita_Tab("h",0);
                    //habilita_deshabilita_Tab("d",1);
                    mensaje("Informacion", resp.mensaje, 2000);
                }else{
                    mensaje("Error", resp.mensaje, 2000);
                    $('#btnEviar').attr('disabled', false);
                }
            },
            error: function(jqXHR,estado,error){
                mensaje("Error","No fue posible registrar la información. Intente nuevamente.", 2000);
                $('#btnEviar').attr('disabled', false);
                return;
            }
        });  
    };
    
    function cant_caracteres(){
        var Total = 4;
            $('#Tipodecambio').keyup(function(){
                var Cant = $(this).val();
                if(Total-1 < Cant.length ){
                    $(this).val(Cant.substring(0,Total-1));
                }
            });   
    };
    
    function editar(data, e) {
        e.preventDefault();
        
        var idRrow = data.id;
        $('#frmData').attr('action', '<%out.print(servlet);%>');
        $('#titulo_ope').html('Editar');
        $('#action').val('editar');
        $('#idRow').val(idRrow);
        $('#idusuario').attr("readonly", true);

        $('#btnnuevo').attr("disabled", true);
        $('#btnenviar').attr("disabled", false);

       
        $.ajax({
            url: '<%out.print(servlet);%>',
            type: 'POST',
            async: false,
            dataType: 'json',
            data: "idRow=" + idRrow + "&action=consulta",
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                var usuarios = data[0];

                $('#idusuario').val(usuarios.idUsuario);
                $("#nombre").val(usuarios.nombre);
                $("#idperfil option[value=" + usuarios.idperfil.idperfil + "]").attr("selected", true);
                $('#apellidopaterno').val(usuarios.apellidoPaterno);
                $('#apellidomaterno').val(usuarios.apellidoMaterno);
                $('#contrasenia').val(usuarios.contrasenia);
                $('#fotografia').val(usuarios.fotografia);
                $('#email').val(usuarios.email);
                $('#telefono').val(usuarios.telefono);
                $('#tema').val(usuarios.tema);
                $('#lenguaje').val(usuarios.lenguaje);
                if (usuarios.idEstado.idestado == 1)
                    $("#idestado").prop("checked", true);
                else
                    $("#idestado").prop("checked", false);


            }, complete: function (xhr, status) {

                habilita_deshabilita_Tab("h",1);
                activaTab(1);             
                inhabilitacampos(false);
                habilita_deshabilita_Tab("d",0);
            }

        });

    }

    function limpiacampos() {
        $('#idusuario').val('');
        $("#nombre").val('');
        $("#idperfil option[value=''").attr("selected", true);
        $('#apellidopaterno').val('');
        $('#apellidomaterno').val('');
        $('#contrasenia').val('');
        $('#fotografia').val('');
        $('#telefono').val('');
        $('#email').val('');
        $('#tema').val('');
        $('#lenguaje').val('');
    }

    function inhabilitacampos(valor) {
        $('#idusuario').attr('readonly', valor);
        $('#nombre').attr('readonly', valor);
        $('#idperfil').attr('readonly', valor);
        $('#apellidopaterno').attr('readonly', valor);
        $('#apellidomaterno').attr('readonly', valor);
        $('#contrasenia').attr('readonly', valor);
        $('#fotografia').attr('readonly', valor);
        $('#telefono').attr('readonly', valor);
        $('#email').attr('readonly', valor);
        $('#tema').attr('readonly', valor);
        $('#lenguaje').attr('readonly', valor);
    }
    
</script>   
