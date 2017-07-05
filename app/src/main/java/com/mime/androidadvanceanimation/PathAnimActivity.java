package com.mime.androidadvanceanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * <p>write the description for the file
 *
 * @author renjialiang
 * @createTime 2016/7/25 11:21
 * @project Demo
 */
public class PathAnimActivity extends AppCompatActivity {

    private ImageView iv;

    private int screenWidth;

    private int screenHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathanim);
        iv = (ImageView)findViewById(R.id.iv);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startAnim(View view) {
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(screenWidth - 300, 200, screenWidth - 100, screenHeight - 600);

        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, View.X, View.Y, path);
        animator.setDuration(2000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

//        CommonAnimator.animatePath(iv, path).duration(2000).delay(0).repeat(1, ValueAnimator.REVERSE).fastOutSlowIn().start();
    }
}