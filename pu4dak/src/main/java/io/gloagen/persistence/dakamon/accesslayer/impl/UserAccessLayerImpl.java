package io.gloagen.persistence.dakamon.accesslayer.impl;

import io.gloagen.persistence.dakamon.accesslayer.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.persistence.dakamon.entity.user.UserProfile;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserAccessLayerImpl implements UserAccessLayer {

    static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(UserAccessLayerImpl.class);

    @PersistenceContext(name = "DakamonPU")
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void save(UserAccount userAccount) {
        entityManager.persist(userAccount);
    }

    @Override
    public void save(UserProfile userProfile) {
        entityManager.persist(userProfile);
    }

    @Override
    public void save(UserCredential credential) {
        entityManager.persist(credential);
    }

    @Override
    public UserAccount findAccountByEmail(String email) {
        TypedQuery<UserAccount> query = entityManager.createQuery(
                "SELECT ua FROM UACC ua WHERE ua.id in (select email.userAccount from USER_MAIL email where email.email = ?1)",
                UserAccount.class)
                                                     .setParameter(1, email);

        UserAccount userAcccount = query.getSingleResult();
        if (userAcccount == null) {
            throw new NullPointerException("could not find an account for email: " + email);
        }
        return userAcccount;
    }

    @Override
    public UserAccount findAccountByUsername(String usernameOrEmail) {
        return null;
    }
}
