package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sys_user")
@UserDefinition
public class SecUser extends PanacheEntity {

    @Username
    @Column(name="user_id")
    public String userId;

    @Password
    @Column(name="password")
    public String password;

    @OneToMany(mappedBy = "user")
    @Roles
    public List<SecUserRole> roles = new ArrayList<>();
}
