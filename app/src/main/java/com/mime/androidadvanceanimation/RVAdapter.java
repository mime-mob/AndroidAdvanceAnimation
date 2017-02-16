package com.mime.androidadvanceanimation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>
        implements View.OnClickListener {

    private List<RVBean> beans;

    private Context context;

    private RVClickListener listener;

    public RVAdapter(Context context, List<RVBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RVBean bean = beans.get(position);
        holder.head.setImageResource(bean.getResId());
        holder.name.setText(bean.getName());
        holder.desc.setText(bean.getDesc());
        holder.root.setTag(position);
        holder.root.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            int position = (int)view.getTag();
            listener.onItemClick(position);
        }
    }

    public void setListener(RVClickListener listener) {
        this.listener = listener;
    }

    public interface RVClickListener {
        void onItemClick(int poistion);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView head;

        TextView name;

        TextView desc;

        View root;

        public MyViewHolder(View view) {
            super(view);
            head = (ImageView)view.findViewById(R.id.head_image);
            name = (TextView)view.findViewById(R.id.name);
            desc = (TextView)view.findViewById(R.id.desc);
            root = view.findViewById(R.id.root);
        }
    }
}
