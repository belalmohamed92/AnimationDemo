package com.animationdemo.modeso_mmac.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/**
 * Created by Belal Mohamed on 8/11/16.
 * www.modeso.ch
 */
public class FirstAnimationFragment extends BaseFragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_animation, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.first_shape);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mShowFap) {
                    applyAnimation();
                }
            }
        });

        return rootView;
    }

    @Override
    public String getTitle() {
        return "First";
    }

    @Override
    public void resetAnimation() {
        mTextView.clearAnimation();
        mTextView.setText(getString(R.string.click_me));
        mShowFap = false;
    }

    private void applyAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(400);
        scaleAnimation.setFillAfter(true);

        mTextView.startAnimation(scaleAnimation);

        mTextView.setText("");
        mShowFap = true;
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showFAB();
        }
    }
}
