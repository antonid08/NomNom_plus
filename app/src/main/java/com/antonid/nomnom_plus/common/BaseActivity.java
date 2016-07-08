package com.antonid.nomnom_plus.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antonid.nomnom_plus.app.NomNomPlus;
import com.antonid.nomnom_plus.di.components.IApplicationComponent;

/**
 * Created by antonid on 7.7.16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(NomNomPlus.get(this).getAppComponent());
    }

    protected abstract void setupComponent(IApplicationComponent appComponent);

}
