package com.antonid.nomnom_plus.app;

import android.app.Application;
import android.content.Context;

import com.antonid.nomnom_plus.di.components.DaggerIApplicationComponent;
import com.antonid.nomnom_plus.di.components.DaggerIDatabaseComponent;
import com.antonid.nomnom_plus.di.components.IApplicationComponent;
import com.antonid.nomnom_plus.di.components.IDatabaseComponent;
import com.antonid.nomnom_plus.di.modules.ApplicationModule;
import com.antonid.nomnom_plus.di.modules.DatabaseModule;
import com.antonid.nomnom_plus.di.modules.MainActivityModule;

/**
 * Created by antonid on 7.7.16.
 */
public class NomNomPlus extends Application{
    private IApplicationComponent appComponent;
    private IDatabaseComponent databaseComponent;

    public static NomNomPlus get(Context context) {
        return (NomNomPlus) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
        buildDatabaseComponent();
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

    private void buildDatabaseComponent() {
         databaseComponent = DaggerIDatabaseComponent.builder()
                .databaseModule(new DatabaseModule(getApplicationContext()))
                .build();
        databaseComponent.inject(this);
    }
}
