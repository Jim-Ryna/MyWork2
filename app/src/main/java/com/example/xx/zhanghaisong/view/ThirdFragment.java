package com.example.xx.zhanghaisong.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.example.xx.zhanghaisong.R;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import java.lang.annotation.Target;

/**
 * Created by xx on 2015/5/30.
 */
public class ThirdFragment extends Fragment{
    Button mButton;
    View mView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mView = inflater.inflate(R.layout.fragment_third, container, false);
        mButton = (Button) mView.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        Glider.glide(Skill.BounceEaseInOut, 1200, ObjectAnimator.ofFloat(mView, "translationY", 0, 100))
                );
                set.setDuration(1200);
                set.start();
            }
        });
        return mView;
    }
}
