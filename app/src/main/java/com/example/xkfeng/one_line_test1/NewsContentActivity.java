package com.example.xkfeng.one_line_test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.xkfeng.one_line_test1.Fragment.NewsConetntFragment;

/**
 * Created by initializing on 2018/5/22.
 */

public class NewsContentActivity extends BaseActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
     }

     public static void actionStart(Context context , String newsTitle , String newsContent )
     {
         Intent intent = new Intent(context , NewsContentActivity.class) ;
         intent.putExtra("news_title" , newsTitle) ;
         intent.putExtra("news_content" , newsContent) ;
         context.startActivity(intent);
     }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_act);

        /*
        根据新闻的内容来设置相关属性
         */
        String newsTitle = getIntent().getStringExtra("news_title") ;
        String newsContent = getIntent().getStringExtra("news_content") ;
        NewsConetntFragment newsConetntFragment = (NewsConetntFragment)getSupportFragmentManager().findFragmentById(R.id.title_layout) ;
        newsConetntFragment.refresh(newsTitle  , newsContent);

        addActivity(this);
    }
}
