
package dev.Servlets;

import Entities.Espacio;
import Entities.Reservacion;
import dev.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet que sirve para crear nuevos espacios de ejemplo.
 * 
 * @author 
 */
@WebServlet(name = "SVSupport", urlPatterns = {"/SVSupport"})
public class SVSupport extends HttpServlet {

    Controladora control = new Controladora();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        control.crearEspacio("Sala de conferencias A", "Edificio principal, Piso 5", 50);
        control.crearEspacio("Oficina ejecutiva B", "Torre Norte, Piso 10", 8);
        control.crearEspacio("Sala de reuniones C", "Ala Este, Piso 3", 20);
        control.crearEspacio("Espacio colaborativo D", "Edificio Anexo, Planta baja", 30);
        control.crearEspacio("Sala de presentaciones E", "Centro de eventos, Salon 1", 100);
        
        List<Espacio> listaEspacios = new ArrayList<>();
        
        listaEspacios = control.obtenerEspacios();
        
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
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
