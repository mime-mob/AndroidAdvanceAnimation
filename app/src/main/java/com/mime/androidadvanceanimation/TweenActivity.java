package com.mime.androidadvanceanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
    }

    public void startAnim1(View view) {
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout_1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_1);
        layout.startAnimation(animation);
    }

    public void startAnim2(View view) {
        ImageView iv = (ImageView)findViewById(R.id.iv_2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_2);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.RESTART);
        iv.startAnimation(animation);
    }
}
