/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.testdata;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ServerSocketFactory;

/**
 *
 * @author Dragonboy
 */
public class TestData {
    public static ServerSocket serversocket;
    public static Socket lvStream, listenstream;
    
    public static ServerSocket getServerSocket(int port) throws IOException{
        if(serversocket != null){
            serversocket.close();
        }
        
        serversocket = ServerSocketFactory.getDefault().createServerSocket(port,10);
        return serversocket;
    }
    
    public static ServerSocket getServerSocket() throws IOException{
        if(serversocket == null)
            serversocket = ServerSocketFactory.getDefault().createServerSocket(12315,10);
        return serversocket;
    }
}
