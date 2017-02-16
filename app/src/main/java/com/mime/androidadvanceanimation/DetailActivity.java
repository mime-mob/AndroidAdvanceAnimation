package com.mime.androidadvanceanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DetailActivity extends AppCompatActivity {

    ImageView ivHead;

    TextView txName;

    TextView txDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        int resId = intent.getIntExtra("resId", 0);

        ivHead = (ImageView)findViewById(R.id.iv_head);
        txName = (TextView)findViewById(R.id.tx_name);
        txDesc = (TextView)findViewById(R.id.tx_desc);

        ivHead.setImageResource(resId);
        txName.setText(name);
        txDesc.setText(desc);
    }
}
