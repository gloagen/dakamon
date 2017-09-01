package io.gloagen.persistence.dakamon.accesslayer.object;

import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.persistence.dakamon.entity.user.UserProfile;

public interface UserAccessLayer {

    void save(User user);

    void save(UserAccount userAccount);

    void save(UserProfile userProfile);

    void save(UserCredential credential);
}
