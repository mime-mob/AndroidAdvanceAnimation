package com.mime.androidadvanceanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mime.common_anim_util.animator.CommonAnimator;

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

//        CommonAnimator.animateFrame(image, R.drawable.animation_list).start();
//
//        CommonAnimator.animateFrame(image)
//                .addFrame(R.mipmap.run_1, 150)
//                .addFrame(R.mipmap.run_2, 150)
//                .addFrame(R.mipmap.run_3, 150)
//                .addFrame(R.mipmap.run_4, 150)
//                .addFrame(R.mipmap.run_5, 150)
//                .addFrame(R.mipmap.run_6, 150)
//                .addFrame(R.mipmap.run_7, 150)
//                .addFrame(R.mipmap.run_8, 150)
//                .addFrame(R.mipmap.run_9, 150)
//                .start();
    }
}