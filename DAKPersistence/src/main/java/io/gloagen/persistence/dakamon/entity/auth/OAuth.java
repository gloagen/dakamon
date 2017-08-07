/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.*;
import java.util.List;

@Entity(name = "OAUTH")
public class OAuth {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "OAUTH_GEN")
    private long id;

    @Column(name = "secret")
    private String secretKey;

    @Column(name = "access")
    private String acessKey;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Authentication authentication;

    @OneToMany(mappedBy = "oauth")
    private List<AccessToken> accessTokens;

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
