package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.RolesValue;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class SecUserRole extends PanacheEntity {

    @ManyToOne()
    @JoinColumn(name = "sys_user_id")
    public SecUser user;

    @RolesValue
    @Column(name="role")
    public String role;
}
