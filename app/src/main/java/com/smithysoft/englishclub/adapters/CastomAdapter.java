package com.smithysoft.englishclub.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.db.chart.listener.OnEntryClickListener;
import com.db.chart.view.BarChartView;
import com.db.chart.view.HorizontalBarChartView;
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
        LinearLayout golosovanie;
        LinearLayout photogrid;
        LinearLayout progressBarLayout;
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
            holder.golosovanie = (LinearLayout) convertView.findViewById(R.id.golosovanie);
            holder.photogrid = (LinearLayout) convertView.findViewById(R.id.photogrid);
            holder.progressBarLayout = (LinearLayout) convertView.findViewById(R.id.progressBarLayout);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        if(position%3 == 0){
            holder.photogrid.setVisibility(View.VISIBLE);
            holder.golosovanie.setVisibility(View.GONE);
        } else {
            if(position%2 == 0){
                holder.photogrid.setVisibility(View.GONE);
                holder.golosovanie.setVisibility(View.VISIBLE);
                holder.radioGrouproup.setVisibility(View.VISIBLE);
                holder.progressBarLayout.setVisibility(View.GONE);
            } else {
                holder.photogrid.setVisibility(View.GONE);
                holder.golosovanie.setVisibility(View.VISIBLE);
                holder.radioGrouproup.setVisibility(View.GONE);
                holder.progressBarLayout.setVisibility(View.VISIBLE);
            }
        }

        return convertView;
    }


}
