package com.antonid.nomnom_plus.di.components;

/**
 * Created by antonid on 7.7.16.
 */

import com.antonid.nomnom_plus.app.NomNomPlus;
import com.antonid.nomnom_plus.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface IApplicationComponent {
    void inject(NomNomPlus app);
}
