package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.AuthenticationAccessLayer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AuthenticationAccessLayerImpl implements AuthenticationAccessLayer {

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;

    public AuthenticationAccessLayerImpl() {
//        entityManager.
    }
}
