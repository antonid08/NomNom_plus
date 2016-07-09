package com.antonid.nomnom_plus.presenter;

import com.antonid.nomnom_plus.view.EmptyFridgeFragment;
import com.antonid.nomnom_plus.view.IMainActivityView;
import com.antonid.nomnom_plus.view.MainActivity;

import javax.inject.Inject;

/**
 * Created by antonid on 8.7.16.
 */
public class MainActivityPresenter implements  IMainActivityPresenter {
    IMainActivityView view;

    @Inject
    public MainActivityPresenter(IMainActivityView view) {
        this.view = view;
        view.setFragment(new EmptyFridgeFragment());
    }
}
