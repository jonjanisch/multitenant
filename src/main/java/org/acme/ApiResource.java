package org.acme;

import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

@Path("/api")
public class ApiResource {

    @Context
    ResourceContext resourceContext;

    @Path("/tenant/{tenantId}")
    public TenantResource getTenantSubResource() {
        return resourceContext.getResource(TenantResource.class);
    }
}