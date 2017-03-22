<%-- 
    Document   : conmonedas
    Created on : 16/03/2017
    Author     : PaulReyes
--%>
<!DOCTYPE html>
<jsp:include page="verificasession.jsp" />
<jsp:include page="verificaaccesoxpagina.jsp?f=27"/>
<jsp:include page="encabezadopaginas.jsp" /> 
<%
    String servlet = "conmonedasSRV";
%>
<section id="container" >
    <form name="frmData" id="frmData" action="<%out.print(servlet);%>" method="post" >
    <jsp:include page="menuprincipal.jsp" /> 
    <jsp:include page="menuizquierdo.jsp" />
        <section id="main-content">
            <section class="wrapper site-min-height">
                <div class="row mt">
                    <div class="col-md-5">
                        <h3><i class="fa fa-angle-right"></i> Monto Monedas </h3>
                    </div>
                    <div class="col-md-1">
                        <button id="btnnuevo" class="btn btn-round btn-info btn-lg text-left" rel="tooltip" data-placement="bottom" title="Ingresar nuevo registro" >
                                <i class="fa fa-plus" aria-hidden="true"></i>
                        </button>  
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
                                
                                    <input type="hidden" id="action" name="action" value="action" />
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <span type="button" class="btn-primary btn-lg btn-block text-center" id="titulo_ope_form" >Nuevo Registro</span>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-2 control-label" >
                                                    ID
                                                </div>
                                                <div class="col-md-4">
                                                    <input placeholder="ID" class="form-control" type="text" name="Idmoneda" id="Idmoneda" maxlength="3"  required>
                                                </div>
                                                <div class="col-md-2 control-label" >
                                                    Moneda
                                                </div>
                                                <div class="col-md-4">
                                                    <input placeholder="Moneda" class="form-control" type="text" name="Moneda"  id="Moneda" maxlength="20" required>
                                                </div>                                     
                                            </div>
                                            <div class="row">
                                                <div class="col-md-2 control-label" >
                                                    Pa&iacute;s
                                                </div>
                                                <div class="col-md-4">
                                                    <input placeholder="Pa&iacute;s" class="form-control" type="text" name="Pais" id="Pais" maxlength="30" required>
                                                </div>
                                                <div class="col-md-2 control-label" >
                                                   Tipo de cambio
                                                </div>
                                                <div class=" col-md-4 " >
                                                    <input placeholder="Tipo de Cambio" class="form-control" type="text" name="Tipodecambio" id="Tipodecambio" maxlength="7"  required>
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
                        <jsp:include page="loading_modal.jsp" />
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
        $("[rel='tooltip']").tooltip();
        $("#tabs").tabs();
    });
</script>  
<script type="text/javascript">

    var showProcessModal = function(){
        $('#loading_modal').modal('show');
    };

    var hideProcessModal = function(){
        $('#loading_modal').modal('hide');
    };

    $(document).ready(function(){
        activaTab(0);
        habilita_deshabilita_Tab("d",1);     
        lista_todo_contenido('listar');
       
        $('#btncancelar').on('click', function (e) {
            e.preventDefault();
            if($('#action').val()==='editar'){$('#Idmoneda').attr("disabled", false);};
            $('#frmData')[0].reset();
            $('#frmData').addClass('hidden');
            habilita_deshabilita_Tab("h",0);
            activaTab(0);
            habilita_deshabilita_Tab("d",1);
            $('#btnnuevo').attr("disabled", false);
        });
        
        $('#btnnuevo').on('click',function(e){
            e.preventDefault();
            $('#action').val('nuevo');
            $('#titulo_ope_form').html('Nuevo Registro');
            $('#frmData').removeClass('hidden');
            $('#frmData')[0].reset();
            habilita_deshabilita_Tab("h",1);
            activaTab(1);
            habilita_deshabilita_Tab("d",0);
            $(this).attr("disabled", true);
            $('#btnenviar').attr("disabled", false);
        });
        
        $(document).on('click','.btneditar',function(e){
            e.preventDefault();
            lista_contenido('consulta',$(this).attr('id'),function(resp){
                if(resp){            
                    $('#action').val('editar');
                    $('#titulo_ope_form').html('Editar Registro');
                    $('#frmData')[0].reset();
                    $('#Idmoneda').attr("disabled", true);
                    $('#frmData').removeClass('hidden');
                    habilita_deshabilita_Tab("h",1);
                    activaTab(1);
                    habilita_deshabilita_Tab("d",0);
                    $('#btnnuevo').attr("disabled", true);
                }
            });
            
        });
        
        $('#frmData').submit(function(e){
            e.preventDefault();
            if($('#action').val() === 'nuevo'){
                nuevo_contenido($(this));
            }else{
                editar_contenido($(this));
            }
        });     
    });
   
    function lista_todo_contenido(valor){
        $.ajax({
            type: 'POST',
            async: false,
            url: $('#frmData').attr('action'),
            data: { 'action': valor },
            beforeSend: function () {
                showProcessModal();
                
            },
            complete: function(e){
                hideProcessModal();
                $('#tablainfo').dataTable().fnDestroy();
                $('#tablainfo').DataTable({
                    responsive: true,
                    searching: true,
                    lengthChange: false,
                    pageLength: 5,
                    language: {
                        "url": "assets/json/Spanish.json"
                    }
                });
            },
            success: function(resp){
                $('#tablainfo').html('');
                $('#tablainfo').html(resp);
            },
            error: function(resp){
                hideProcessModal();
                mensajen("Error","(AJX:erx02)No fue posible mostrar la información. Intente nuevamente.", 3000,'error');
            }
        });
    }
    
    function lista_contenido(valor,idrow,callback){
        $.ajax({
            type: 'POST',
            url: $('#frmData').attr('action'),
            data: {'action':valor,'idrow':idrow},
            dataType: 'json',
            beforeSend: function () {
                showProcessModal();
            },
            complete: function(e){
                hideProcessModal();
            },
            success: function(resp){
                callback(true);
                $('#Idmoneda').val(resp[0]['idmoneda']);
                $('#Moneda').val(resp[0]['moneda']);
                $('#Pais').val(resp[0]['pais']);
                $('#Tipodecambio').val(resp[0]['tipodecambio']);
            },
            error: function(msg){
                callback(false);
                hideProcessModal();
                mensajen("Error","(AJX:erx02)No fue posible mostrar la información. Intente nuevamente.", 3000,'error');
            }
        });
    }

    function nuevo_contenido(form){
        $.ajax({
            url: form.attr('action'),
            type: 'POST',
            data: form.serialize(),
            dataType: 'json',
            beforeSend: function () {
                $('#btnEviar').attr('disabled', true);
                showProcessModal();
            },
            complete: function(e){
                hideProcessModal();
            },
            success: function(resp){
                if(resp.respuesta === true ){
                    $('#tablainfo').html('');
                    lista_todo_contenido('listar'); 
                    $('#btnnuevo').attr("disabled", false);
                    habilita_deshabilita_Tab("h",0);
                    activaTab(0);
                    habilita_deshabilita_Tab("d",1);                  
                    mensajen("Correcto", resp.mensaje, 3000,'success');
                }else{
                    hideProcessModal();
                    mensajen("Error", resp.mensaje, 2000,'error');
                    $('#btnEviar').attr('disabled', false);
                }
            },
            error: function(jqXHR,estado,error){
                hideProcessModal();
                mensajen("Error","(AJX:erx01)No fue posible registrar la información. Intente nuevamente.", 2000,'error');
                $('#btnEviar').attr('disabled', false);
                return;
            }
        });
    };

    function editar_contenido(form) {
        $('#Idmoneda').attr("disabled", false);
        $.ajax({
            url: form.attr('action'),
            type: 'POST',
            data: form.serialize(),
            dataType: 'json',
            beforeSend: function () {
                $('#btnEviar').attr('disabled', true);
                showProcessModal();
            },
            complete: function(e){
                hideProcessModal();
            },
            success: function(resp){
                if(resp.respuesta === true ){
                    $('#tablainfo').html('');
                    lista_todo_contenido('listar'); 
                    $('#btnnuevo').attr("disabled", false);
                    habilita_deshabilita_Tab("h",0);
                    activaTab(0);
                    habilita_deshabilita_Tab("d",1);                  
                    mensajen("Correcto", resp.mensaje, 3000,'success');
                }else{
                    hideProcessModal();
                    mensajen("Error", resp.mensaje, 2000,'error');
                    $('#btnEviar').attr('disabled', false);
                }
            },
            error: function(jqXHR,estado,error){
                hideProcessModal();
                mensajen("Error","(AJX:erx03)No fue posible actualizar la información. Intente nuevamente.", 2000,'error');
                $('#btnEviar').attr('disabled', false);
                return;
            }
        });
    }
    
</script>   