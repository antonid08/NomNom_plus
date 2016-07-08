package com.antonid.nomnom_plus.presenter;

import com.antonid.nomnom_plus.view.IEmptyFridgeFragmentView;

import javax.inject.Inject;

/**
 * Created by antonid on 8.7.16.
 */
public class EmptyFridgeFragmentPresenter implements IEmptyFridgeFragmentPresenter {
    IEmptyFridgeFragmentView view;

    @Inject
    public EmptyFridgeFragmentPresenter() {

    }

    @Override
    public void plusButtonClick() {

    }

    @Override
    public void init(IEmptyFridgeFragmentView view) {
       this.view = view;
    }
}
