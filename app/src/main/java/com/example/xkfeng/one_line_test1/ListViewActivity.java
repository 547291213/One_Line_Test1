package com.example.xkfeng.one_line_test1;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xkfeng.one_line_test1.simpleClass.Fruit;
import com.example.xkfeng.one_line_test1.simpleClass.FruitAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by initializing on 2018/5/16.
 */

public class ListViewActivity extends BaseActivity {
    private ListView listViewId ;

    private List<Fruit> list_fruit ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        listViewId = (ListView) findViewById(R.id.listViewId);

        addActivity(this);

        list_fruit = new ArrayList<>();
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.list_item, list_fruit);
        listViewId.setAdapter(fruitAdapter);

        listViewId.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListViewActivity.this , "点击了："+list_fruit.get(position).getName() , Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void initFruit()
    {
        for (int i = 0 ; i < 10 ;i++)
        {
            Fruit aixin = new Fruit("aixin" , R.mipmap.aixine) ;
            Fruit cilun = new Fruit("cilun" , R.mipmap.timge) ;
            Fruit xueshan = new Fruit("xueshan" , R.mipmap.xueshane) ;
            list_fruit.add(aixin) ;
            list_fruit.add(cilun) ;
            list_fruit.add(xueshan) ;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
