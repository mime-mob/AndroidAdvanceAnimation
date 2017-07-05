package com.mime.androidadvanceanimation;

import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.mime.commonanim.pathview.PathView;
import com.mime.commonanim.trimpathview.SearchView;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DrawPathActivity extends AppCompatActivity {

    private PathView pathView;

    private SearchView searchView;

    private ImageView ivDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_path);
        pathView = (PathView) findViewById(R.id.pathView);
        searchView = (SearchView)findViewById(R.id.searchview);
        ivDemo = (ImageView)findViewById(R.id.iv_demo);
    }

    public void startPathView(View view) {
        pathView.getPathAnimator().
                delay(100).
                duration(1500).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();

        try {
            SVG svg = SVG.getFromResource(this, R.raw.android);
            Picture picture = svg.renderToPicture();
            Drawable drawable = new PictureDrawable(picture);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                ivDemo.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
            ivDemo.setImageDrawable(drawable);
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }

    public void startSearchView(View view) {
        searchView.startAnim();
    }
}