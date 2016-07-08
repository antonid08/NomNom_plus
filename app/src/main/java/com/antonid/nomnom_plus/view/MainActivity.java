package com.antonid.nomnom_plus.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.antonid.nomnom_plus.R;
import com.antonid.nomnom_plus.common.BaseActivity;
import com.antonid.nomnom_plus.di.IHasComponent;
import com.antonid.nomnom_plus.di.components.DaggerIMainActivityComponent;
import com.antonid.nomnom_plus.di.components.IApplicationComponent;
import com.antonid.nomnom_plus.di.components.IMainActivityComponent;
import com.antonid.nomnom_plus.di.modules.MainActivityModule;

public class MainActivity extends BaseActivity implements IMainActivityView,
        IHasComponent<IMainActivityComponent> {

    private IMainActivityComponent mainActivityComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        return null;
    }
}
