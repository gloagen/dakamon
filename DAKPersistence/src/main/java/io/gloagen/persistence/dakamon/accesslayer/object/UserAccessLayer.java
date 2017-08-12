package io.gloagen.persistence.dakamon.accesslayer.object;

import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserInformation;

public interface UserAccessLayer {

    void save(User user);

    void save(UserInformation userInformation);
}
