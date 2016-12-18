package me.didik.newmvp.feature.login;

import javax.inject.Inject;

import me.didik.newmvp.app.Messages;
import me.didik.newmvp.base.BasePresenter;
import me.didik.newmvp.base.ObjectCallback;
import me.didik.newmvp.data.UserRepository;

/**
 * Created by didik on 12/18/16.
 * L
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    private UserRepository userRepository;

    @Inject
    public LoginPresenter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void doLogin() {

        String userName = view.getUserName();
        String pass = view.getPassword();

        if (userName.isEmpty() || pass.isEmpty()) {
            view.showMessage(Messages.USERNAME_EMPTY);
            return;
        }

        view.showLoading();
        userRepository.doLogin(userName, pass, new ObjectCallback<String>() {
            @Override
            public void onSuccess(String data) {
                view.hideLoading();
                view.showMessage(data);
            }

            @Override
            public void onFailure(String message) {
                view.hideLoading();
                view.showMessage(message);
            }
        });
    }
}
