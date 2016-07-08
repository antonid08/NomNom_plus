package com.antonid.nomnom_plus.common;

import android.support.v4.app.Fragment;

import com.antonid.nomnom_plus.di.IHasComponent;

/**
 * Created by antonid on 7.7.16.
 */
public abstract class BaseFragment extends Fragment {
    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((IHasComponent<T>)getActivity()).getComponent());
    }
}
