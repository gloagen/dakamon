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

    @ManyToOne
    @JoinColumn(name = "lognz")
    private UserCredential userCredential;

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

}
