package com.animationdemo.modeso_mmac.animationdemo;

import android.support.v4.app.Fragment;

/**
 * Created by Belal Mohamed on 8/11/16.
 * www.modeso.ch
 */
public abstract class BaseFragment extends Fragment {

    protected boolean mShowFap;

    public abstract String getTitle();

    public abstract void resetAnimation();

    public boolean ShowFap() {
        return mShowFap;
    }
}
