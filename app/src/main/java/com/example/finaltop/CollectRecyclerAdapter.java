package com.example.finaltop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollectRecyclerAdapter extends RecyclerView.Adapter<CollectRecyclerAdapter.myViewHolder> {
    private Context context;
    private ArrayList<GoodsEntity> goodsEntityList;

    //创建构造函数
    public CollectRecyclerAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文环境
        this.goodsEntityList = goodsEntityList;//实体类数据
    }


    //用于创建ViewHolder实例
    public myViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        //创建自定义布局   加载布局
        View itemView = View.inflate(context,R.layout.items,null);
        return new myViewHolder(itemView);
    }

    public void onBindViewHolder(myViewHolder holder,int position){
        //根据点击位置绑定数据
        //用于对RecyclerView子项的数据进行赋值，在每个子项被滚动到屏幕内的时候执行
        GoodsEntity data = goodsEntityList.get(position);
        holder.mitemgoodsname.setText(data.getGoodsName());//获取实体类中的name字段并设置
        holder.mitemgodosprice.setText(data.getGoodsPrice());//获取实体类中的price字段并设置
    }

    public int getItemCount(){
        return goodsEntityList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView mitemgoodsimg;
        private TextView mitemgoodsname;
        private TextView mitemgodosprice;

        public myViewHolder(View itemView){
            super(itemView);
            mitemgoodsimg = itemView.findViewById(R.id.item_goods_img);
            mitemgoodsname = itemView.findViewById(R.id.item_goods_name);
            mitemgodosprice = itemView.findViewById(R.id.item_goods_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点击了",Toast.LENGTH_SHORT).show();
                    //回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v,goodsEntityList.get(getLayoutPosition()));
                    }
                }
            });
        }

    }
    /*
     * 设置item的监听事件的接口
     * */
    public interface OnItemClickListener{
        /*
         * @param view 点击的item的试图
         * @param data 点击的item的数据
         * */
        public void OnItemClick(View view, GoodsEntity data);
    }

    //需要外部访问设置set方法方便调用
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}

