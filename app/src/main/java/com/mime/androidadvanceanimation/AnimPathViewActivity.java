package com.mime.androidadvanceanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;

import com.mime.common_anim_util.anim_path_view.PathAnimView;
import com.mime.common_anim_util.anim_path_view.StoreHouseAnimView;
import com.mime.common_anim_util.anim_path_view.res.StoreHousePath;
import com.mime.common_anim_util.anim_path_view.util.PathParserUtils;
import com.mime.common_anim_util.util.SvgPathParser;

import java.text.ParseException;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AnimPathViewActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private PathAnimView pathAnimView1;

    private PathAnimView pathAnimView2;

    private StoreHouseAnimView storeHouseView1;

    private StoreHouseAnimView storeHouseView2;

    private SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_path_view);

        pathAnimView1 = (PathAnimView) findViewById(R.id.path_anim_view_1);
        pathAnimView2 = (PathAnimView) findViewById(R.id.path_anim_view_2);
        storeHouseView1 = (StoreHouseAnimView) findViewById(R.id.store_house_view_1);
        storeHouseView2 = (StoreHouseAnimView) findViewById(R.id.store_house_view_2);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setKeyProgressIncrement(1);
        seekBar.setProgress(2);

        this.getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                try {
                    initShow();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initShow() throws ParseException{
        int normalColor = ContextCompat.getColor(this, R.color.color_normal);
        int shineColor = ContextCompat.getColor(this, R.color.color_shine);
        float strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics());

        int viewWidth = pathAnimView1.getMeasuredWidth();
        int viewHeight = pathAnimView1.getMeasuredHeight();
        int paddingTop = pathAnimView1.getPaddingTop();
        int paddingBottom = pathAnimView1.getPaddingBottom();

        Log.e("TAG", "## viewWidth=" + viewWidth + ", viewHeight=" + viewHeight);

        float scale = (viewHeight - paddingTop - paddingBottom) / StoreHousePath.VIEW_PORT_HEIGHT;

        pathAnimView1.setColorBg(normalColor).setColorFg(shineColor);
        pathAnimView1.setSourcePath(PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("MEMEDAI", scale, 10)));

        pathAnimView2.setColorBg(normalColor).setColorFg(shineColor);
        pathAnimView2.setSourcePath(PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("MEMEDAI", scale, 10)));

        storeHouseView1.setColorBg(normalColor).setColorFg(shineColor);
        storeHouseView1.setSourcePath(PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("MEMEDAI", scale, 10)));

        storeHouseView2.setColorBg(normalColor).setColorFg(shineColor);
        String pathString = "M40,180 L373,180 L390,226 L460,24 L508,185 L523,143 L560,227 L605,68 L652,187 L994,190";
        SvgPathParser parser = new SvgPathParser(SvgPathParser.TOKEN_RELATIVE_COMMAND);
        storeHouseView2.setSourcePath(parser.parsePath(pathString));
        storeHouseView2.setPathMaxLength(200);
    }

    public void start(View view) {
        pathAnimView1.startAnim();
        pathAnimView2.setAnimInfinite(false).startAnim();
        storeHouseView1.startAnim();
        storeHouseView2.startAnim();
    }

    public void stop(View view) {
        pathAnimView1.stopAnim();
        pathAnimView2.stopAnim();
        storeHouseView1.stopAnim();
        storeHouseView2.stopAnim();
    }

    public void reset(View view) {
        pathAnimView1.clearAnim();
        pathAnimView2.clearAnim();
        storeHouseView1.clearAnim();
        storeHouseView2.clearAnim();
    }

    public void setAnimDuration(long time) {
        pathAnimView1.setAnimTime(time);
        pathAnimView2.setAnimTime(time);
        storeHouseView1.setAnimTime(time);
        storeHouseView2.setAnimTime(time);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        setAnimDuration((i + 2) * 1000);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
