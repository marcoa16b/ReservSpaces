/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dev.Servlets;

import Entities.Reserva;
import dev.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        
        List<Reserva> listaReservas = new ArrayList<>();
        
        listaReservas = control.obtenerReservas();
        
        System.out.println("Lista de reservas: " + listaReservas);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("Reservas.jsp");
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
        
        String usuario = request.getParameter("input_name");
        String sala = request.getParameter("input_hall");
        String fechaInput = request.getParameter("input_date"); 
        
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(fechaInput, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = localDateTime.format(outputFormatter);
        
        // TODO: AGREGAR A LA BASE DE DATOS
        control.crearReserva(usuario, sala, formattedDateTime);
        
        response.sendRedirect("SVListaReservas");
        
        
    }


}
