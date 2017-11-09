package io.gloagen.persistence.dakamon.accesslayer;

import io.gloagen.persistence.dakamon.entity.user.EmailAddress;

import javax.persistence.NamedQuery;


@NamedQuery(name = "findEmailByEmailAddress", query = "SELECT e from EmailAddress WHERE e.email LIKE :emailaddress")
public interface EmailService {

    EmailAddress find(String email);

    void save(EmailAddress emailAddress);
}
