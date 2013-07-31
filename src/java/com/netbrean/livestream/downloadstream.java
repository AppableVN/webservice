/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbrean.livestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dragonboy
 */
@WebServlet(name = "downloadstream", urlPatterns = {"/downloadstream"})
public class downloadstream extends HttpServlet {

    public static ServletOutputStream outputstream;
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
        System.out.println("request: downloadstream");
        byte[] buffer = new byte[100000];
        
        outputstream = response.getOutputStream();
//        while(uploadstream.inputstream != null &&uploadstream.inputstream.isReady() && !uploadstream.inputstream.isFinished()){
        String webRootPath = getServletContext().getRealPath("/").replace('\\', '/');
        System.out.println("webRootPath:"+ webRootPath);
        FileInputStream fis = new FileInputStream(webRootPath+"/Stuck In My Heart - C21.mp3");
        while(true){
            int availbyte = Math.min(fis.available(), buffer.length);
            System.out.println("available:"+ availbyte);
            if(availbyte == 0) break;
            fis.read(buffer, 0, availbyte);
            outputstream.write(buffer, 0, availbyte);
        }
        
        
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet downloadstream</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet downloadstream at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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
