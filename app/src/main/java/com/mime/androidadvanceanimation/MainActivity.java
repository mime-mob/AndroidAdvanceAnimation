package com.mime.androidadvanceanimation;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SVG svg = SVG.getFromResource(this, R.raw.android);
            RectF rectf = svg.getDocumentViewBox(); //viewport的宽高
            Log.e("TAG", "## rectf=" + rectf);
            Set<String> viewList = svg.getViewList();
            Log.e("TAG", "## viewList=" + viewList);
            float documentWidth = svg.getDocumentWidth(); //显示的宽
            float documentHeight = svg.getDocumentHeight(); //显示的高
            Log.e("TAG", "## documentWidth=" + documentWidth + ", documentHeight=" + documentHeight);
            float documentAspectRatio = svg.getDocumentAspectRatio();
            Log.e("TAG", "## documentAspectRatio=" + documentAspectRatio); //宽高比
            float renderDPI = svg.getRenderDPI();
            Log.e("TAG", "## renderDPI=" + renderDPI); //手机屏幕的PPI

            svg.setDocumentWidth(100.f); //设置显示的宽高，具体为ImageView的宽高
            svg.setDocumentHeight(100.f);
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }

    public void gotoTween(View view) {
        startActivity(new Intent(this, TweenActivity.class));
    }

    public void gotoFrame(View view) {
        startActivity(new Intent(this, FrameActivity.class));
    }

    public void gotoProperty(View view) {
        startActivity(new Intent(this, PropertyActivity.class));
    }

    public void gotoCircularReveal(View view) {
        startActivity(new Intent(this, CircularRevealActivity.class));
    }

    public void gotoActivityTransition(View view) {
        startActivity(new Intent(this, ActivityTransitionActivity.class));
    }

    public void gotoAnimatedVector(View view) {
        startActivity(new Intent(this, AnimatedVectorActivity.class));
    }

    public void gotoDrawPath(View view) {
        startActivity(new Intent(this, DrawPathActivity.class));
    }

    public void gotoCustomSVG(View view) {
        startActivity(new Intent(this, CustomSVGActivity.class));
    }

    public void gotoCustomSVG2(View view) {
        startActivity(new Intent(this, CustomSVGActivity2.class));
    }
}
