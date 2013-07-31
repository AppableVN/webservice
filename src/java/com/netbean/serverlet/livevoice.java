/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.serverlet;

import com.google.gson.Gson;
import com.netbean.data.LiveStreaminInfo;
import com.netbean.data.ServerSocketGenerate;
import com.netbean.data.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dragonboy
 */
@WebServlet(name = "livevoice", urlPatterns = {"/livevoice"}, initParams = {
    @WebInitParam(name = "type", value = "1")})
public class livevoice extends HttpServlet {

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
        String userid = request.getParameter("userid");
        response.setContentType("text/json;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        if(userid == null || userid.isEmpty()){
            try{
                out.println(0);
            }finally{
                out.close();
            }
            return;
        }
        
        UserInfo uInfo = UserInfo.getUserInfoById(Integer.valueOf(userid));
        if(uInfo == null || !uInfo.state){
            try{
                out.println(0);
            }finally{
                out.close();
            }
            return;
        }
        
        ArrayList<LiveStreaminInfo> listStreamofUser = LiveStreaminInfo.getLiveStreamByUser(uInfo.userid);
        if(!listStreamofUser.isEmpty()){
            try{
                out.println(0);
            }finally{
                out.close();
            }
            return;
        }
        
        try {
            /* TODO output your page here. You may use following sample code. */
            LiveStreaminInfo lsInfo = new LiveStreaminInfo();
            lsInfo.status = true;
            lsInfo.streamName = userid;
            lsInfo.username = uInfo.username;
            lsInfo.userid = uInfo.userid;
            lsInfo.streamId = lsInfo.streamName.hashCode();
            ServerSocket lsSocket = ServerSocketGenerate.getServerSocket();
            lsInfo.port = lsSocket.getLocalPort();
            lsInfo.streamAddress = lsSocket.getInetAddress().getHostAddress();
            lsSocket.accept();
            Gson gs = new Gson();
            out.println(gs.toJson(lsInfo));
        }catch(IOException ex){
            out.println(0);
        } 
        finally {            
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
