/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import io.gloagen.persistence.dakamon.entity.auth.UserCredential;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "UACC")
public class UserAccount {
    @Id
//    @GeneratedValue(generator = "IDGeneTable")
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "USER_ACC_GEN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uacc_id")
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "lognz")
    private UserCredential credential;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private User user;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "userAccount")
    @JoinColumn(nullable = true, name = "uname_id")
    private UserName username;

    public UserAccount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public UserName getUsername() {
        return username;
    }

    public void setUsername(UserName username) {
        this.username = username;
    }
}
