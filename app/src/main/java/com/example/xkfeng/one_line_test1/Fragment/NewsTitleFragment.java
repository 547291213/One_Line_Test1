package com.example.xkfeng.one_line_test1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xkfeng.one_line_test1.NewsContentActivity;
import com.example.xkfeng.one_line_test1.R;
import com.example.xkfeng.one_line_test1.simpleClass.News;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by initializing on 2018/5/22.
 */

/*
新闻标题列表
 */
public class NewsTitleFragment extends Fragment {
    private View view ;

    /*
    判断是手机还是平板
     */
    public boolean isTowPane ;
    private String TAG = "NewsTitleFragment" ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.news_title_frag , container , false) ;

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.new_title_recycle_view) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) ;
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(getNews()) ;
        recyclerView.setAdapter(newsAdapter);
        Log.i(TAG , "NEWSTITLEFRAGMENT IS CREATEED") ;
        return view ;
    }

    private List<News> getNews()
    {
        List<News> newsList = new ArrayList<>() ;
        for (int i = 1 ; i <=  50 ; i++)
        {
            News news = new News() ;
            news.setTitle("This is news title " + i);
            news.setContent(getRandomLengthContent("This is news content " + i + ". "));
            newsList.add(news)  ;
        }
        Log.i(TAG , "newslist size is " + newsList.size()) ;

        return newsList ;
    }
    private String getRandomLengthContent(String content)
    {
        Random random = new Random() ;
        int length = random.nextInt(20 ) + 1 ;
        StringBuilder builder = new StringBuilder() ;
        for (int i = 0 ; i < length ; i++)
        {
            builder.append(content) ;
        }
        return builder.toString() ;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_fragment) != null)
        {
            isTowPane = true ;  //双页
        }else {
            isTowPane = false ; //单页
        }
    }
    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder>
    {
        private List<News> newsList ;
        public NewsAdapter(List<News> newsList)
        {
            this.newsList = newsList ;
            Log.i(TAG , "newslist size is " + newsList.size()) ;
        }
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_title_item , parent , false) ;
            final MyHolder myHolder = new MyHolder(view) ;
            myHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    News news = newsList.get(myHolder.getAdapterPosition()) ;
                    Log.i("NewsTitleFragment" , "isTowPane is " + isTowPane) ;
                    if (isTowPane)
                    {
                        NewsConetntFragment newsConetntFragment = (NewsConetntFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment) ;
                        newsConetntFragment.refresh(news.getTitle() , news.getContent());

                    }else {

                        NewsContentActivity.actionStart(getActivity() , news.getTitle() , news.getContent());
                    }
                }
            });
            return myHolder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {

            News news = newsList.get(position) ;
            holder.textView.setText(news.getTitle());
            Log.i(TAG , "new.title is " + news.getTitle())  ;
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        public  class MyHolder extends RecyclerView.ViewHolder
        {
            TextView textView ;
            public MyHolder(View itemView) {
                super(itemView);
                textView = (TextView)itemView.findViewById(R.id.news_title_recyle_view_item) ;

            }
        }

    }
}
