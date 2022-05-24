package org.acme;

import io.quarkus.arc.Unremovable;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Unremovable
public class TenantResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("tenantId") String tenantId) {
        return "Tenant: " + tenantId + ". Only authenticated users can see this";
    }
}