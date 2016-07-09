package com.antonid.nomnom_plus.presenter;

import com.antonid.nomnom_plus.view.IFullFridgeFragmentView;

import javax.inject.Inject;

/**
 * Created by antonid on 9.7.16.
 */
public class FullFridgeFragmentPresenter implements IFullFridgeFragmentPresenter{
    IFullFridgeFragmentView view;

    @Inject
    public FullFridgeFragmentPresenter() {

    }

    @Override
    public void init(IFullFridgeFragmentView view) {
        this.view = view;
    }

    @Override
    public void plusButtonClick() {

    }

    @Override
    public void watchAvailableRecipesButtonClick() {

    }
}
