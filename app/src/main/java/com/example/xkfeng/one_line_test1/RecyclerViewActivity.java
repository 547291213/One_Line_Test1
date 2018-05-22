package com.example.xkfeng.one_line_test1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xkfeng.one_line_test1.simpleClass.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by initializing on 2018/5/16.
 */

/*
RecyclerView 创建和使用的步骤
1， 在dependencies中添加implementation 'com.android.support:recyclerview-v7:26.1.0'
2， 在布局文件中定义<Android.support.v7.widget.RecyclerView>
3， 定义static类RecyclerAdapter继承(extends)自RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
注：
（1）在该类中private 列表集合 。在构造方法中取获取列表对象
（2）定义static内部类ViewHolder继承（extends）自RecyclerView.ViewHolder，
    ！在该类中定义列表的具体内容
    ！在该类的构造方法中添加参数：布局View
    ！通过布局view的findViewById获取布局View的具体UI控件
3， 继承了RecyclerView.Adapter需要实现三个方法
注：
（1） onCreateViewHolder
    ！通过LayoutInflater.from(parent.getContext()).inflate加载布局返回view
    ！用返回的view完成ViewHolder的实例化
    ！通过ViewHolder的实例对象定义ViewHolder的点击事件
    ！返回ViewHodler的实例对象
（2） onBindViewHolder
    ！根据position获取当前的列表对象
    ！ViewHolder中定义的列表内容根据当前对象来设置具体内容
（3） getItemCount()
    ！ 返回列表数目
4，在调用的Activity中的操作
     ！完成列表的初始化
     ！获取XML中的RecyclerView控件
     ！定义LinearLayoutManager或者StaggeredGridLayoutManager
     ！调用setLayoutManager
     ！setAdapter
 */
public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView recyclerView ;
    private List<Fruit> fruitList ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        addActivity(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycleViewId);

        fruitList = new ArrayList<>() ;
        initFruit();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) ;
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL) ;

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecycleAdapterr recycleAdapterr = new RecycleAdapterr(fruitList) ;
        recyclerView.setAdapter(recycleAdapterr);

    }
    private String getRandomLengthName(String name)
    {
        Random random = new Random() ;
        int length = random.nextInt(20) + 1 ;
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ;i < length ;i++)
        {
            builder.append(name) ;
        }
        return builder.toString() ;
    }
    public void initFruit()
    {
        for (int i = 0 ; i < 10 ;i++)
        {
            Fruit aixin = new Fruit(getRandomLengthName("aixin") , R.mipmap.aixine) ;
            Fruit cilun = new Fruit(getRandomLengthName("cilun") , R.mipmap.timge) ;
            Fruit xueshan = new Fruit(getRandomLengthName("xueshan") , R.mipmap.xueshane) ;
            fruitList.add(aixin) ;
            fruitList.add(cilun) ;
            fruitList.add(xueshan) ;
        }
    }
    public static class RecycleAdapterr extends RecyclerView.Adapter<RecycleAdapterr.ViewHoler>
    {

        private List<Fruit> fruitList ;
        public RecycleAdapterr(List<Fruit> fruitList)
        {
            this.fruitList = fruitList ;
        }

        public static class ViewHoler extends RecyclerView.ViewHolder
        {
            ImageView imageView ;
            TextView textView ;
            public ViewHoler(View itemView) {
                super(itemView);
                imageView = (ImageView)itemView.findViewById(R.id.recycleImageId) ;
                textView = (TextView) itemView.findViewById(R.id.recycleNameId) ;
            }
        }
        @Override
        public RecycleAdapterr.ViewHoler onCreateViewHolder(final ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item , parent ,false) ;
            final RecycleAdapterr.ViewHoler viewHolder = new ViewHoler(view) ;
//            view.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(parent.getContext() ,"点击了RecyclerView" ,Toast.LENGTH_SHORT).show();
//                }
//            });
            viewHolder.imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition() ;
                    Fruit fruit = fruitList.get(position) ;
                    Toast.makeText(parent.getContext() , "点击了第"+position+"个图片",Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.textView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition() ;
                    Fruit fruit = fruitList.get(position) ;
                    Toast.makeText(parent.getContext() , "点击了第"+position+"个文字",Toast.LENGTH_SHORT).show();
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecycleAdapterr.ViewHoler holder, int position) {

            Fruit fruit = fruitList.get(position) ;
            holder.textView.setText(fruit.getName());
            holder.imageView.setImageResource(fruit.getImageId());

        }

        @Override
        public int getItemCount() {
            return fruitList.size();
        }






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
