/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dev.Servlets;

import Entities.Espacio;
import Entities.Reserva;
import dev.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 */
@WebServlet(name = "SVReservas", urlPatterns = {"/SVReservas"})
public class SVReservas extends HttpServlet {
    
    Controladora control = new Controladora();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        
        List<Espacio> listaEspacios = new ArrayList<>();
        
        listaEspacios = control.obtenerEspacios();
        
        System.out.println("Lista de espacios: " + listaEspacios);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaEspacios", listaEspacios);
        
        response.sendRedirect("Reservar.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los datos
        String idSpaceStr = request.getParameter("input_space");
        int idSpace = Integer.parseInt(idSpaceStr);
        String fechaInicio = request.getParameter("input_date_start");
        String fechaFin = request.getParameter("input_date_stop"); 
        
        // Crear el formateador para las fechas
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm");
        
        // Obtener la lista de espacios
        List<Espacio> listaEspacios = new ArrayList<>();
        listaEspacios = control.obtenerEspacios();
        
        try {
            // Formatear las fechas
            Date fechaHoraInicio = formatter.parse(fechaInicio);
            Date fechaHoraFin = formatter.parse(fechaFin);
            
            // Setear los minutos y segundos en 0
            Calendar calendarioInicio = Calendar.getInstance();
            Calendar calendarioFin = Calendar.getInstance();
            
            calendarioInicio.setTime(fechaHoraInicio);
            calendarioFin.setTime(fechaHoraFin);
            
            calendarioInicio.set(Calendar.MINUTE, 0);
            calendarioInicio.set(Calendar.SECOND, 0);
            
            calendarioFin.set(Calendar.MINUTE, 0);
            calendarioFin.set(Calendar.SECOND, 0);
            
            Date fechaInicioFinal = calendarioInicio.getTime();
            Date fechaFinFinal = calendarioFin.getTime();
            
            // Obtener el espacio
            Espacio espacio = null;
            
            for (Espacio esp : listaEspacios) {
                if (esp.getId() == idSpace) {
                    espacio = esp;
                    break;
                }
            }
            
            if (espacio != null) {
                control.crearReserva(espacio, fechaInicioFinal, fechaFinFinal);
            }
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // TODO: AGREGAR A LA BASE DE DATOS
        //control.crearReserva(usuario, sala, formattedDateTime);
        
        response.sendRedirect("SVListaReservas");
        
        
    }


}
