package com.antonid.nomnom_plus.presenter;

import com.antonid.nomnom_plus.common.BaseFragmentPresenter;
import com.antonid.nomnom_plus.view.IFullFridgeFragmentView;

/**
 * Created by antonid on 9.7.16.
 */
public interface IFullFridgeFragmentPresenter extends BaseFragmentPresenter<IFullFridgeFragmentView> {
    void plusButtonClick();
    void watchAvailableRecipesButtonClick();
}
