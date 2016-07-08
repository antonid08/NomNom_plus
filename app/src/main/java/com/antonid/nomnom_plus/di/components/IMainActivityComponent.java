package com.antonid.nomnom_plus.di.components;

import com.antonid.nomnom_plus.di.ActivityScope;
import com.antonid.nomnom_plus.di.modules.MainActivityModule;
import com.antonid.nomnom_plus.view.EmptyFridgeFragment;
import com.antonid.nomnom_plus.view.IMainActivityView;
import com.antonid.nomnom_plus.view.MainActivity;

import dagger.Component;

/**
 * Created by antonid on 8.7.16.
 */

@ActivityScope
@Component(
        dependencies = IApplicationComponent.class,
        modules = MainActivityModule.class
)

public interface IMainActivityComponent {
    void inject(MainActivity activity);
    void inject(EmptyFridgeFragment fragment);
}

