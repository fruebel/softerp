<%@page import="soft.jf.seguridad.modelos.Segfunciones"%>
<%@page import="soft.jf.seguridad.modelos.Segmodulos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="soft.jf.seguridad.dao.SegmodulosDAO" %>
<%
    SegmodulosDAO modulos;
    modulos = new SegmodulosDAO();
    ArrayList<Segmodulos> listaModulos = new ArrayList<>();
    ArrayList<Segfunciones> listaFuncionesxModulo = new ArrayList<>();
    String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");
    String idModulo = request.getParameter("idmodulo");
    String inicioactive="";
    if(idModulo.equals("0")){
        inicioactive = "active";
    }
%>
<!-- 
**********************************************************************************************************************************************************
           MAIN SIDEBAR MENU
*********************************************************************************************************************************************************** -->
<!--sidebar start-->
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">

            <p class="centered"><a href="#"><img src="assets/img/avatar-male.png" class="img-circle" width="60"></a></p>
            <h5 class="centered"><%out.print(sessionUsuario);%></h5>

            <li class="mt">
                <a class="<%out.print(inicioactive);%>" href="inicio.jsp?idmodulo=0">
                    <i class="fa fa-dashboard"></i>
                    <span>Estadisticas</span>
                </a>
            </li>
            <%
                listaModulos = modulos.listarMenuPrincipal();
                int contador;
                String active;

                for (Segmodulos m : listaModulos) {
                    contador = 0;
                    //<!-- Crea Submenus x Modulos -->
                    active="";
                    if (m.getIdmodulo() == Integer.parseInt(idModulo)){
                        active = "active";
                    }
                    
                    out.println("<li class='sub-menu'>");
                    out.println("<a class='"+active+"' href='javascript:;' >");
                    out.println("<i class='"+m.getImagen()+"'></i>");
                    out.println("<span>"+m.getTitulo()+"</span>");
                    out.println("</a>");
                    
                    //imprime el submenu
                    
                    listaFuncionesxModulo = modulos.listarFuncionesXSubmenu(m.getIdmodulo(), sessionUsuario);
                    if (listaFuncionesxModulo.size() > 0) {
                         out.println("<ul class='sub'>");
                         for (Segfunciones f : listaFuncionesxModulo) {
                             out.println("<li><a  href='"+f.getUrl()+"&idmodulo="+m.getIdmodulo()+"'>"+f.getTitulo()+"</a></li>");
                         }
                         out.println("</ul>");
                    }                    
                    out.println("</li>");
                }
            %>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->