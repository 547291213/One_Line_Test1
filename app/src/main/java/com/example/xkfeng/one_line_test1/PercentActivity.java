package com.example.xkfeng.one_line_test1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by initializing on 2018/5/15.
 */

public class PercentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percentframelayout);
        /*
        隐藏标题栏
         */
        ActionBar actionBar = getSupportActionBar() ;
        if (actionBar != null)
        {
            actionBar.hide();
        }

        addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
