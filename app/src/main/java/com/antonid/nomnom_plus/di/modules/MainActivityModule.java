package com.antonid.nomnom_plus.di.modules;

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

    /*@Provides
    public MainActivityPresenterImpl provideMainActivityPresenterImpl (IMainActivityView view){
        return  new MainActivityPresenterImpl(view);
    }*/

/*    @Provides
    public ListFragmentPresenterImpl provideListFragmentPresenterImpl() {
        return new ListFragmentPresenterImpl();
    }

    @Provides
    public DetailFragmentPresenterImpl provideDetailFragmentPresenterImpl() {
        return new DetailFragmentPresenterImpl();
    }

    @Provides
    public ShowFragmentPresenterImpl provideShowFragmentPresenterImpl(){
        return new ShowFragmentPresenterImpl();
    }*/
}
