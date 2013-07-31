/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.serverlet;

import com.netbean.data.LiveStreaminInfo;
import com.netbean.data.ServerSocketGenerate;
import com.netbean.testdata.TestData;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dragonboy
 */
@WebServlet(name = "testopensocket", urlPatterns = {"/testopensocket"})
public class testopensocket extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/json;charset=UTF-8");
        int port = Integer.valueOf(request.getParameter("port"));
        PrintWriter out = response.getWriter();
        try {
            ServerSocket server = TestData.getServerSocket(port);
            TestData.lvStream = server.accept();
            System.out.println("open a demo live stream in :"+server.getLocalPort());
            out.println(server.getLocalPort());
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
