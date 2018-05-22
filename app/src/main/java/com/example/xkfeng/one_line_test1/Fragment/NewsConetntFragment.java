package com.example.xkfeng.one_line_test1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xkfeng.one_line_test1.R;

/**
 * Created by initializing on 2018/5/22.
 */

public class NewsConetntFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = new View(getContext()) ;
        view = inflater.inflate(R.layout.news_conetnt_layout , container , false) ;
        return view ;
    }

    public void refresh(String newsTitle ,String newsContent)
    {
        View visi = (View)view.findViewById(R.id.visibility_layout) ;
        visi.setVisibility(View.VISIBLE);
        TextView title = (TextView)view.findViewById(R.id.news_title) ;
        TextView content = (TextView) view.findViewById(R.id.news_content) ;
        title.setText(newsTitle);
        content.setText(newsContent);
    }
}
