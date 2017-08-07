package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.*;

@Entity(name = "TOKEN")
public class AccessToken {

    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "TOKEN_GEN")
    private long id;

    @ManyToOne
    @JoinColumn(name = "oauth_id")
    private OAuth oauth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OAuth getOauth() {
        return oauth;
    }

    public void setOauth(OAuth oauth) {
        this.oauth = oauth;
    }
}
