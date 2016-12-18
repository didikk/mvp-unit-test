package me.didik.newmvp.app.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.didik.newmvp.data.UserRepository;
import me.didik.newmvp.data.UserRepositoryImpl;

/**
 * Created by didik on 12/18/16.
 * App
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository() {
        return new UserRepositoryImpl();
    }
}
