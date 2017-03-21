<%
    /**
     * Obtengo las variables de session
     */
    String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");
    if (sessionUsuario == null || sessionUsuario.equals("")) {
        RequestDispatcher view = request.getRequestDispatcher("index.html");
        view.forward(request, response);
    }
    
%>