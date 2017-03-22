<!DOCTYPE html>
<jsp:include page="verificasession.jsp" /> 
<jsp:include page="verificaaccesoxpagina.jsp?f=2" />
<jsp:include page="encabezadopaginas.jsp" /> 

<%
    String servlet = "permisosSRV";
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
                        <h3><i class="fa fa-angle-right"></i> Permisos</h3>
                    </div>
                    <div class="col-md-1">
                        <a  href='#' ><button type="button" class="btn btn-round btn-info btn-lg " id="btnnuevo">
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

                                    <br />

                                    <div class="row">

                                        <div class="col-md-2 control-label" >
                                            Nombre
                                        </div>
                                        <div class="col-md-4 " >
                                            <input placeholder="Nombre" class="form-control" type="text" name="nombre" id="nombre" required>
                                        </div>

                                        <div class="col-md-2 control-label" >
                                            Estatus
                                        </div>
                                        <div class=" col-md-4 " >
                                            <input type="checkbox" id="idestado" name="idestado" checked class="form-control">
                                        </div>

                                    </div>                                                         

                                    <br />

                                    <div class="row">
                                        

                                        <div class="col-md-12" >
                                            <table id="tablafunciones" class="nowrap_table table table-striped no-wrap responsive" width="100%" cellspacing="0">


                                            </table>
                                        </div>

                                    </div>                                                    

                                    <br />
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

    llenaLista("seg_perfiles", "idperfil", "nombre", "1", "idperfil");
    pinta_contenido('listar');
    $('#titulo_ope').html('Nuevo');
    $('#btnnuevo').attr("disabled", false);
    $('#btnenviar').attr("disabled", true);
    activaTab(0);
    habilita_deshabilita_Tab("d", 1);

    $('#btncancelar').on('click', function (e) {
        e.preventDefault();

        habilita_deshabilita_Tab("h", 0);
        habilita_deshabilita_Tab("d", 1);
        activaTab(0);

        limpiacampos();
        inhabilitacampos(true);
        $('#btnnuevo').attr("disabled", false);
        $('#btnenviar').attr("disabled", true);
        $('#titulo_ope').html('Nuevo');

    });

    $('#btnnuevo').on('click', function (e) {

        e.preventDefault();
        habilita_deshabilita_Tab("h", 1);
        activaTab(1);
        habilita_deshabilita_Tab("d", 0);

        limpiacampos();
        inhabilitacampos(false);
        $('#frmData').attr('action', '<%out.print(servlet);%>');
        $('#action').val('nuevo');
        $('#idRow').val(0);
        $('#idusuario').attr("readonly", false);
        $('#titulo_ope').html('Nuevo');
        $(this).attr("disabled", true);
        $('#btnenviar').attr("disabled", false);
        
        pinta_contenido_funciones(0);
        
        
    });


    function pinta_contenido(valor) {

        $.ajax({
            beforeSend: function () {
                // body...
            },
            url: '<%out.print(servlet);%>',
            type: 'POST',
            async: false,
            data: "action=" + valor,
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                $('#tablainfo').html(data);
            },
            complete: function (xhr, status) {

                $('#tablainfo').dataTable().fnDestroy();

                $('#tablainfo').DataTable({
                    responsive: true,
                    searching: true,
                    lengthChange: false,
                    pageLength: 10,
                    language: {
                        "url": "assets/json/Spanish.json"
                    }
                });
            }
        });
    }

    $('#frmData').submit(function (e) {


        e.preventDefault();

        var pet = $('#frmData').attr('action');
        var met = $('#frmData').attr('method');

        $.ajax({
            beforeSend: function () {
                $('#btnEviar').attr('disabled', true);

            },
            url: pet,
            type: met,
            data: $('#frmData').serialize(),
            async: false,
            dataType: 'json',
            error: function (jqXHR, estado, error) {
                alert('El registro no pudo realizarse, intente nuevamente.');
                $('#btnEviar').attr('disabled', false);
                return;
            },
            success: function (respuesta) {
                // body...
                if (respuesta.respuesta == true) {

                    limpiacampos();
                    inhabilitacampos(true);
                    $('#btnenviar').attr('disabled', true);
                    $('#btnnuevo').attr("disabled", false);
                    pinta_contenido('listar');

                    habilita_deshabilita_Tab("h", 0);
                    activaTab(0);
                    habilita_deshabilita_Tab("d", 1);

                    mensaje("Informacion", respuesta.mensaje, 2000);

                } else {
                    alert(respuesta.mensaje);
                    $('#btnEviar').attr('disabled', false);
                }
            },
            complete: function (xhr, status) {
            }
        });


    })

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
            beforeSend: function () {
                // body...
                //console.log(id_row);
            },
            url: '<%out.print(servlet);%>',
            type: 'POST',
            async: false,
            dataType: 'json',
            data: "idRow=" + idRrow + "&action=consulta",
            error: function (jqXHR, textStatus, errorThrown) {
                // body...
                alert('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                // body...
               var dom = data[0];
                $("#nombre").val(dom.perfil);
                if (dom.activo == 1)
                    $("#idestado").prop("checked", true);
                else
                    $("#idestado").prop("checked", false);


            }, complete: function (xhr, status) {

                habilita_deshabilita_Tab("h", 1);
                activaTab(1);
                inhabilitacampos(false);
                habilita_deshabilita_Tab("d", 0);
                pinta_contenido_funciones(idRrow);
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
    
    
    function pinta_contenido_funciones(idRrow) {

        $.ajax({
            beforeSend: function () {
                // body...
            },
            url: 'permisosSRV',
            type: 'POST',
            async: false,
            data: "action=consultaFunciones&idRow=" + idRrow,
            error: function (jqXHR, textStatus, errorThrown) {
                // body...
                alert('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                // body...
                //$('#tablainfo').children('tbody').html('');                                                        
                $('#tablafunciones').html(data);
                //alert(data);
            },
            complete: function (xhr, status) {
                /*
                 $('#tablafunciones').dataTable().fnDestroy();
                 $('#tablafunciones').DataTable({
                 scrollY: 300,
                 responsive: true,
                 searching: false,
                 lengthChange: false,
                 pageLength: 10,
                 language: {
                 "url": "json/Spanish.json"
                 }
                 
                 });
                 */

            }
        });
    }
</script>   
