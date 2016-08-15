package com.animationdemo.modeso_mmac.animationdemo;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Belal Mohamed on 8/15/16.
 * www.modeso.ch
 */
public class CustomAnimation extends Animation {

    private View mView;
    private int mHeight;
    private int mWidth;

    public CustomAnimation(View view) {
        mView = view;
        mHeight = mView.getHeight();
        mWidth = mView.getHeight();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        mView.getLayoutParams().height = mHeight + (int) (mHeight * interpolatedTime);
        mView.getLayoutParams().width = mWidth + (int) (mWidth * interpolatedTime);
        mView.requestLayout();
    }
}
