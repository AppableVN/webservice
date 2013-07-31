/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dragonboy
 */
@WebService(serviceName = "Hellows")
public class Hellows {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sayHi")
    public String sayHi(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return "Hi " + name + " !";
    }
}
