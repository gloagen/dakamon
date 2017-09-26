/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import io.gloagen.persistence.dakamon.entity.auth.Permission;
import io.gloagen.persistence.dakamon.entity.org.Organisation;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "U_PROFIL")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "PROFL_GEN")
    private long id;

    @ManyToOne
    @JoinColumn(name = "uacc")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user")
    private List<Preference> preferences;

    @ManyToMany(mappedBy = "userProfiles")
    private Collection<Organisation> organisations;

    @ManyToMany(mappedBy = "userProfiles")
    private List<Permission> permissions;

    @Column(name = "pname", nullable = true, length = 40)
    private String profileName;

    public UserProfile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public Collection<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(Collection<Organisation> organisations) {
        this.organisations = organisations;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
