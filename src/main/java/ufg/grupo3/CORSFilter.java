package ufg.grupo3;

import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Vítor Roberto on 22/06/2017.
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {
    private static final Logger LOG = Logger
            .getLogger(CORSFilter.class);

    public void filter(ContainerRequestContext paramContainerRequestContext,
                       ContainerResponseContext paramContainerResponseContext)
            throws IOException {
        LOG.info("Starting Modifing headers by CORSFilter");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        paramContainerResponseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
        LOG.info("End Modifing headers by CORSFilter");
    }
}