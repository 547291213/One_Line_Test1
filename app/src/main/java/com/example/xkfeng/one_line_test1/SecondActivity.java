package com.example.xkfeng.one_line_test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by initializing on 2018/5/15.
 */

public class SecondActivity extends BaseActivity {

    private final static String TAG = "One_Line_Test1" ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        ActionBar actionBar = getSupportActionBar() ;
        if (actionBar != null)
        {
            actionBar.hide();
        }

        Intent intent =  getIntent() ;
        String name = intent.getStringExtra("author") ;
        Log.i(TAG , "The secondAct data gain is " + name) ;
        Log.e(TAG , "Second onCreate") ;

        addActivity(this);
    }

    /*
    儅返回的時候調用
     */
    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        Intent intent1 = new Intent() ;
        intent1.putExtra("name"  , "SecondActivity") ;
        setResult(RESULT_OK , intent1);
        finish();
        removeActivity(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG , "Second onStart") ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG , "Second onResume") ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG , " Second onPause") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG ,"Second onStop") ;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG , "Second onRestart") ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
        Log.e(TAG , "Second onDestory") ;
    }
}
