package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserAccessLayerImpl implements UserAccessLayer {

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;
}
