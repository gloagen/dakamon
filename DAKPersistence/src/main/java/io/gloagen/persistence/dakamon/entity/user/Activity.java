/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Activity {
    @Id
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    public Activity() {
    }

}
