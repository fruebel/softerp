<%@page import="soft.jf.seguridad.dao.SegmodulosDAO"%>
<%

    SegmodulosDAO accesomodulos;
    String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");
    int f1 = 0;

    if (request.getParameter("f") != null) {
        f1 = Integer.parseInt(request.getParameter("f"));
    }

    accesomodulos = new SegmodulosDAO();
    int acceso = accesomodulos.VerificaPaginaxUsuarios(sessionUsuario, f1);

    if (acceso == 0) {

        RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
        view.forward(request, response);
    }
    
    //out.print(acceso + " "  + sessionUsuario);


%>
