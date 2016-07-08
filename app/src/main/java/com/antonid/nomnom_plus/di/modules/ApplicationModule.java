package com.antonid.nomnom_plus.di.modules;

import android.app.Application;

import com.antonid.nomnom_plus.app.NomNomPlus;

import javax.inject.Singleton;

import dagger.Provides;
import dagger.Module;

/**
 * Created by antonid on 7.7.16.
 */
@Module
public class ApplicationModule {
    private final NomNomPlus app;

    public ApplicationModule(NomNomPlus app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}
