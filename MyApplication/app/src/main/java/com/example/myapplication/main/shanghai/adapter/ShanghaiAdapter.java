package com.example.myapplication.main.shanghai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.main.shanghai.bean.ShanghaiBean;

import java.util.ArrayList;

/**
 * RecyclerView的自定义adapter
 */
public class ShanghaiAdapter extends RecyclerView.Adapter {

    private final ArrayList<ShanghaiBean> mData;
    private final Context mContext;

    /**
     * @param context 上下文
     * @param data 数据
     */
    public ShanghaiAdapter(Context context, ArrayList<ShanghaiBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // 根据不同的类型创建不同的viewHolder
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL){
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shanghai_fragment, viewGroup, false);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(mView);
            return viewHolder;
        }else if (viewType == ShanghaiBean.IShanghaiItemType.HORIZONTAL){
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shanghai_fragment_hz, null);
            ShanghaiViewHzHolder viewHolder = new ShanghaiViewHzHolder(mView);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ShanghaiBean shanghaiBean = mData.get(i);
        // 根据当前bean的显示类型使用相应的viewHolder来显示
        if (getItemViewType(i) == ShanghaiBean.IShanghaiItemType.VERTICAL){
            ((ShanghaiViewHolder)viewHolder).mTv.setText(shanghaiBean.getmDesc());
            ((ShanghaiViewHolder)viewHolder).mIv.setVisibility(shanghaiBean.isShowImg()?View.VISIBLE:View.GONE);
        }else if (getItemViewType(i) == ShanghaiBean.IShanghaiItemType.HORIZONTAL){
            ((ShanghaiViewHzHolder)viewHolder).mRv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ShanghaiViewHzHolder)viewHolder).mRv.setAdapter(new ShanghaiAdapter(mContext, shanghaiBean.getmData()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        // 获取数据的显示类型
        return mData.get(position).getmType();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder{

        public TextView mTv;
        public ImageView mIv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
        }
    }

    public class ShanghaiViewHzHolder extends RecyclerView.ViewHolder{

        public RecyclerView mRv;

        public ShanghaiViewHzHolder(@NonNull View itemView) {
            super(itemView);
            mRv = itemView.findViewById(R.id.item_shanghai_hz);
        }
    }
}
