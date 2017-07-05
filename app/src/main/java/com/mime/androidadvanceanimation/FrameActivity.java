package com.mime.androidadvanceanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
    }

    public void startAnim(View view) {
        ImageView image = (ImageView) findViewById(R.id.iv_1);
        image.setImageResource(R.drawable.animation_list);
        AnimationDrawable anim = (AnimationDrawable) image.getDrawable();
        anim.start();
    }
}