package com.example.xkfeng.one_line_test1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by initializing on 2018/5/15.
 */

public class BaseActivity extends AppCompatActivity {
    public static  List<Activity> activities = new ArrayList<>() ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity" , getClass().getSimpleName())  ;

    }

    public static void addActivity(Activity activity)
    {
        if (activity != null)
        activities.add(activity);
    }

    public static void removeActivity(Activity activity)
    {
        if (activity != null)
        activities.remove(activity) ;
    }

    public static void finishAll()
    {
        for (Activity activitie :activities )
        {
                activities.remove(activitie) ;
        }
    }

}
