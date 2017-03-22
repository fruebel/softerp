<!DOCTYPE html>
<jsp:include page="verificasession.jsp" />
<jsp:include page="verificaaccesoxpagina.jsp?f=5"/>
<jsp:include page="encabezadopaginas.jsp" /> 

<%
    String servlet = "usuariosSRV";
%>
<section id="container" >

    <jsp:include page="menuprincipal.jsp" /> 
    <jsp:include page="menuizquierdo.jsp" />

    <form name="frmData" id="frmData" action="<%out.print(servlet);%>" method="post">
        <input type="hidden" id="action" name="action" value="action" /> 
        <input type="hidden" id="idRow" name="idRow" value="idRow" /> 

        <!--
        Campos ocultos para captura de datos del producto seleccionado
        -->
        <input type="hidden" id="rows" name="rows" value="1" /> 
        <input type="hidden" id="cantidad" name="cantidad" value=""/>
        <input type="hidden" id="codigo" name="codigo" value=""/>
        <input type="hidden" id="nombreproducto" name="nombreproducto" value=""/>
        <input type="hidden" id="preciounitario" name="preciounitario" value=""/>
        <input type="hidden" id="ivaxproducto" name="ivaxproducto" value=""/>
        <input type="hidden" id="total" name="total" value=""/>
        <input type="hidden" id="idcliente" name="idcliente" value="0"/>
        <input type="hidden" id="valsubtotal" name="valsubtotal" value="0"/>
        <input type="hidden" id="valiva" name="valiva" value="0"/>
        <input type="hidden" id="valtotal" name="valtotal" value="0"/>
        <!--Fin-->

        <!--
        Modal Productos
        -->
        <div class="modal fade" id="modalproductos" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            <i class="fa fa-search" aria-hidden="true"></i>
                            Busqueda de Productos
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">

                            <div class="col-md-6 form-inline">

                                x Codigo: <input  type="text" name="txtcodigoproducto" id="txtcodigoproducto" required value="" class="form-control" placeholder="Codigo Producto" />

                            </div>
                            <div class="col-md-6 form-inline">

                                x Descripcion: <input  style="width: 50%" type="text" name="txtdescripcion" id="txtdescripcion" value="" class="form-control" placeholder="Descripcion" />
                                <button type="button" class="btn btn-primary" id="buscarproductos">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </div>                            

                        </div>
                        <div class="row mt" >
                            <div class="col-md-12">             
                                <table id="tablainfoproductos"   class="nowrap_table table table-striped no-wrap responsive hover "  width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>idProducto</th>
                                            <th>Categoria</th>
                                            <th>Descripcion</th>
                                            <th>Costo</th>
                                            <th>U.Medida</th>

                                        </tr>
                                    </thead>
                                </table>
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="cerrarproductos">Cerrar</button>
                        <!--button type="button" class="btn btn-primary" id="procesaclientes">Procesar</button-->
                    </div>
                </div>

            </div>
        </div> 

        <!--
        Modal Clientes
        -->
        <div class="modal fade" id="modalclientes" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            <i class="fa fa-search" aria-hidden="true"></i>
                            Busqueda de Clientes
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">

                            <div class="col-md-6 form-inline">

                                x Nombre: <input type="text" name="txtcliente" id="txtcliente" required value="" class="form-control" placeholder="Nombre Cliente" />

                            </div>
                            <div class="col-md-6 form-inline">

                                x Rfc: <input type="text" name="txtrfc" id="txtrfc" value="" class="form-control" placeholder="Rfc" />
                                <button type="button" class="btn btn-primary" id="buscarclientes">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </div>                            

                        </div>
                        <div class="row mt" >
                            <div class="col-md-12">             
                                <table id="tablainfoclientes"   class="nowrap_table table table-striped no-wrap responsive hover "  width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>Rfc</th>
                                            <th>Direccion</th>
                                            <th>Ciudad</th>
                                            <th>Estado</th>

                                        </tr>
                                    </thead>
                                </table>
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="cerrarclientes">Cerrar</button>
                        <!--button type="button" class="btn btn-primary" id="procesaclientes">Procesar</button-->
                    </div>
                </div>

            </div>
        </div>  

        <!--
        Modal generar venta
        -->
        <div class="modal fade" id="modalgeneracobro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            <i class="fa fa-usd" aria-hidden="true"></i>
                            Generar Cobro
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="well well-sm text-center" id="lbltotalacobrar" style="font-size: 32px;background-color: rgb(68,157,68);color: white">                                   
                                </div>
                            </div>                    
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12" >
                                Forma de Pago<select style="width: 100%" name="formapago" id="formapago" class="form-control">
                                </select>
                            </div>                    
                        </div>
                        <div class="row mt">
                            <div class="col-md-12 col-sm-12" >
                                Dinero Recibido 
                                <input style="width: 100%" type="text" class="form-control" placeholder="" name="dinerorecibido" id="dinerorecibido" />
                            </div>                    
                        </div>
                    </div>
                    <div class="modal-footer">
                        <!--button type="button" class="btn btn-default" id="cerrarcobro">Cerrar</button-->
                        <button type="button" class="btn btn-primary btn-block" id="procesacobro">
                            <h4>Cobrar</h4>
                        </button>
                    </div>
                </div>

            </div>
        </div>  

        <section id="main-content">
            <section class="wrapper site-min-height">


                <div class="row mt">
                    <div class="col-md-12">    
                        <div class="panel panel-default">
                            <a href="../../erp/web/cotizador.jsp"></a>
                            <div class="panel-heading">

                                <h3 class="panel-title">

                                    <i class="fa fa-shopping-cart" aria-hidden="true" style="font-size: 50px"></i> 
                                    <b style="font-size: 30px;margin-left: 3%"> Registro de Ventas </b>


                                    <div class="btn-group" style="float: right">
                                        <button type="button" class="btn btn-success btn-lg" id="btngenerarcobro">
                                            <i class="fa fa-shopping-basket" aria-hidden="true" style="font-size: 20px" ></i>
                                            Generar Venta
                                        </button>
                                        <button type="button" class="btn btn-info btn-lg">
                                            <i class="fa fa-search" aria-hidden="true" style="font-size: 20px"></i>
                                            Buscar Cotizacion
                                        </button>
                                    </div>  

                                </h3>


                            </div>
                            <div class="panel-body ">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="row">
                                            <div class="col-md-12">

                                                <div class="row">
                                                    <div class="col-md-6 form-inline">
                                                        Codigo: 
                                                        <input style="width: 60%" type="text" class="form-control" placeholder="" name="txtbusca" id="txtbusca" />
                                                        <button class="btn btn-success btn-lg fa fa-cart-arrow-down" id="agregarproducto" data-toggle="tooltip" data-placement="bottom"  title="Agregar Producto" ></button>
                                                        <button class="btn btn-info btn-lg fa fa-file-powerpoint-o" id="btnbuscarproductos" data-toggle="tooltip" data-placement="bottom"  title="Buscar Producto"></button>    
                                                    </div>
                                                    <div class="col-md-3 form-inline">
                                                        Precio 
                                                        <input type="text" style="width:70%" class="form-control" placeholder="precio" readonly name="precio" id="precio" />
                                                    </div>
                                                    <div class="col-md-3 form-inline">
                                                        Stock
                                                        <input type="text" style="width:70%" class="form-control" placeholder="stock" readonly name="stock" id="stock" />
                                                    </div>                                                   
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row mt" style="display: none" id="row_alerta">

                                            <div class="col-md-6">
                                                <div class="alert alert-danger" role="alert" id="alerta">

                                                </div>
                                            </div>

                                        </div>
                                        <div class="row mt" >
                                            <div class="col-md-12">             
                                                <table id="tablainfo"   class="nowrap_table table table-striped no-wrap responsive hover "  width="100%" cellspacing="0">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Cantidad</th>
                                                            <th>Codigo</th>
                                                            <th>Nombre</th>
                                                            <th>Precio Unit</th>                                                           
                                                            <th>Total</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>

                                        </div>

                                    </div>
                                    <div class="col-md-4">
                                        <div class="row">			
                                            <div class="col-md-12 col-sm-12">
                                                <div class="well well-sm text-center" id="lbltotal" style="font-size: 32px;background-color: rgb(68,157,68);color: white">
                                                    $0.00
                                                </div>
                                            </div>
                                        </div>	
                                        <div class="row">
                                            <div class="col-md-12 form-inline">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Cliente</div>
                                                    <div class="panel-body">
                                                        Cliente: 
                                                        <input readonly type="text" style="width: 77%" class="form-control" id="nombrecliente" name="nombrecliente" placeholder="Nombre" value="Publico General" /> 
                                                        <button id="btnmodalclientes" class="btn btn-success btn-xs" ><i class="fa fa-address-book-o" aria-hidden="true"></i></button>    
                                                        <br />
                                                        <br />
                                                        Documento: 
                                                        <select style="width: 77%" name="documento" id="documento" class="form-control">

                                                        </select>
                                                    </div>
                                                </div>
                                            </div>    
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 form-inline">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Total de Compra</div>
                                                    <div class="panel-body">
                                                        <div class="row">
                                                            <div class="col-md-12 ">
                                                                <h4><b>Total de Productos:</b>&nbsp;<totalproductos id="numeroproductos">0</totalproductos></h4>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-12" id="subtotal">
                                                                <h4><b>Subtotal:</b>&nbsp;<subtotal>$0.0000</subtotal></h4>
                                                            </div>
                                                        </div>  
                                                        <div class="row">
                                                            <div class="col-md-12" id="iva">
                                                                <h4><b>IVA:</b>&nbsp;<iva >$0.0000</iva></h4>
                                                            </div>
                                                        </div>  
                                                        <div class="row">			
                                                            <div class="col-md-12 col-sm-12" id="total2">
                                                                <div class="well well-sm text-center" id="lbltotal2" style="font-size: 32px;background-color: rgb(255,215,119);color: white">
                                                                    Total: $0.00
                                                                </div>
                                                            </div>
                                                        </div>	
                                                    </div>
                                                </div>
                                            </div>    
                                        </div>

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
<a href="../../erp/web/cotizador.jsp"></a>

<jsp:include page="piepaginas.jsp" />  


<script>
    $(function () {
        $("#").datepicker();
    });
</script>
<script type="text/javascript">



    llenaLista("venmetodospago", "idmetodopago", "metodopago", "1", "formapago");
    llenaLista("contipostransacciones", "idtipotransaccion", "tipotransaccion", "1", "documento");

    $("#cerrarclientes").on("click", function (e) {
        e.preventDefault();
        $('#modalclientes').modal('hide');
    });

    $("#cerrarproductos").on("click", function (e) {
        e.preventDefault();
        $('#modalproductos').modal('hide');
    });

    $('#modalgeneracobro').on('hide.bs.modal', function (e) {
        $(this).find('.modal-body').find('input').val('');
        $(this).find('.modal-body').find('select').val('');
    });

    $('#modalclientes').on('hide.bs.modal', function (e) {
        $(this).find('.modal-body').find('input').val('');
        $(this).find('.modal-body').find('select').val('');
        $('#tablainfoclientes').DataTable().clear().draw();
    });

    $('#modalproductos').on('hide.bs.modal', function (e) {
        $(this).find('.modal-body').find('input').val('');
        $(this).find('.modal-body').find('select').val('');
        $('#tablainfoproductos').DataTable().clear().draw();
    });
    $(document).ready(function () {

        $("#rows").val("0");
        $("#nombrecliente").val("Publico General");
        $("#idcliente").val(0);
        $("#txtbusca").val("");
        $("#stock").val("");
        $("#precio").val("");

        $('#tablainfo').DataTable({
            "paging": true,
            "pageLength": 5,
            "processing": true,
            "responsive": true,
            "searching": true,
            "language": {
                "url": "assets/json/Spanish.json"
            }
        });
        $('#tablainfoclientes').DataTable({
            "paging": true,
            "pageLength": 5,
            "processing": true,
            "responsive": true,
            "searching": true,
            "language": {
                "url": "assets/json/Spanish.json"
            }
        });
        $('#tablainfoproductos').DataTable({
            "paging": true,
            "pageLength": 5,
            "processing": true,
            "responsive": true,
            "searching": true,
            "language": {
                "url": "assets/json/Spanish.json"
            }
        });
    });


    $("#buscarproductos").on("click", function (e) {
        e.preventDefault();
        $.ajax({
            beforeSend: function () {
                // body...
            },
            url: 'venbuscarproductosavanzadaSRV',
            type: 'POST',
            async: false,
            data: "idproducto=" + $("#txtcodigoproducto").val() + "&descripcion=" + $("#txtdescripcion").val(),
            error: function (jqXHR, textStatus, errorThrown) {
                alerta('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                $('#tablainfoproductos').html(data);
            },
            complete: function (xhr, status) {

                $('#tablainfoproductos').dataTable().fnDestroy();

                $('#tablainfoproductos').DataTable({
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

    });

    $("#buscarclientes").on("click", function (e) {
        e.preventDefault();
        $.ajax({
            beforeSend: function () {
                // body...
            },
            url: 'venbuscaclientesSRV',
            type: 'POST',
            async: false,
            data: "txtcliente=" + $("#txtcliente").val() + "&txtrfc=" + $("#txtrfc").val(),
            error: function (jqXHR, textStatus, errorThrown) {
                alerta('Se produjo un error : ' + errorThrown + ' ' + textStatus);
            },
            success: function (data) {
                $('#tablainfoclientes').html(data);
            },
            complete: function (xhr, status) {

                $('#tablainfoclientes').dataTable().fnDestroy();

                $('#tablainfoclientes').DataTable({
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

    });

    $("#btnbuscarproductos").on("click", function (e) {
        e.preventDefault();
        $('#modalproductos').modal('show');
        $('#txtcodigoproducto').blur();
    });

    $("#btnmodalclientes").on("click", function (e) {
        e.preventDefault();
        $('#modalclientes').modal('show');
    });

    $("#btngenerarcobro").on("click", function (e) {
        e.preventDefault();
        $('#modalgeneracobro').modal('show');

        var total = parseInt($("#valtotal").val());
        $("#lbltotalacobrar").html("Total a Cobrar: $" + total.toFixed(3));
    });


    function seleccionap(data, event) {

        event.preventDefault();
        var idproducto = data.id;
        //alert(idcliente);
        $('#modalproductos').modal('hide');
        $("#txtbusca").val(idproducto);
        $("#txtbusca").autocomplete('search', idproducto);

    }

    function selecciona(data, event) {

        event.preventDefault();
        var idcliente = data.id;
        //alert(idcliente);
        $('#modalclientes').modal('hide');
        var dataseleccionada = idcliente.split("|");
        $("#nombrecliente").val(dataseleccionada[1]);
        $("#idcliente").val(dataseleccionada[0]);
    }

    $("#agregarproducto").on("click", function (e) {
        e.preventDefault();

        /*****************************************/
        //Validaciones
        /*****************************************/
        if ($("#txtbusca").val() == '') {
            alerta("Introduzca el producto");
            return;
        }


        var existe = 0;
        for (ren = 0; ren <= parseInt($("#rows").val()); ren++) {
            obj3 = $("#codigo" + ren).val();
            if (typeof obj3 != "undefined") {
                if (obj3 == $("#txtbusca").val()) {
                    alerta("Producto duplicado");
                    existe = 1;
                }
            }
        }
        if (existe == 1)
            return;


        $.ajax({
            beforeSend: function () {
                // body...
            },
            url: 'venbuscaproductoxid',
            type: 'POST',
            async: false,
            data: "idproducto=" + $("#txtbusca").val(),
            error: function (jqXHR, textStatus, errorThrown) {
            },
            success: function (data) {
                //alert(data);
                existe = data;
            },
            complete: function (xhr, status) {
            }
        });
        if (existe == 0) {
            alerta("Producto " + $("#txtbusca").val() + " no existe");
            return;
        }

        /*****************************************/
        //Fin Validaciones
        /*****************************************/

        var i = parseInt($("#rows").val()) + 1;


        var numero = i;
        var cantidad = '<input type="text" class="form-control" name="cantidad' + i + '" id="cantidad' + i + '" value="' + $("#cantidad").val() + '">'; //$("#descripcion").val();
        var codigo = $("#codigo").val() + '<input type="hidden"  name="codigo' + i + '" id="codigo' + i + '" value="' + $("#codigo").val() + '">'; //$("#idcategoria").val();
        var nombre = $("#nombreproducto").val() + '<input type="hidden"  name="nombreproducto' + i + '" id="nombreproducto' + i + '">';
        var preciounitario = $("#preciounitario").val() + '<input type="hidden"  name="preciounitario' + i + '" id="preciounitario' + i + '" value="' + $("#preciounitario").val() + '"> <input type="hidden"  name="ivaxproducto' + i + '" id="ivaxproducto' + i + '" value="' + $("#ivaxproducto").val() + '">';
        //var iva = $("#ivaxproducto").val() + '<input type="hidden"  name="ivaxproducto' + i + '" id="ivaxproducto' + i + '" value="' + $("#ivaxproducto").val() + '">';
        var total = '<input type="text" class="form-control" readonly name="total' + i + '" id="total' + i + '" value="' + $("#total").val() + '">';
        var botoneliminar = '<button class="btn btn-danger btn-xs" onclick="eliminar(this)" ><i class="fa fa-trash-o "></i></button>';


        var table = $('#tablainfo').DataTable();
        var rowNode = table
                .row.add([numero, cantidad, codigo, nombre, preciounitario, total, botoneliminar])
                .draw()
                .node();


        $("#cantidad" + i)
                .focusout(function () {

                    var ok = validarSiNumero($("#cantidad" + i).val());
                    if (!ok) {
                        alerta("Introduzca un numero en la cantidad");
                        $("#cantidad" + i).val("0");
                        document.getElementById("cantidad" + i).focus();

                    }

                    var nuevovalpreciototal = 0;
                    nuevovalpreciototal = parseInt($("#preciounitario" + i).val()) * parseInt($("#cantidad" + i).val());
                    $("#total" + i).val(nuevovalpreciototal.toFixed(3));
                    calculaTotales();
                })

        $(rowNode)
                .css('color', 'red')
                .animate({color: 'black'});
        $("#rows").val(i);
        $("#numeroproductos").html(numero);

        calculaTotales();
        inicializacampos();
    });

    function eliminar(obj) {

        var table = $('#tablainfo').DataTable();
        table
                .row($(obj).parents('tr'))
                .remove()
                .draw();


        calculaTotales();

        var cantidad = $("#rows").val();
        cantidad = cantidad - 1;
        $("#rows").val(cantidad);
        cantidad = $("#rows").val();
        $("#numeroproductos").html(cantidad);
    }

    function calculaTotales() {

        var ren;
        var obj3;
        var total = 0;
        var iva = 0;
        var cantidad = 0;


        for (ren = 0; ren <= parseInt($("#rows").val()); ren++) {

            obj3 = $("#total" + ren).val();
            if (typeof obj3 != "undefined") {
                if (obj3 != '') {
                    total += parseInt($("#total" + ren).val());
                    cantidad = $("#cantidad" + ren).val()
                    iva += parseInt($("#ivaxproducto" + ren).val()) * parseInt(cantidad);
                }
            }
        }

        var total2 = parseInt(total) + parseInt(iva);
        $("#lbltotal").html("<b>$" + total.toFixed(3) + "</b>");
        $("#subtotal").html("<h4><b>Subtotal:</b>&nbsp;<subtotal>$" + total.toFixed(3) + "</subtotal></h4>");
        $("#iva").html(" <h4><b>IVA:</b>&nbsp;<iva >$" + iva.toFixed(3) + "</iva></h4>");
        $("#lbltotal2").html('Total: $' + total2.toFixed(3));

        //asigan valores totales
        $("#valsubtotal").val(total);
        $("#valiva").val(iva);
        $("#valtotal").val(total2);

    }

    $("#buscarproductos").on("click", function (e) {
        e.preventDefault();
    });

    autocomplete();
    function autocomplete() {
        $("#txtbusca").autocomplete({
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

    function inicializacampos() {

        $("#txtbusca").val("");
        $("#precio").val("");
        $("#stock").val("");

    }

    $("#procesacobro").on("click", function (e) {
        e.preventDefault();
        var data = $("#frmData").serialize();
        
        $.ajax({
            beforeSend: function () {
                
            },
            url: 'vengeneraventaSRV',
            type: 'POST',
            async: false,
            data: "idproducto=" + $("#txtbusca").val(),
            error: function (jqXHR, textStatus, errorThrown) {
            },
            success: function (data) {
                //alert(data);
                existe = data;
            },
            complete: function (xhr, status) {
            }
        });


        window.open('imprimeticket.jsp?id=', '_blank');
    });

</script>

