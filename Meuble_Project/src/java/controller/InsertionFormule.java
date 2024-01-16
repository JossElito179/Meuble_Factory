/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ConnectionBase;
import models.FormuleCreation;

/**
 *
 * @author joss
 */
public class InsertionFormule extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertionFormule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertionFormule at " + request.getContextPath() + "</h1>");
            ConnectionBase connex=new ConnectionBase();
            String categorie=request.getParameter("categorie");
            String style=request.getParameter("style");
            String grandeur=request.getParameter("grandeur");
            String [] matieres=request.getParameterValues("matiere");
            String [] quantite=request.getParameterValues("quantite");
            FormuleCreation formcreat=new FormuleCreation();
            for(int i=0;i<matieres.length;i++){
                
                formcreat.setId_Categorie(Integer.valueOf(categorie));
                formcreat.setQuantite(Double.valueOf(quantite[i]));
                formcreat.setId_FormuleCreation(0);
                formcreat.setId_Style(Integer.valueOf(style));
                formcreat.setId_Grandeur(Integer.valueOf(grandeur));
                formcreat.setId_MatierePremiere(Integer.valueOf(matieres[i]));
                formcreat.insertDAO(connex, "*");
            }
            RequestDispatcher disp=request.getRequestDispatcher("index.jsp");
            disp.forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
