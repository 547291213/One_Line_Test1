package com.example.xkfeng.one_line_test1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by initializing on 2018/5/15.
 */

public class TitleClass extends LinearLayout {

    private Button button ;
    public TitleClass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout , this) ;

        button = (Button)findViewById(R.id.backBtn) ;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext() , "后退" , Toast.LENGTH_SHORT).show();
                ((Activity) getContext()).finish() ;

            }
        });

    }
}
