package com.mime.androidadvanceanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ActivityTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_transition);
    }

    public void startActivity_1(View view) {
        startActivity(new Intent(this, Activity2.class));
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }

    public void startActivity_2(View view) {
        startActivity(new Intent(this, BActivity.class));
    }

    public void startActivity_3(View view) {
        startActivity(new Intent(this, DActivity.class));
    }
}