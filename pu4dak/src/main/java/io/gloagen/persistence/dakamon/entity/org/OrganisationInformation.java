/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.org;

import javax.persistence.*;

@Entity(name = "ORG_INFO")
public class OrganisationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name = "IDGeneTable", table = "IDGene",
//                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
//                    pkColumnValue = "ORG_INFO_GEN")
    private long id;

    @OneToOne(mappedBy = "organisationInformation")
    private Organisation organisation;

    public OrganisationInformation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
