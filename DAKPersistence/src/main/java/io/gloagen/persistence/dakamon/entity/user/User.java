/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class User {
    @Id
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    @OneToOne(mappedBy = "user")
    private UserInformation information;

    public User() {
    }

}
