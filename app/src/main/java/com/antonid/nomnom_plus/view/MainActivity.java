package com.antonid.nomnom_plus.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.antonid.nomnom_plus.R;
import com.antonid.nomnom_plus.common.BaseActivity;
import com.antonid.nomnom_plus.di.IHasComponent;
import com.antonid.nomnom_plus.di.components.DaggerIMainActivityComponent;
import com.antonid.nomnom_plus.di.components.IApplicationComponent;
import com.antonid.nomnom_plus.di.components.IMainActivityComponent;
import com.antonid.nomnom_plus.di.modules.MainActivityModule;
import com.antonid.nomnom_plus.presenter.MainActivityPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IMainActivityView,
        IHasComponent<IMainActivityComponent> {


    @Inject
    MainActivityPresenter presenter;

    private IMainActivityComponent mainActivityComponent;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    protected void setupComponent(IApplicationComponent appComponent) {
       mainActivityComponent = DaggerIMainActivityComponent.builder()
                .iApplicationComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build();
       mainActivityComponent.inject(this);
    }


    @Override
    public IMainActivityComponent getComponent() {
        return mainActivityComponent;
    }

    @Override
    public void setFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        // EmptyFridgeFragment emptyFridgeFragment = new EmptyFridgeFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.start_fragment_container, fragment)
                .commit();
    }
}
