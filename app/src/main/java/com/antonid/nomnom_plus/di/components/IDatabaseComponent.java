package com.antonid.nomnom_plus.di.components;

import com.antonid.nomnom_plus.app.NomNomPlus;
import com.antonid.nomnom_plus.di.modules.DatabaseModule;
import com.antonid.nomnom_plus.model.Model;
import com.antonid.nomnom_plus.presenter.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by antonid on 10.7.16.
 */
@Singleton
@Component(
        modules = {
                DatabaseModule.class
        }
)

public interface IDatabaseComponent {
        void inject(Model model);
        void inject (MainActivityPresenter presenter);
        void inject (NomNomPlus app);
}
