package com.mime.androidadvanceanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DActivity extends AppCompatActivity implements RVAdapter.RVClickListener {

    RecyclerView rv;

    List<RVBean> beans;

    RVAdapter rvAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        init();
    }

    private void init() {
        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        beans = new ArrayList<>();
        beans.add(new RVBean("谈笑冯生", R.mipmap.head_image_01, "低调奢华有内涵"));
        beans.add(new RVBean("高鹏展翅", R.mipmap.head_image_02, "桌游传奇小王子"));
        beans.add(new RVBean("珉而好学", R.mipmap.head_image_03, "套路王"));
        beans.add(new RVBean("汰渍洗衣粉，加亮不加价", R.mipmap.head_image_04, "What are you 说啥捏？"));
        beans.add(new RVBean("尼古拉斯.赵政", R.mipmap.head_image_05, "亚洲舞王不解释"));

        beans.add(new RVBean("谈笑冯生", R.mipmap.head_image_01, "低调奢华有内涵"));
        beans.add(new RVBean("高鹏展翅", R.mipmap.head_image_02, "桌游传奇小王子"));
        beans.add(new RVBean("珉而好学", R.mipmap.head_image_03, "套路王"));
        beans.add(new RVBean("汰渍洗衣粉，加亮不加价", R.mipmap.head_image_04, "What are you 说啥捏？"));
        beans.add(new RVBean("尼古拉斯.赵政", R.mipmap.head_image_05, "亚洲舞王不解释"));

        beans.add(new RVBean("谈笑冯生", R.mipmap.head_image_01, "低调奢华有内涵"));
        beans.add(new RVBean("高鹏展翅", R.mipmap.head_image_02, "桌游传奇小王子"));
        beans.add(new RVBean("珉而好学", R.mipmap.head_image_03, "套路王"));
        beans.add(new RVBean("汰渍洗衣粉，加亮不加价", R.mipmap.head_image_04, "What are you 说啥捏？"));
        beans.add(new RVBean("尼古拉斯.赵政", R.mipmap.head_image_05, "亚洲舞王不解释"));

        beans.add(new RVBean("谈笑冯生", R.mipmap.head_image_01, "低调奢华有内涵"));
        beans.add(new RVBean("高鹏展翅", R.mipmap.head_image_02, "桌游传奇小王子"));
        beans.add(new RVBean("珉而好学", R.mipmap.head_image_03, "套路王"));
        beans.add(new RVBean("汰渍洗衣粉，加亮不加价", R.mipmap.head_image_04, "What are you 说啥捏？"));
        beans.add(new RVBean("尼古拉斯.赵政", R.mipmap.head_image_05, "亚洲舞王不解释"));

        rvAdapter = new RVAdapter(this, beans);
        rv.setAdapter(rvAdapter);

        rvAdapter.setListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(int position) {
        RVBean bean = beans.get(position);

        Intent intent = new Intent(DActivity.this, DetailActivity.class);
        intent.putExtra("resId", bean.getResId());
        intent.putExtra("name", bean.getName());
        intent.putExtra("desc", bean.getDesc());

        int firstVisiblePosition = ((LinearLayoutManager)rv.getLayoutManager()).findFirstVisibleItemPosition();

        View itemView = rv.getChildAt(position - firstVisiblePosition);
        View headImage = itemView.findViewById(R.id.head_image);
        View name = itemView.findViewById(R.id.name);
        View desc = itemView.findViewById(R.id.desc);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(headImage, "headImage"),
                Pair.create(name, "name"),
                Pair.create(desc, "desc"))
                .toBundle());
    }
}