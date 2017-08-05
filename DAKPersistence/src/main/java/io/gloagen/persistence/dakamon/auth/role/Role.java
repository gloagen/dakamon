/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth.role;

import io.gloagen.persistence.dakamon.auth.Authorisation;
import io.gloagen.persistence.dakamon.org.Organisation;
import io.gloagen.persistence.dakamon.user.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Role {
    @Id
    private long id;

    @OneToMany(mappedBy = "role")
    private List<Authorisation> authorisations;

    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "ID"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "ID")
    })
    @ManyToMany
    private Set<User> users;

    @ManyToMany(mappedBy = "roles")
    private List<Organisation> organisations;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Authorisation> getAuthorisations() {
        return authorisations;
    }

    public void setAuthorisations(List<Authorisation> authorisations) {
        this.authorisations = authorisations;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(List<Organisation> organisations) {
        this.organisations = organisations;
    }
}
