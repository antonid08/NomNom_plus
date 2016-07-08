package com.antonid.nomnom_plus.app;

import android.app.Application;
import android.content.Context;

import com.antonid.nomnom_plus.di.components.DaggerIApplicationComponent;
import com.antonid.nomnom_plus.di.components.IApplicationComponent;
import com.antonid.nomnom_plus.di.modules.ApplicationModule;

/**
 * Created by antonid on 7.7.16.
 */
public class NomNomPlus extends Application{
    private IApplicationComponent appComponent;

    public static NomNomPlus get(Context context) {
        return (NomNomPlus) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
    }

    public IApplicationComponent getAppComponent() {
        return appComponent;
    }

    public void buildGraphAndInject() {
        appComponent = DaggerIApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        appComponent.inject(this);
    }
}
