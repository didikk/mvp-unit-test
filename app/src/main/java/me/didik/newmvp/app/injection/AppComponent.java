package me.didik.newmvp.app.injection;

import javax.inject.Singleton;

import dagger.Component;
import me.didik.newmvp.feature.login.LoginActivity;

/**
 * Created by didik on 12/18/16.
 * App
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity activity);
}
