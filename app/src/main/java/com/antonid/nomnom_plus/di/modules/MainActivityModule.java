package com.antonid.nomnom_plus.di.modules;

import com.antonid.nomnom_plus.presenter.EmptyFridgeFragmentPresenter;
import com.antonid.nomnom_plus.presenter.FullFridgeFragmentPresenter;
import com.antonid.nomnom_plus.presenter.MainActivityPresenter;
import com.antonid.nomnom_plus.view.IMainActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by antonid on 8.7.16.
 */

@Module
public class MainActivityModule {

    private IMainActivityView view;

    public MainActivityModule(IMainActivityView view) {
        this.view = view;
    }

    @Provides
    public IMainActivityView provideView() {
        return view;
    }

    @Provides
    public MainActivityPresenter provideMainActivityPresenter (IMainActivityView view){
        return  new MainActivityPresenter(view);
    }

    @Provides
    public EmptyFridgeFragmentPresenter provideEmptyFridgeFragmentPresenter() {
        return new EmptyFridgeFragmentPresenter();
    }

    @Provides
    public FullFridgeFragmentPresenter provideFullFridgeFragmentPresenter(){
        return new FullFridgeFragmentPresenter();
    }
/*
    @Provides
    public DetailFragmentPresenterImpl provideDetailFragmentPresenterImpl() {
        return new DetailFragmentPresenterImpl();
    }

    @Provides
    public ShowFragmentPresenterImpl provideShowFragmentPresenterImpl(){
        return new ShowFragmentPresenterImpl();
    }*/
}
