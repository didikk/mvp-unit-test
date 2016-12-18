package me.didik.newmvp.data;

import me.didik.newmvp.app.Messages;
import me.didik.newmvp.base.ObjectCallback;

/**
 * Created by didik on 12/18/16.
 * User
 */

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void doLogin(final String username, final String password, final ObjectCallback<String> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if (username.equals("frieska") && password.equals("laksani"))
                        callback.onSuccess(Messages.LOGIN_SUCCESS);
                    else callback.onFailure(Messages.USERNAME_IS_INVALID);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    callback.onFailure(e.getMessage());
                }
            }
        }).start();
    }
}
