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

    @OneToOne(optional = false)
    private User user;

    @Column(unique = true, length = 50)
    private String username;

    public UserInformation() {
    }

}
