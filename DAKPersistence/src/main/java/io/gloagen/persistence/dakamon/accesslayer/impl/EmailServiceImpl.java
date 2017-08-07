package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.object.EmailService;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class EmailServiceImpl implements EmailService {

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;

    public EmailAddress find(String email) {
        TypedQuery<EmailAddress> query = entityManager.createNamedQuery("findEmailByEmailAddress",
                                                                        EmailAddress.class);
        return query.getSingleResult();
    }
}