package me.didik.newmvp.feature.login;

import me.didik.newmvp.base.BaseView;

/**
 * Created by didik on 12/18/16.
 * LoginView
 */

public interface LoginView extends BaseView {
    String getUserName();

    String getPassword();
    void showLoading();
    void hideLoading();
}
