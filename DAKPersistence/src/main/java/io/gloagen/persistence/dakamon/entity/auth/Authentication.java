/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.*;
import java.util.List;

@Entity(name = "AUTH")
public class Authentication {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "AUTH_GEN")
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
