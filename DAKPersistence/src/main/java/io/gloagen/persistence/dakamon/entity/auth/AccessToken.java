package io.gloagen.persistence.dakamon.entity.auth;

import cloud.gloagen.utility.persistence.DSBooleanConverter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TOKEN")
public class AccessToken {

    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "TOKEN_GEN")
    private long id;

    @ManyToOne
    @JoinColumn(name = "lognz")
    private UserCredential userCredential;

    @Column(length = 64, nullable = false, unique = true)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    @Column(name = "host", length = 128)
    private String remoteHost;

    @Column(name = "os", length = 128)
    private String clientOperatingSystem;

    @Column(name = "is_valid", length = 1)
    @Convert(converter = DSBooleanConverter.class)
    private Boolean valid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getClientOperatingSystem() {
        return clientOperatingSystem;
    }

    public void setClientOperatingSystem(String clientOperatingSystem) {
        this.clientOperatingSystem = clientOperatingSystem;
    }
}
