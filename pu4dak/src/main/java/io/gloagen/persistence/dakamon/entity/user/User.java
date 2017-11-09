/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "USER_GEN")
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    @OneToOne(mappedBy = "user", cascade = CascadeType.MERGE)
    private UserAccount information;

    @Column(name = "fname")
    private String firstname;

    @Column(name = "lname")
    private String lastname;

    @Column(name = "midname")
    private String middlenames;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public UserAccount getInformation() {
        return information;
    }

    public void setInformation(UserAccount information) {
        this.information = information;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlenames() {
        return middlenames;
    }

    public void setMiddlenames(String middlenames) {
        this.middlenames = middlenames;
    }
}
