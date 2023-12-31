
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

            <div class="w-full grid place-items-center">
                <form action="SVReservas" method="POST" class="flex flex-col gap-5 my-5 w-full max-w-[70%] p-5 bg-gray-100 rounded-xl" id="myForm">

                    <div>
                        <label for="user_name" class="block mb-2 text-sm font-medium text-gray-900">
                            Escribe tu nombre:
                        </label>
                        <input type="text" name="input_name" id="input_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="John Doe" required>
                    </div>

                    <div>
                        <label for="salas" class="block mb-2 text-sm font-medium text-gray-900">Selecciona una sala:</label>

                        <select id="input_hall" name="input_hall" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" onchange="updateRange()">
                            <option selected>Selecciona una opción</option>
                            <option value="Conf1">Sala de conferencias 1</option>
                            <option value="Conf2">Sala de conferencias 2</option>
                            <option value="Reu">Sala de reuniones</option>
                            <option value="Work1">Espacio de trabajo 1</option>
                            <option value="Work2">Espacio de trabajo 1</option>
                            <option value="office">Oficina compartida</option>
                        </select>
                    </div>

                    <!--<div>
                        <label for="visitors" class="block mb-2 text-sm font-medium text-gray-900">
                            Elige tu asiento
                        </label>
                        <input type="number" name="input_seat" id="input_seat" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" value="1" min="1" max="5" required>
                        <span id="error-msg" class="text-red-500 text-sm hidden">El valor está fuera de rango</span>
                    </div> -->
            
                    <div>
                        <label for="input_date" class="block mb-2 text-sm font-medium text-gray-900">Elige la fecha y hora:</label>
                        <input type="datetime-local" name="input_date" id="input_date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" required>
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
