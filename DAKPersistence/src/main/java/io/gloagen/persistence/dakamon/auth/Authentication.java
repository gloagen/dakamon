/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity(name = "AUTH")
public class Authentication {
    @Id
    private long id;

    @OneToMany(mappedBy = "authentication")
    private List<OAuth> oAuths;

    @OneToOne
    private Login login;

    public Authentication() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<OAuth> getoAuths() {
        return oAuths;
    }

    public void setoAuths(List<OAuth> oAuths) {
        this.oAuths = oAuths;
    }
}
