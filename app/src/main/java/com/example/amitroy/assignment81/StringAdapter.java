package com.example.amitroy.assignment81;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMIT ROY on 15-May-17.
 */

public class StringAdapter extends BaseAdapter {
    private List<String>data;
    Context context;
    LayoutInflater inflater;
    public StringAdapter(Context context, int sort_list_item, List<String> data){
        this.context=context;
        this.data=data;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder=new ViewHolder();
        View view=convertView;
        if(view==null) {
            view = View.inflate(context, R.layout.sort_list_item, null);
            viewholder.text = (TextView) view.findViewById(R.id.name_text);
            view.setTag(viewholder);
        }else {
            viewholder=(ViewHolder)view.getTag();
        }
String name_text=data.get(position);
        viewholder.text.setText(name_text);
        return view;
    }
    public class ViewHolder{
        TextView text;
    }
}
