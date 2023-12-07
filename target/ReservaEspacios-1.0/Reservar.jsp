
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de reserva</title>
    </head>
    <body>
        <h1>Esta es la pagina para reservar!</h1>
        
        <form action="SVReservas" method="POST">
            <label for="id_sala">Sala</label>
            <select name="id_sala" id="id_sala">
                <option value="">Seleccione una sala</option>
                <option value="1">Sala 1</option>
                <option value="2">Sala 2</option>
                <option value="3">Sala 3</option>
            </select>

            <!--<label for="fecha">Fecha</label>--> 
            <!--<input type="date" name="fecha" id="fecha">--> 

            <!--<label for="hora_inicio">Hora inicio</label> --> 
            <!--<input type="time" name="hora_inicio" id="hora_inicio"> -->

            <label for="date-time">Fecha y hora</label>
            <input type="datetime-local" name="datetime" id="date-time">

            <input type="submit" value="Reservar">
        </form>
            
    </body>
</html>
