package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserInformation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserAccessLayerImpl implements UserAccessLayer {

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void save(UserInformation userInformation) {
        entityManager.persist(userInformation);
    }
}
