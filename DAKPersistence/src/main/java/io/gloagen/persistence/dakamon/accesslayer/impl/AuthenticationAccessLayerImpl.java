package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.AuthenticationAccessLayer;
import io.gloagen.persistence.dakamon.entity.auth.AccessToken;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AuthenticationAccessLayerImpl implements AuthenticationAccessLayer {

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;

    @Override
    public void save(AccessToken accessToken) {
        entityManager.persist(accessToken);
    }
}
