package me.didik.newmvp.app;

import android.app.Application;

import me.didik.newmvp.app.injection.AppComponent;
import me.didik.newmvp.app.injection.AppModule;
import me.didik.newmvp.app.injection.DaggerAppComponent;

/**
 * Created by didik on 12/18/16.
 * App
 */

public class MyApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
