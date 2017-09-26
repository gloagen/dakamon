/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;

@Entity(name = "AUDIT")
public class Activity {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "AUDIT_GEN")
    @Column(name = "AUDIT_ID")
    private long id;

    @ManyToOne(optional = false)
    private User user;

    public Activity() {
    }

}
