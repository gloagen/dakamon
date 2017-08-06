package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.AuthenticationAccessLayer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

@Stateless
public class AuthenticationAccessLayerImpl implements AuthenticationAccessLayer {

    @PersistenceUnit
    EntityManager entityManager;

    public AuthenticationAccessLayerImpl() {
//        entityManager.
    }
}
