package me.didik.newmvp.base;

/**
 * Created by didik on 12/18/16.
 * O
 */

public interface ObjectCallback<T> {
    void onSuccess(T data);

    void onFailure(String message);
}
