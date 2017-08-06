package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TOKEN")
public class AccessToken {

    @Id
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
