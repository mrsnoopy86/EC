package com.smithysoft.englishclub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.utils.Item;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by User on 30.06.2015.
 */
public class CastomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Item> list = new ArrayList<>();
    LayoutInflater inflater ;

    public CastomAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    class Holder {
        ImageView imageViewLogo;
        TextView textViewTitle;
        TextView textViewContent;
        TextView textViewQuestion;
        RadioGroup radioGrouproup;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_news, parent, false);
            holder = new Holder();
            holder.imageViewLogo = (ImageView) convertView.findViewById(R.id.imageViewLogo);
            holder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            holder.textViewContent = (TextView) convertView.findViewById(R.id.textViewQuestion);
            holder.radioGrouproup = (RadioGroup) convertView.findViewById(R.id.radioGroup);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        return convertView;
    }
}
