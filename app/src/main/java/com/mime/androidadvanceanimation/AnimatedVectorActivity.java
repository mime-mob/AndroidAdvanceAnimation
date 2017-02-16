package com.mime.androidadvanceanimation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
public class AnimatedVectorActivity extends AppCompatActivity {

    private ImageView imgBtn;

    private ImageView iv1;

    private ImageView iv2;

    private ImageView iv3;

    private boolean isSearchBoxChecked = false;

    private boolean isTwitterChecked = false;

    private boolean isFavoriteClick = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_vector);

        imgBtn = (ImageView)findViewById(R.id.imgBtn);
        iv1 = (ImageView)findViewById(R.id.iv_1);
        iv2 = (ImageView)findViewById(R.id.iv_2);
        iv3 = (ImageView)findViewById(R.id.iv_3);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startAnim(View view) {
        Drawable drawable = imgBtn.getDrawable();
        ((Animatable) drawable).start();
    }

    public void onSearchBoxClick(View view) {
        isSearchBoxChecked = !isSearchBoxChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isSearchBoxChecked ? 1 : -1)};
        iv1.setImageState(stateSet, true);
    }

    public void onTwitterClick(View view) {
        isTwitterChecked = !isTwitterChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isTwitterChecked ? 1 : -1)};
        iv2.setImageState(stateSet, true);
    }

    public void onFavoriteClick(View view) {
        isFavoriteClick = !isFavoriteClick;
        final int[] stateSet = {android.R.attr.state_checked * (isFavoriteClick ? 1 : -1)};
        iv3.setImageState(stateSet, true);
    }
}
