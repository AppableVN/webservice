/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Dragonboy
 */
@Path("hellowsport")
public class HellowsPort {
    private com.netbean.webservice_client.Hellows port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HellowsPort
     */
    public HellowsPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method hello
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("hello/")
    public String getHello(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.hello(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method sayHi
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("sayhi/")
    public String getSayHi(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.sayHi(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private com.netbean.webservice_client.Hellows getPort() {
        try {
            // Call Web Service Operation
            com.netbean.webservice_client.Hellows_Service service = new com.netbean.webservice_client.Hellows_Service();
            com.netbean.webservice_client.Hellows p = service.getHellowsPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
