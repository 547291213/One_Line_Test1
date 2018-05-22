package com.example.xkfeng.one_line_test1.simpleClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xkfeng.one_line_test1.R;

import java.util.List;

/**
 * Created by initializing on 2018/5/16.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>
{

    private int resourceId ;
    public FruitAdapter(@NonNull Context context, int resource , List<Fruit> list) {
        super(context, resource,list);
        resourceId = resource ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit = getItem(position) ;
        ImageView imageView = null;
        TextView textView = null ;
        View view ;
        ViewHolder viewHolder ;


        if (convertView == null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourceId , parent , false) ;
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.imageId) ;
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruitNameId) ;
            view.setTag(viewHolder);

        }else {
            view = convertView ;
            viewHolder = (ViewHolder)view.getTag() ;
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;

    }
    public class ViewHolder{
        ImageView fruitImage ;
        TextView fruitName ;
    }
}
