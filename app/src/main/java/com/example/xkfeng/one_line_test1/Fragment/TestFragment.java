package com.example.xkfeng.one_line_test1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xkfeng.one_line_test1.R;

/**
 * Created by initializing on 2018/5/16.
 */

public class TestFragment extends Fragment {
    private final static String TAG = "TestFragment"  ;
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Log.i(TAG , "onAttach") ;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG , "onCreate") ;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.test_fragment , null ,false) ;
        Log.i(TAG , "onCreateView") ;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG , "onActivityCreate") ;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG , "onStart") ;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG , "onResume") ;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG , "onPause") ;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG , "onStop") ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG , "onDestroyView") ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG , "onDestroy") ;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG , "onDetach") ;
    }

}
