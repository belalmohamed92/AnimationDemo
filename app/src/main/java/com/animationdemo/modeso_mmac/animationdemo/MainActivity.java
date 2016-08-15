package com.animationdemo.modeso_mmac.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Belal Mohamed on 8/9/16.
 * www.modeso.ch
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private FloatingActionButton mFab;
    private int mPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toot_bar);
        setSupportActionBar(toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.fragments_view_pager);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.hide();

        setUpFab();
        setUpViewPagerWithTabLayout();
        updateFAB(0);

    }

    private void setUpViewPagerWithTabLayout() {
        mPager.setOffscreenPageLimit(3);
        mPager.setAdapter(new PagerFragmentAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
                updateFAB(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpFab() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetVisibleFragment();
                mFab.hide();
            }
        });
    }

    private void updateFAB(int position) {
        Fragment fragment = ((PagerFragmentAdapter) mPager.getAdapter()).getItem(position);

        if (fragment instanceof BaseFragment) {
            if (((BaseFragment) fragment).ShowFap()) {
                mFab.show();
            } else {
                mFab.hide();
            }
        }
    }

    private void resetVisibleFragment() {
        Fragment fragment = ((PagerFragmentAdapter) mPager.getAdapter()).getItem(mPosition);
        if (fragment instanceof BaseFragment) {
            ((BaseFragment) fragment).resetAnimation();
        }
    }

    public void showFAB() {
        if (mFab != null) {
            mFab.show();
        }
    }
}
