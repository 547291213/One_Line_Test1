package com.example.xkfeng.one_line_test1;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.xkfeng.one_line_test1.Fragment.TestFragment;
import com.example.xkfeng.one_line_test1.Fragment.TestFragment1;

public class MainActivity extends BaseActivity {

    private final static int REQUEST_CODE = 1 ;
    private final static String TAG = "One_Line_Test1"  ;
    private FrameLayout frameLayout ;
    private FragmentManager fragmentManager ;
    private TestFragment fragment ;
    private TestFragment1 fragment1 ;
    private boolean frag_state = true ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addActivity(this);
        frameLayout = (FrameLayout)findViewById(R.id.fragmeLayoutId) ;


        fragment = new TestFragment() ;
        fragment1 = new TestFragment1() ;
        fragmentManager = getSupportFragmentManager() ;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
        fragmentTransaction.replace(R.id.fragmeLayoutId , fragment) ;
        fragmentTransaction.commit() ;

        Log.e(TAG , "Main onCreate") ;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG , "Main onStart") ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG , "Main onResume") ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG , " Main onPause") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG ,"Main onStop") ;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG , "Main onRestart") ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG , "Main onDestory") ;
    }

    public void FramgementChange (View view)
    {
        if (frag_state)
        {
            frag_state = false ;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.fragmeLayoutId , fragment1) ;
            fragmentTransaction.commit() ;
        }else {
            frag_state = true ;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.fragmeLayoutId , fragment) ;
            fragmentTransaction.commit();
        }
    }
    public void ButtonClick(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse("http://www.baidu.com")) ;
        startActivity(intent) ;
    }

    public void NextAct(View view)
    {
        Intent intent = new Intent(MainActivity.this , SecondActivity.class) ;
        intent.putExtra("author" , "Kefeng") ;
        startActivityForResult(intent , REQUEST_CODE);
    }
    public void Percent(View view)
    {
        Intent intent = new Intent(MainActivity.this , PercentActivity.class) ;
        startActivity(intent);
    }

    public void ListViewBtn(View view)
    {
         Intent intent = new Intent(MainActivity.this , ListViewActivity.class) ;
         startActivity(intent);
    }

    public void RecycleViewBtn(View view)
    {

        Intent intent = new Intent(MainActivity.this ,RecyclerViewActivity.class ) ;
        startActivity(intent);
    }


    public void VisualFragment(View view)
    {

        Intent intent = new Intent(MainActivity.this , NewstTiltleActivity.class) ;
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode)
        {
            case REQUEST_CODE :

                if (resultCode == RESULT_OK )
                {
                    Log.i(TAG , data.getStringExtra("name") + "获取的数据");
                }else {
                    Log.i(TAG , "resultCode is error " +  resultCode)  ;
                }
                break;
            default:
                Log.i(TAG , "沒有對應的參數" ) ;
                break;
        }
    }
}
