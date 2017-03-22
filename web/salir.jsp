<%
    session.setAttribute("sessionUsuaurio", "");
    RequestDispatcher view;
    view = request.getRequestDispatcher("index.html");
    view.forward(request, response);

   
%>
