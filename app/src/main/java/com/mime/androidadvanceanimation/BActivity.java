package com.mime.androidadvanceanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

/**
 * BActivity
 * Created by lgl on 2016/5/1.
 */
public class BActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    //设置不同的动画效果
    public void explode(View view) {
        intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同的动画效果
    public void slide(View view) {
        intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同的动画效果
    public void fade(View view) {
        intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同的动画效果
    public void share(View view) {
        View fab = findViewById(R.id.fab_button);
        View txName = findViewById(R.id.tx_user_name);
        intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 3);
        //创建单个共享元素
//        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle());
        //创建多个共享单元
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(view, "share"),
                Pair.create(fab, "fab"),
                Pair.create(txName, "user_name"))
                .toBundle());
    }
}
