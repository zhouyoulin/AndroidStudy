package com.example.myapplication.main.shanghai.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.main.shanghai.bean.ShanghaiBean;
import com.example.myapplication.main.shanghai.view.ShanghaiDetailActivity;

import java.util.ArrayList;

/**
 * RecyclerView的自定义adapter
 */
public class ShanghaiAdapter extends RecyclerView.Adapter {

    private final boolean mIsHor;
    private ArrayList<ShanghaiBean> mData;
    private Activity mContext;
    // RecyclerView四级缓存
    private RecyclerView.RecycledViewPool mRecycledViewPool;

    /**
     * @param context 上下文
     * @param data 数据
     */
    public ShanghaiAdapter(Activity context, ArrayList<ShanghaiBean> data, boolean isHor) {
        mContext = context;
        mData = data;
        mRecycledViewPool = new RecyclerView.RecycledViewPool();
        mIsHor = isHor;
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
            ((ShanghaiViewHolder)viewHolder).itemView.setTag(i);
        }else if (getItemViewType(i) == ShanghaiBean.IShanghaiItemType.HORIZONTAL){
            ((ShanghaiViewHzHolder)viewHolder).mRv.setAdapter(new ShanghaiAdapter(mContext, shanghaiBean.getmData(), true));
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
            // 设置回调尽量在创建viewholder的时候设置，因为adapter绑定hlder的时候会多次
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShanghaiDetailActivity.start_5_0(mContext,mIv);
                }
            });
        }
    }

    public class ShanghaiViewHzHolder extends RecyclerView.ViewHolder{

        public RecyclerView mRv;

        public ShanghaiViewHzHolder(@NonNull View itemView) {
            super(itemView);
            mRv = itemView.findViewById(R.id.item_shanghai_hz);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            mRv.setLayoutManager(linearLayoutManager);
            //优化RecyclerView缓存
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRv.setRecycledViewPool(mRecycledViewPool);
        }
    }
}
