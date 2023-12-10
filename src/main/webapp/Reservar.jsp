<%@page import="java.util.List"%>
<%@page import="Entities.Espacio"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de reserva</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    
     <body>
        <div class="mt-20 flex flex-col items-center gap-5">
            <h1 class="text-4xl font-bold text-center">Reserva tu espacio</h1>
            <p class="text-xl max-w-[500px] text-center">Selecciona una opción para reservar tu espacio en la sala que desees</p>
            
            <div class="my-5">
                <a href="SVSupport" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none" >Agregar Espacios de prueba</a>
            </div>

            <div class="w-full grid place-items-center">
                <form action="SVReservas" method="POST" class="flex flex-col gap-5 my-5 w-full max-w-[70%] p-5 bg-gray-100 rounded-xl" id="myForm">

                    <div>
                        <label for="salas" class="block mb-2 text-sm font-medium text-gray-900">Selecciona una sala:</label>

                        <select id="input_hall" name="input_space" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" onchange="updateRange()">
                            <option selected>Selecciona un espacio a reservar</option>
                            
                            <% 
                                List<Espacio> list = (List) request.getSession().getAttribute("listaEspacios");
                                for (Espacio esp : list) {
                            %>
                                    <option value="<%=esp.getId()%>"><%=esp.getNombre()%> - <%=esp.getUbicacion()%> - <%=esp.getCapacidad()%></option>
                            <%} %>
                        </select>
                    </div>

                    <div>
                        <label for="input_date" class="block mb-2 text-sm font-medium text-gray-900">Elige la fecha y hora de Inicio (Los minutos y segundos seran siempre 0):</label>
                        <input type="datetime-local" name="input_date_start" id="input_date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" required>
                    </div>
                        
                    <div>
                        <label for="input_date" class="block mb-2 text-sm font-medium text-gray-900">Elige la fecha y hora de finalización (Los minutos y segundos seran siempre 0):</label>
                        <input type="datetime-local" name="input_date_stop" id="input_date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" required>
                    </div>
            
                    <div class="flex flex-col items-center">
                        <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">Reservar</button>
                    </div>
                </form>
            </div>
        </div>
            
    </body>
    
    <script>
        function updateRange() {
            let selectElement = document.getElementById('salas');
            let quantityInput = document.getElementById('quantity');

            if (selectElement.value === 'Conf1' || selectElement.value === 'Conf2') {
                quantityInput.setAttribute('min', '1');
                quantityInput.setAttribute('max', '10');
            } else if (selectElement.value === 'Reu') {
                quantityInput.setAttribute('min', '5');
                quantityInput.setAttribute('max', '15');
            } else if (selectElement.value === 'Work1' || selectElement.value === 'Work2') {
                quantityInput.setAttribute('min', '2');
                quantityInput.setAttribute('max', '8');
            } else if (selectElement.value === 'office') {
                quantityInput.setAttribute('min', '1');
                quantityInput.setAttribute('max', '5');
            }

            validateRange();
        }

        function validateRange() {
            let quantityInput = document.getElementById('quantity');
            let errorMsg = document.getElementById('error-msg');

            if (parseInt(quantityInput.value) < parseInt(quantityInput.min) || parseInt(quantityInput.value) > parseInt(quantityInput.max)) {
                errorMsg.classList.remove('hidden');
            } else {
                errorMsg.classList.add('hidden');
            }
        }

        document.getElementById('quantity').addEventListener('input', validateRange);
    </script>
</html>
