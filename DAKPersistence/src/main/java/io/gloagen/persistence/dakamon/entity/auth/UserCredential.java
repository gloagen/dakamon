/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.*;
import java.util.List;

@Entity(name = "LOGNZ")
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "LOGN_GEN")
    private long id;

    @Column(name = "sKey", unique = true, length = 500)
    private String secretKey;
    @Column(name = "hpwd", length = 500)
    private String hashedPassword;
    @Column(name = "aKey", length = 500)
    private String accessKey;

    @OneToMany(mappedBy = "userCredential")
    private List<OAuth> oAuths;

    public UserCredential() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public List<OAuth> getoAuths() {
        return oAuths;
    }

    public void setoAuths(List<OAuth> oAuths) {
        this.oAuths = oAuths;
    }
}
