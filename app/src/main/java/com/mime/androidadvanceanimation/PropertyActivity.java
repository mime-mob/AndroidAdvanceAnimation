package com.mime.androidadvanceanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.text.DecimalFormat;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PropertyActivity extends AppCompatActivity {

    ObjectAnimator anim1;

    ValueAnimator anim2;

    ValueAnimator anim3;

    ObjectAnimator anim4;

    DecimalFormat format = new DecimalFormat("#.00");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
    }

    public void startNumberAnimator(View view) {
        final TextView txt = (TextView)findViewById(R.id.txt_number);
        ValueAnimator anim = ValueAnimator.ofFloat(0, 2000);
        anim.setDuration(2000);
        anim.setInterpolator(new LinearInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                txt.setText(format.format(value));
            }
        });
        anim.start();
    }

    public void startAnim1(View view) {
        ImageView iv = (ImageView) findViewById(R.id.iv_1);
        anim1 = ObjectAnimator.ofFloat(iv, "rotationY", 0, 359);
        anim1.setDuration(1000);
        anim1.setRepeatCount(1);
        anim1.setRepeatMode(ValueAnimator.REVERSE);
        anim1.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void startAnim2(View view) {
        final ImageView iv = (ImageView) findViewById(R.id.iv_2);
        anim2 = ValueAnimator.ofFloat(0, 1);
        anim2.setDuration(1000);
        anim2.setInterpolator(new AccelerateInterpolator());
        anim2.setRepeatCount(1);
        anim2.setRepeatMode(ValueAnimator.REVERSE);
        anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f = valueAnimator.getAnimatedFraction();
                float rotate = f * 359;
                iv.setRotationY(rotate);
            }
        });
        anim2.start();
    }

    public void startAnim3(View view) {
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout_2);
        final View v = findViewById(R.id.view_1);

        final int layoutWidth = layout.getWidth();
        final int layoutHeight = layout.getHeight();
        final int dotWidth = v.getWidth();
        final int radio = layoutHeight - dotWidth >> 1;

        anim3 = ValueAnimator.ofFloat(0, 1);
        anim3.setDuration(1600);
        anim3.setInterpolator(new LinearInterpolator());
        anim3.setRepeatCount(ValueAnimator.INFINITE);
        anim3.setRepeatMode(ValueAnimator.RESTART);
        anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f = valueAnimator.getAnimatedFraction();
                f += 0.5;
                if (f > 1) {
                    f -= 1;
                }
                double angle = f * Math.PI * 2;
                double x = radio * Math.sin(angle);
                double y = radio * Math.cos(angle);
                v.setX((int) x + (layoutWidth - dotWidth >> 1));
                v.setY((int) y + radio);
            }
        });
        anim3.start();
    }

    public void startAnim4(View view) {
        final SectorView sectorView = (SectorView)findViewById(R.id.sector_view);
        anim4 = ObjectAnimator.ofFloat(sectorView, "fraction", 0, 1);
        anim4.setDuration(2000);
        anim4.setRepeatCount(ValueAnimator.INFINITE);
        anim4.setRepeatMode(ValueAnimator.RESTART);
        anim4.start();
    }

    public void gotoPathAnim(View view) {
        startActivity(new Intent(this, PathAnimActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(anim1 != null) {
            anim1.cancel();
            anim1 = null;
        }
        if(anim2 != null) {
            anim2.cancel();
            anim2 = null;
        }
        if(anim3 != null) {
            anim3.cancel();
            anim3 = null;
        }
        if(anim4 != null) {
            anim4.cancel();
            anim4 = null;
        }
    }
}
