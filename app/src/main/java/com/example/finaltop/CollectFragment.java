package com.example.finaltop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollectFragment extends Fragment {

    private View view;
    public RecyclerView mCollectRecyclerView;
    private ArrayList<GoodsEntity> goodsEntities = new ArrayList<>();
    private CollectRecyclerAdapter mCollectRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取fragment的layout
        view = inflater.inflate(R.layout.collect_page,container, false);
        //对recycleview进行配置
        initRecyclerView();
        //模拟数据
        initData();
        return view;
    }

    private void initData(){
        for(int i=0;i<10;i++){
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsName("软件工程"+i);
            goodsEntity.setGoodsPrice("100"+i*1000);
            goodsEntities.add(goodsEntity);
        }
    }

    private void initRecyclerView() {
        //获取recyclerview
        mCollectRecyclerView=(RecyclerView)view.findViewById(R.id.collect_recyclerView);
        //创建adapter
        mCollectRecyclerAdapter = new CollectRecyclerAdapter(getActivity(), goodsEntities);
        //给recyclerview设置adapter
        mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
        //设置layoutmanager，可以设置显示效果是线性布局、grid布局还是瀑布流
        //参数是：上下文、列表方向、是否倒叙
        mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //recyclerview没有item的监听事件，需要自己在适配器中写一个监听事件
        mCollectRecyclerAdapter.setOnItemClickListener(new CollectRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                Toast.makeText(getActivity(),"item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
