package com.animationdemo.modeso_mmac.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

/**
 * Created by Belal Mohamed on 8/11/16.
 * www.modeso.ch
 */
public class SecondAnimationFragment extends BaseFragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second_animation, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.square_shape);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyAnimation();
            }
        });
        return rootView;
    }

    @Override
    public String getTitle() {
        return "Second";
    }

    @Override
    public void resetAnimation() {
        //No need for Reset here.

    }

    private void applyAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new DecelerateInterpolator(0.5f));
        rotateAnimation.setDuration(400);
        mTextView.startAnimation(rotateAnimation);
    }


}
