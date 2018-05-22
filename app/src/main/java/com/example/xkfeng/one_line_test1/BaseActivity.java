package com.example.xkfeng.one_line_test1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
    public ForceOffLineReceiver receiver ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity" , getClass().getSimpleName())  ;

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter() ;
        intentFilter.addAction("com.xkfeng.FORCE_OFF_LINE");
        receiver = new ForceOffLineReceiver() ;
        registerReceiver(receiver , intentFilter) ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver!=null)
        {
            unregisterReceiver(receiver);
            receiver = null ;
        }
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
            if (!activitie.isFinishing())
            {
                activitie.finish();
            }
        }
        activities.clear();
    }

    public class ForceOffLineReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder alert = new AlertDialog.Builder(context) ;
            alert.setTitle("警告");
            alert.setMessage("您已经再其它地方登陆，您被迫下线") ;
            alert.setCancelable(false) ;
            alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAll();
                    Intent intent1 = new Intent(context , LoginActivity.class) ;
                    startActivity(intent1) ;
                }
            });
            alert.show() ;
        }
    }
}
