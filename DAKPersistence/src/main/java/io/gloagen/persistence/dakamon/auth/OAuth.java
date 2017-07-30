/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OAuth {
    @Id
    private long id;

    @OneToOne(mappedBy = "oAuth")
    private Authentication authentication;

    public OAuth() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OAuth)) return false;

        OAuth oAuth = (OAuth) o;

        if (getId() != oAuth.getId()) return false;
        return getAuthentication().equals(oAuth.getAuthentication());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getAuthentication().hashCode();
        return result;
    }
}
