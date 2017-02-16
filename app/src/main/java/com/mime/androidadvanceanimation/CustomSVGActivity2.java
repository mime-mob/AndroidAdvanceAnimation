package com.mime.androidadvanceanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mime.common_anim_util.transpathview.TransPathView;


/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CustomSVGActivity2 extends AppCompatActivity implements View.OnClickListener {

    TransPathView transView;

    public static final String HEART = "M99.0,349.0 C193.33,240.67001,283.67,165.33,400.0,99.0 C525.32996,172.0,611.67,246.0,701.0,348.0 C521.67,416.33,433.33,511.66998,400.0,700.0 C356.67,509.0,285.33002,416.0,99.0,349.0";
    public static final String TWITTER = "M99.0,349.0 C297.33002,346.67,376.67,210.33,400.0,99.0 C432.32996,208.0,506.66998,345.0,701.0,348.0 C629.67,479.33,549.32996,570.67,400.0,700.0 C227.67001,569.0,194.33002,522.0,99.0,349.0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_svg_2);
        transView = (TransPathView)findViewById(R.id.trans_path_view);
        transView.setViewPort(800, 800);
        transView.setPaths(HEART, TWITTER);
        transView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        transView.startTransWithOutRotate();
    }
}