package com.animationdemo.modeso_mmac.animationdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Belal Mohamed on 8/9/16.
 * www.modeso.ch
 */
public class PagerFragmentAdapter extends FragmentStatePagerAdapter {

    private BaseFragment[] fragments = new BaseFragment[]{new FirstAnimationFragment(), new SecondAnimationFragment()};

    public PagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position].getTitle();
    }
}
