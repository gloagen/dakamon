package io.gloagen.web.dakamon.processor;

import io.gloagen.persistence.dakamon.entity.auth.AccessToken;

public interface LoginProcessor {

    AccessToken login(String username, String password);
}
