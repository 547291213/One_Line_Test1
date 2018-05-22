package com.example.xkfeng.one_line_test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by initializing on 2018/5/22.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }

    public void LoginClick(View view)
    {
        Intent intent = new Intent(LoginActivity.this , MainActivity.class) ;
        startActivity(intent);

    }
}
