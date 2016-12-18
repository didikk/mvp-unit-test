package me.didik.newmvp.data;

import me.didik.newmvp.base.ObjectCallback;

/**
 * Created by didik on 12/18/16.
 * User
 */

public interface UserRepository {
    void doLogin(String username, String password, ObjectCallback<String> callback);
}
