package yinwuteng.com.myutils.md;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yinwuteng.com.myutils.R;


/**
 * Created by yinwuteng on 2018/1/31.
 * RecycleView适配器
 */

public class MDAdapter extends RecyclerView.Adapter<MDAdapter.ViewHolder> {
    private Context mContext;
    private List<MdBean> mList;


    public MDAdapter(Context context, List<MdBean> list) {
        mList = list;
        mContext = context;
    }

    /**
     * 获取并复用试图
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cardview, parent, false);
//        return new ViewHolder(view);
        final ViewHolder holder = new ViewHolder(view);
        //设置点击事件
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                MdBean mdBean = mList.get(position);
                Intent intent = new Intent(mContext, MdDetailActivity.class);
                intent.putExtra(MdDetailActivity.NAME, mdBean.getName());
                intent.putExtra(MdDetailActivity.IMAGE_ID, mdBean.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    /**
     * 给绑定的控件赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MdBean bean = mList.get(position);
        holder.textView.setText(bean.getName());
        //设置Glide加载图片
        Glide.with(mContext).load(bean.getImageId()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            imageView = view.findViewById(R.id.im);
            textView = view.findViewById(R.id.tv);
        }
    }
}
