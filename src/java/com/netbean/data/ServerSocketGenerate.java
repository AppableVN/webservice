/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.data;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.net.ServerSocketFactory;

/**
 *
 * @author Dragonboy
 */

public class ServerSocketGenerate {
    
    private static ArrayList<ServerSocket> listServerSocket = new ArrayList<ServerSocket>();
    public static ArrayList<ServerSocket> getListServerSocket(){
        if(listServerSocket == null) listServerSocket = new ArrayList<ServerSocket>();
        return listServerSocket;
    }
    
    private final static int MIN_PORT_RANGE = 10000;
    private final static int MAX_PORT_RANGE = MIN_PORT_RANGE + 100;
    
    public static ServerSocket getServerSocket() throws IOException{
        for(int port = MIN_PORT_RANGE; port<= MAX_PORT_RANGE;port++){
            try{
                return new ServerSocket(12345); 
            }catch(IOException ex){
                continue;
            }
        }
        throw new IOException("no free port found");
    }
    
    public static ServerSocket getSSFromList(int port){
        for(ServerSocket ss: listServerSocket){
            if(ss.getLocalPort() == port ){
                return ss;
            }
        }
        return null;
    }
    
    public static void closeServerSocket(int port){
        if(port < MIN_PORT_RANGE || port > MAX_PORT_RANGE) return;
        ServerSocket ss = getSSFromList(port);
        if(ss!=null){
            try{
                ss.close();
            }catch(IOException ex){
                return;
            }
        }
    }
}
