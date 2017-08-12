/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import io.gloagen.persistence.dakamon.entity.auth.Authentication;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USER_INFO")
public class UserInformation {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "USER_INFO_GEN")
    @Column(name = "info_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "auth_id")
    private Authentication authentication;

    @OneToMany(mappedBy = "userInformation")
    private List<Profile> profiles;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private User user;

    @Column(unique = true, length = 50)
    private String username;

    public UserInformation() {
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

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
