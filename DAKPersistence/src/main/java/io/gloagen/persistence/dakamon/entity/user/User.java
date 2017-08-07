/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "USER_GEN")
    @Column(name = "user_id")
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    @OneToOne(mappedBy = "user")
    private UserInformation information;

    @Column(name = "fname")
    private String firstname;

    @Column(name = "lname")
    private String lastname;

    @Column(name = "midname")
    private String middlenames;

    public User() {
    }

}
