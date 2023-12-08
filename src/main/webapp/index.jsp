<%-- 
    Document   : index
    Created on : 7 dic. 2023, 00:23:07
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="h-screen grid place-items-center">
        <div class="text-center flex flex-col">
            <h1 class="text-4xl font-bold">¡Bienvenido!</h1>
            <p class="opacity-75 text-lg">Ingrese para realizar su reservación o vea la lista de reservas.</p>
            <div class="mt-10 flex flex-col gap-8">
              <div>
                <a class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none" href="Reservar.jsp">Ingresar</a>
              </div>
              <div>
                <a href="SVListaReservas" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none">Ver reservas</a>
              </div>
            </div>
        </div>
    </body>
</html>