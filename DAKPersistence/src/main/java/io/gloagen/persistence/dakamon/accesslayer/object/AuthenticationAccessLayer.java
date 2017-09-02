package io.gloagen.persistence.dakamon.accesslayer.object;

import io.gloagen.persistence.dakamon.entity.auth.AccessToken;

public interface AuthenticationAccessLayer {
    void save(AccessToken accessToken);
}
