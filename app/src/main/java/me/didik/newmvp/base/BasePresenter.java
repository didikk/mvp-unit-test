package me.didik.newmvp.base;

/**
 * Created by didik on 12/18/16.
 * BasePresenter
 */

public abstract class BasePresenter<T extends BaseView> {
    protected T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }
}
