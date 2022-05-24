package org.acme;

import io.quarkus.hibernate.orm.PersistenceUnitExtension;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@PersistenceUnitExtension
@RequestScoped
public class CustomTenantResolver implements TenantResolver {

    @Inject
    RoutingContext context;

    @Override
    public String getDefaultTenantId() {
        return "tenant1";
    }

    @Override
    public String resolveTenantId() {
        String path = context.request().path();
        String[] parts = path.split("/");

        if (parts.length < 4) {
            // resolve to default tenant config
            return getDefaultTenantId();
        }

        // /api/tenant/tenant1
        // ["", "api", "tenant", "tenant1"]
        // 0   1      2         3

        return parts[3];
    }
}
