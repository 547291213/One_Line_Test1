package com.example.xkfeng.one_line_test1;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.xkfeng.one_line_test1.BaseActivity;
import com.example.xkfeng.one_line_test1.R;

/**
 * Created by initializing on 2018/5/22.
 */

public class NewstTiltleActivity extends BaseActivity {

    /*
       同一代码部署再手机和平板上面显示出不同的效果
       新闻列表效果
       1 实体类News
       2 ContentFragment以及部署文件
       3 ContentActivity加载新闻内容
       3 TitleFragment以及部署文件 分别列出两个同名的布局文件layout-sw600dp
       4 TitleFragment中需要判断是不是两页，boolean isTwoPane
       5 如果是两页则直接更换内容，一页则需要另外启动Activity
       
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_main_layout);
        addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
