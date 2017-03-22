<!DOCTYPE html>
<jsp:include page="verificasession.jsp" /> 
<jsp:include page="verificaaccesoxpagina.jsp" />
<jsp:include page="encabezadopaginas.jsp" /> 

<%
    String servlet = "venclientesSRV";
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
                        <h3><i class="fa fa-angle-right"></i> Clientes</h3>
                    </div>
                    <div class="col-md-1">
                        <a  href='#' >
                            <button type="button" class="btn btn-round btn-info btn-lg " id="btnnuevo">
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
                                            <button type="button" class="btn btn-primary btn-lg btn-block" id="titulo_ope">Captura Cliente</button>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="panel panel-info">
                                        <div class="panel-heading">Datos Identificación del Cliente</div>
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-2 form-inline">
                                                    <label>ID Cliente:</label><br>
                                                    <input placeholder="ID Cliente" class="form-control" type="text" name="idcliente" id="idcliente" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-3 form-inline">
                                                    <label>RFC:</label><br>
                                                    <input placeholder="RFC" class="form-control" type="text" name="rfc" id="rfc" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-7 form-inline">
                                                    <label>Razon Social:</label><br>
                                                    <input placeholder="Razon Social" class="form-control" type="text" name="nombrecompleto" id="nombrecompleto" style="width:100%;">
                                                </div>
                                            </div>
                                            <div class="row" style="height:10px"></div>
                                            <div class="row">
                                                <div class="col-md-3 form-inline">
                                                    <label>Nombres: &nbsp;</label><br>
                                                    <input placeholder="Nombre" class="form-control" type="text" name="nombres" id="nombres" style="width:100%;" >
                                                </div>
                                                <div class="col-md-3 form-inline">
                                                    <label>Apellido Paterno: &nbsp;</label><br>
                                                    <input placeholder="Apellido Paterno" class="form-control" type="text" name="apellidopaterno" id="apellidopaterno"  style="width:100%;">
                                                </div>
                                                <div class="col-md-3 form-inline">
                                                    <label>Apellido Materno: &nbsp;</label><br>
                                                    <input placeholder="Apellido Materno" class="form-control" type="text" name="apellidomaterno" id="apellidomaterno"  style="width:100%;">
                                                </div>
                                                <div class="col-md-3 form-inline">
                                                    <label>CURP: &nbsp;</label><br>
                                                    <input placeholder="CURP" class="form-control" type="text" name="curp" id="curp" required style="width:100%;">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-info">
                                        <div class="panel-heading">Datos Domicilio del Cliente</div>
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-2 form-inline" >
                                                    <label>CP: &nbsp;</label><br>
                                                    <input placeholder="C.P." class="form-control" type="number" name="cp" id="cp" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-6 form-inline" >
                                                    <label>Calle: &nbsp;</label><br>
                                                    <input placeholder="Calle" class="form-control" type="text" name="calle" id="calle" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-2 form-inline" >
                                                    <label>Num. Exterior: &nbsp;</label><br>
                                                    <input placeholder="Num. Exterior" class="form-control" type="text" name="numexterior" id="numexterior" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-2 form-inline" >
                                                    <label>Num. Interior: &nbsp;</label><br>
                                                    <input placeholder="Num. Interior" class="form-control" type="text" name="numinterior" id="numinterior" style="width:100%;" required>
                                                </div>

                                            </div>
                                            <div class="row" style="height:10px"></div>
                                            <div class="row">
                                                <div class="col-md-4 form-inline" >
                                                    <label>Colonia: &nbsp;</label><br>
                                                    <input placeholder="Colonia" class="form-control" type="text" name="colonia" id="colonia" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-4 form-inline" >
                                                    <label>Municipio: &nbsp;</label><br>
                                                    <input placeholder="Municipio" class="form-control" type="text" name="municipio" id="municipio" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-4 form-inline" >
                                                    <label>Ciudad: &nbsp;</label><br>
                                                    <input placeholder="Colonia" class="form-control" type="text" name="ciudad" id="ciudad" style="width:100%;" required>
                                                </div>
                                            </div>
                                            <div class="row" style="height:10px"></div>
                                            <div class="row">
                                                <div class="col-md-4 form-inline" >
                                                    <label>Estado: &nbsp;</label><br>
                                                    <select name="idestado" id="idestado"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-4 form-inline" >
                                                    <label>Pais: &nbsp;</label><br>
                                                    <input placeholder="Pais" class="form-control" type="text" name="pais" id="pais" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-4 form-inline" >
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-info">
                                        <div class="panel-heading">Datos Configuración del Cliente</div>
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-2 form-inline" >
                                                    <label>Tipo Cliente: &nbsp;</label><br>
                                                    <select name="idtipocliente" id="idtipocliente"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-3 form-inline" >
                                                    <label>Termino Pago: &nbsp;</label><br>
                                                    <select name="idterminopago" id="idterminopago"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-3 form-inline" >
                                                    <label>Método de Pago: &nbsp;</label><br>
                                                    <select name="idmetodopago" id="idmetodopago"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-3 form-inline" >
                                                    <label>Lista Precio: &nbsp;</label><br>
                                                    <select name="idlistaprecio" id="idlistaprecio"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-1 form-inline" ></div>
                                            </div>
                                            <div class="row" style="height:10px"></div>
                                            <div class="row">

                                                <div class="col-md-2 form-inline" >
                                                    <label>Historial Cliente: &nbsp;</label><br>
                                                    <select name="idhistorialcliente" id="idhistorialcliente"  class="form-control" required>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 form-inline" >
                                                    <label>Descuento: &nbsp;</label><br>
                                                    <input placeholder="Desc" class="form-control" type="number" name="descuento" id="descuento" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-2 form-inline" >
                                                    <label>Limite Crédito: &nbsp;</label><br>
                                                    <input placeholder="Limite Crédito" class="form-control" type="number" name="limitecredito" id="limitecredito" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-2 form-inline" >
                                                    <label>Días Credito: &nbsp;</label><br>
                                                    <input placeholder="Días Crédito" class="form-control" type="number" name="diascredito" id="diascredito" style="width:100%;" required>
                                                </div>
                                                <div class="col-md-3 form-inline" >
                                                    <label>Cliente Desde: &nbsp;</label><br>
                                                    
                                                    
                                                    <input class="form-control" type="text" id="clientedesde" style="width:100%;" required>
                                                    
                                                </div>
                                                <div class="col-md-1 form-inline" ></div>
                                            </div>
                                        </div>
                                    </div>
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
        
        $( "#clientedesde" ).datepicker();
        
        
    });
</script>  
<script type="text/javascript">

    llenaLista("conestados", "idestado", "estado", "1", "idestado");
    llenaLista("ventiposclientes", "idtipocliente", "tipocliente", "1", "idtipocliente");
    llenaLista("venterminospago", "idterminopago", "terminopago", "1", "idterminopago");
    llenaLista("venmetodospago", "idmetodopago", "metodopago", "1", "idmetodopago");
    llenaLista("venlistasprecios", "idlistaprecio", "listaprecio", "1", "idlistaprecio");
    llenaLista("venhistorialcliente", "idhistorialcliente", "historialcliente", "1", "idhistorialcliente");
    
    pinta_contenido('listar');
    $('#titulo_ope').html('Captura Cliente');
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
        $('#titulo_ope').html('Captura Cliente');
         
    });

    $('#btnnuevo').on('click', function (e) {
        
        e.preventDefault();
        habilita_deshabilita_Tab("h",1);
        activaTab(1);
        habilita_deshabilita_Tab("d",0);
         
        limpiacampos();
        inhabilitacampos(false);
        $('#frmData').attr('action', '<%out.print(servlet);%>');
        $('#action').val('nuevo');
        $('#idRow').val(0);
        $('#idcliente').attr("readonly", false);
        $('#titulo_ope').html('Captura Cliente');
        $(this).attr("disabled", true);
        $('#btnenviar').attr("disabled", false);
        //$('#tab1').addClass("disabledTab");
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
                    
                    habilita_deshabilita_Tab("h",0);
                    activaTab(0);
                    habilita_deshabilita_Tab("d",1);
                   
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
        $('#titulo_ope').html('Editar Cliente');
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
                
                var cliente = data[0];
                $('#idcliente').val(cliente.idcliente);
                $('#rfc').val(cliente.rfc);
                $('#nombrecompleto').val(cliente.nombrecompleto);
                $('#nombre').val(cliente.nombre);
                $('#apellidopaterno').val(cliente.apellidopaterno);
                $('#apellidomaterno').val(cliente.apellidomaterno);
                $('#curp').val(cliente.curp);
                $('#cp').val(cliente.cp);
                $('#calle').val(cliente.calle);
                $('#numexterior').val(cliente.numexterior);
                $('#numinterior').val(cliente.numinterior);
                $('#colonia').val(cliente.colonia);
                $('#municipio').val(cliente.municipio);
                $('#ciudad').val(cliente.ciudad);
                $("#idestado option[value=" + cliente.idestado.idestado + "]").attr("selected", true);
                $('#pais').val(cliente.pais);
                $("#idtipocliente option[value=" + cliente.idtipocliente.idtipocliente + "]").attr("selected", true);
                $("#idterminopago option[value=" + cliente.idterminopago.idterminopago + "]").attr("selected", true);
                $("#idmetodopago option[value=" + cliente.idmetodopago.idmetodopago + "]").attr("selected", true);
                $("#idlistaprecio option[value=" + cliente.idlistaprecio.idlistaprecio + "]").attr("selected", true);
                $("#idhistorialcliente option[value=" + cliente.idhistorialcliente.idhistorialcliente + "]").attr("selected", true);
                $('#descuento').val(cliente.descuento);
                $('#limitecredito').val(cliente.limitecredito);
                $('#diascredito').val(cliente.diascredito);
                $('#clientedesde').val(cliente.clientedesde);
                


            }, complete: function (xhr, status) {

                habilita_deshabilita_Tab("h",1);
                activaTab(1);             
                inhabilitacampos(false);
                habilita_deshabilita_Tab("d",0);
            }

        });

    }

    autocomplete();
    function autocomplete() {
        $("#cp").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "venbuscarproductosSRV",
                    type: "POST",
                    dataType: "json",
                    data: {name: request.term},
                    success: function (data) {
                        response($.map(data, function (item) {

                            return {
                                label: item.name + '-' + item.nombreproducto + '-' + item.almacen,
                                value: item.value,
                                precio: item.precio,
                                stock: item.stock,
                                cantidad: item.cantidad,
                                codigo: item.codigo,
                                nombreproducto: item.nombreproducto,
                                preciounitario: item.preciounitario,
                                iva: item.iva,
                                total: item.total

                            }
                        }));
                    },
                    error: function (error) {
                        alert('error: ' + error);
                    }
                });
            },
            focus: function () {
                // prevent value inserted on focus
                //alert("focus");
                return false;
            },
            select: function (event, ui) {

                $("#txtbusca").val(ui.item.value);
                $("#precio").val(ui.item.precio);
                $("#stock").val(ui.item.stock);
                $("#cantidad").val(ui.item.cantidad);
                $("#codigo").val(ui.item.value);
                $("#nombreproducto").val(ui.item.nombreproducto);
                $("#preciounitario").val(ui.item.preciounitario);
                $("#ivaxproducto").val(ui.item.iva);
                $("#total").val(ui.item.total);
                return false;
            },
            search: function (event, ui) {
                //alert("busca este id -> " );
                //$("#txtbusca").val("");
                $("#precio").val("");
                $("#stock").val("");
                $("#cantidad").val("");
                $("#codigo").val("");
                $("#nombreproducto").val("");
                $("#preciounitario").val("");
                $("#total").val("");
                $("#ivaxproducto").val("");
            },
            minLength: 1
        });

    }
    
    function limpiacampos() {

        $('#idcliente').val('');
        $('#rfc').val('');
        $('#nombrecompleto').val('');
        $('#nombre').val('');
        $('#apellidopaterno').val('');
        $('#apellidomaterno').val('');
        $('#curp').val('');
        $('#cp').val('');
        $('#calle').val('');
        $('#numexterior').val('');
        $('#numinterior').val('');
        $('#colonia').val('');
        $('#municipio').val('');
        $('#ciudad').val('');
        $("#idestado option[value=''").attr("selected", true);
        $('#pais').val('');
        $("#idtipocliente option[value=''").attr("selected", true);
        $("#idterminopago option[value=''").attr("selected", true);
        $("#idmetodopago option[value=''").attr("selected", true);
        $("#idlistaprecio option[value=''").attr("selected", true);
        $("#idhistorialcliente option[value=''").attr("selected", true);
        $('#descuento').val('');
        $('#limitecredito').val('');
        $('#diascredito').val('');
        $('#clientedesde').val('');

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
        
        $('#idcliente').attr('readonly', valor);
        $('#rfc').attr('readonly', valor);
        $('#nombrecompleto').attr('readonly', valor);
        $('#nombre').attr('readonly', valor);
        $('#apellidopaterno').attr('readonly', valor);
        $('#apellidomaterno').attr('readonly', valor);
        $('#curp').attr('readonly', valor);
        $('#cp').attr('readonly', valor);
        $('#calle').attr('readonly', valor);
        $('#numexterior').attr('readonly', valor);
        $('#numinterior').attr('readonly', valor);
        $('#colonia').attr('readonly', valor);
        $('#municipio').attr('readonly', valor);
        $('#ciudad').attr('readonly', valor);
        $("#idestado").attr('readonly', valor);
        $('#pais').attr('readonly', valor);
        $("#idtipocliente").attr('readonly', valor);
        $("#idterminopago").attr('readonly', valor);
        $("#idmetodopago").attr('readonly', valor);
        $("#idlistaprecio").attr('readonly', valor);
        $("#idhistorialcliente").attr('readonly', valor);
        $('#descuento').attr('readonly', valor);
        $('#limitecredito').attr('readonly', valor);
        $('#diascredito').attr('readonly', valor);
        $('#clientedesde').attr('readonly', valor);


    }
    
    
</script>   
