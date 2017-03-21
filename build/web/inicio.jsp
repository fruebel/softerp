<!DOCTYPE html>
<jsp:include page="verificasession.jsp" /> 
<jsp:include page="encabezadopaginas.jsp" /> 
<section id="container" >

    <jsp:include page="menuprincipal.jsp" /> 
    <jsp:include page="menuizquierdo.jsp" />

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">

            <div class="row">
                <div class="col-lg-12 main-chart">

                    <!--div class="row mtbox">
                        <div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                            <div class="box1">
                                <span class="li_heart"></span>
                                <h3>933</h3>
                            </div>
                            <p>933 People liked your page the last 24hs. Whoohoo!</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_cloud"></span>
                                <h3>+48</h3>
                            </div>
                            <p>48 New files were added in your cloud storage.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_stack"></span>
                                <h3>23</h3>
                            </div>
                            <p>You have 23 unread messages in your inbox.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_news"></span>
                                <h3>+10</h3>
                            </div>
                            <p>More than 10 news were added in your reader.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_data"></span>
                                <h3>OK!</h3>
                            </div>
                            <p>Your server is working perfectly. Relax & enjoy.</p>
                        </div>

                    </div--><!-- /row mt -->	


                    <div class="row mt">
                        <!-- SERVER STATUS PANELS -->
                       
                        <div class="col-md-3 mb">
                            <!-- PANEL 1 -->
                            <div class="white-panel pn" >
                                <div class="white-header">
                                    <h5>CLIENTES</h5>
                                </div>
                                <p><i class='fa fa-users' style="font-size:  80px"></i></p>
                                <p><b>&nbsp;</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">CLIENTES MENSUALES</p>
                                        <p> 10 </p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">CLIENTES ANUALES</p>
                                        <p> 60 </p>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /col-md-3 -->

                         <div class="col-md-3 mb">
                            <!-- PANEL 1 -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>VENTAS</h5>
                                </div>
                                <p><i class='fa fa-usd' style="font-size:  80px"></i></p>
                                <p><b>&nbsp;</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">VENTAS MENSUALES</p>
                                        <p>$ 147,60</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">VENTAS ANUALES</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /col-md-3 -->
                        
                        <div class="col-md-3 mb">
                            <!-- PANEL 1 -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>PROVEEDORES</h5>
                                </div>
                                
                                <p><i class='fa fa-truck' style="font-size:  80px"></i></p>
                                <p><b>&nbsp;</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">PROVEEDORES MENSUALES</p>
                                        <p> 5 </p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">PROVEEDORES ANUALES</p>
                                        <p> 30 </p>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /col-md-3 -->
                        
                        <div class="col-md-3 mb">
                            <!-- PANEL 1 -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>COMPRAS</h5>
                                </div>
                                 <p><i class='fa fa-cart-plus' style="font-size:  80px"></i></p>
                                <p><b>&nbsp;</b></p>
                                
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">COMPRAS MENSUALES</p>
                                        <p>$ 147,60</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">COMPRAS ANUALES</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /col-md-3 -->                        
                        

                    </div><!-- /row -->



                    <div class="row mt">
                        <!--CUSTOM CHART START -->
                        <div class="border-head">
                            <h3>VENTAS X MES</h3>
                        </div>
                        <div class="custom-bar-chart">
                            <ul class="y-axis">
                                <li><span>10.000</span></li>
                                <li><span>8.000</span></li>
                                <li><span>6.000</span></li>
                                <li><span>4.000</span></li>
                                <li><span>2.000</span></li>
                                <li><span>0</span></li>
                            </ul>
                            <div class="bar">
                                <div class="title">JAN</div>
                                <div class="value tooltips" data-original-title="8.500" data-toggle="tooltip" data-placement="top">85%</div>
                            </div>
                            <div class="bar ">
                                <div class="title">FEB</div>
                                <div class="value tooltips" data-original-title="5.000" data-toggle="tooltip" data-placement="top">50%</div>
                            </div>
                            <div class="bar ">
                                <div class="title">MAR</div>
                                <div class="value tooltips" data-original-title="6.000" data-toggle="tooltip" data-placement="top">60%</div>
                            </div>
                            <div class="bar ">
                                <div class="title">APR</div>
                                <div class="value tooltips" data-original-title="4.500" data-toggle="tooltip" data-placement="top">45%</div>
                            </div>
                            <div class="bar">
                                <div class="title">MAY</div>
                                <div class="value tooltips" data-original-title="3.200" data-toggle="tooltip" data-placement="top">32%</div>
                            </div>
                            <div class="bar ">
                                <div class="title">JUN</div>
                                <div class="value tooltips" data-original-title="6.200" data-toggle="tooltip" data-placement="top">62%</div>
                            </div>
                            <div class="bar">
                                <div class="title">JUL</div>
                                <div class="value tooltips" data-original-title="7.500" data-toggle="tooltip" data-placement="top">75%</div>
                            </div>
                        </div>
                        <!--custom chart end-->
                    </div><!-- /row -->	

                </div><!-- /col-lg-9 END SECTION MIDDLE -->


                <!-- **********************************************************************************************************************************************************
                RIGHT SIDEBAR CONTENT
                *********************************************************************************************************************************************************** -->                  


            </div><! --/row -->
        </section>
    </section>
    <!--main content end-->
    <jsp:include page="copyright.jsp" />    
</section>

<jsp:include page="piepaginas.jsp" />      