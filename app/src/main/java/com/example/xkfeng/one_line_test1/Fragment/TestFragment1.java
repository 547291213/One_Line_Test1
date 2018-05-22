package com.example.xkfeng.one_line_test1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xkfeng.one_line_test1.R;

/**
 * Created by initializing on 2018/5/16.
 */

public class TestFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
             View view =  LayoutInflater.from(getContext()).inflate(R.layout.test_fragment1 , null ,false) ;
             return view ;

    }
}
