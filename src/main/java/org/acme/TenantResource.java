package org.acme;

import io.quarkus.arc.Unremovable;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Unremovable
public class TenantResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hello(@PathParam("tenantId") String tenantId) {
        List<SecUser> users = SecUser.listAll();
        return users.stream().map(it -> it.userId).collect(Collectors.toList());
    }
}