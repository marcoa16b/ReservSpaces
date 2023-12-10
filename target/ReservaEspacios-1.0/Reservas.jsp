<%@page import="java.util.List"%>
<%@page import="Entities.Reservacion"%> 
<%@page import="java.text.SimpleDateFormat"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="flex flex-col items-center py-10">
        <h1 class="text-4xl text-gray-900 font-bold mb-5">Lista de reservas</h1>
        
        <div class="relative overflow-x-auto">
            <table class="w-full text-sm text-left rtl:text-right text-gray-500">
              <thead class="text-xs text-gray-700 uppercase bg-gray-200">
                <tr>
                  <th scope="col" class="px-6 py-3">
                    ID
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Espacio
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Inicio
                  </th>
                  <th scope="col" class="px-6 py-3">
                    Fin
                  </th>
                </tr>
              </thead>
              <tbody>
                  <% 
                    List<Reservacion> list = (List) request.getSession().getAttribute("listaReservas");
                    int cont = 1;
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    for (Reservacion resv : list) {
                        String resvNombre = resv.getEspacio().getNombre();
                        String resvFechaInicio = formato.format(resv.getFechaInicio());
                        String resvFechaFin = formato.format(resv.getFechaFin());
                  %>
                  
                        <tr class="bg-white border-b">
                            <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
                                <%=resv.getId()%>
                            </th>
                            <td class="px-6 py-4">
                                <%=resvNombre%>
                            </td>
                            <td class="px-6 py-4">
                                <%=resvFechaInicio%>
                            </td>
                            <td class="px-6 py-4">
                                <%=resvFechaFin%>
                            </td>
                        </tr>

                    <% } %>
              </tbody>
            </table>
          </div>
        
    </body>
</html>
