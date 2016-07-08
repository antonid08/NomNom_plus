package com.antonid.nomnom_plus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.antonid.nomnom_plus.R;
import com.antonid.nomnom_plus.common.BaseFragment;
import com.antonid.nomnom_plus.di.components.IMainActivityComponent;
import com.antonid.nomnom_plus.presenter.EmptyFridgeFragmentPresenter;
import com.antonid.nomnom_plus.presenter.IEmptyFridgeFragmentPresenter;

import javax.inject.Inject;

/**
 * Created by antonid on 8.7.16.
 */
public class EmptyFridgeFragment extends BaseFragment implements IEmptyFridgeFragmentView {
    @Inject
    EmptyFridgeFragmentPresenter presenter;

    private View rootView;

    public EmptyFridgeFragment() {
    }

    // ----- Lifecycle override method

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getComponent(IMainActivityComponent.class).inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.init(this);
        //presenter.onResume(spiceManager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_empty_fridge, container, false);
            //listView = (ListView) rootView.findViewById(R.id.talkListView);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        if (rootView.getParent() != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        /*listView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public void onLoadMore() {
                presenter.onLoadMore();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.onItemClick((ItemTalk) listView.getAdapter().getItem(position));
            }
        });*/
    }

/*
    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }
*/



    @Override
    public void replaceWithIngredientsCategoriesFragment() {

    }
}
