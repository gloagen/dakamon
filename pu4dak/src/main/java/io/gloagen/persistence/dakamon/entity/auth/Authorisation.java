/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.auth;

import javax.persistence.*;

@Entity(name = "AUTHZN")
public class Authorisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "AUTHZN_GEN")
    private long id;

    private String type;

    private String value;

    @ManyToOne
    private Permission permission;

    public Authorisation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}