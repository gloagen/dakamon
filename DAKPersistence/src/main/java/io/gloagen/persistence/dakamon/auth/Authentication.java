/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Authentication {
    @Id
    private long id;

    @OneToOne(optional = false)
    private OAuth oAuth;

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

    public OAuth getoAuth() {
        return oAuth;
    }

    public void setoAuth(OAuth oAuth) {
        this.oAuth = oAuth;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authentication)) return false;

        Authentication that = (Authentication) o;

        if (getId() != that.getId()) return false;
        if (!getoAuth().equals(that.getoAuth())) return false;
        return getLogin().equals(that.getLogin());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getoAuth().hashCode();
        result = 31 * result + getLogin().hashCode();
        return result;
    }
}
