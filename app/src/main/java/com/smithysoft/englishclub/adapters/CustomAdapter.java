package com.smithysoft.englishclub.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.db.chart.listener.OnEntryClickListener;
import com.db.chart.view.BarChartView;
import com.db.chart.view.HorizontalBarChartView;
import com.nineoldandroids.view.ViewHelper;
import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.utils.Item;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

/**
 * Created by User on 30.06.2015.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Item> list = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    class Holder {
//        ImageView imageViewLogo;
//        TextView textViewTitle;
//        TextView textViewContent;
//        TextView textViewQuestion;
        RadioGroup radioGrouproup;
        LinearLayout golosovanie;
        LinearLayout photogrid;
        LinearLayout progressBarLayout;
        IconRoundCornerProgressBar progressBarFirst;
        IconRoundCornerProgressBar progressBarSecond;
        IconRoundCornerProgressBar progressBarThird;
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
        final Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_news, parent, false);
            holder = new Holder();
//            holder.imageViewLogo = (ImageView) convertView.findViewById(R.id.imageViewLogo);
//            holder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
//            holder.textViewContent = (TextView) convertView.findViewById(R.id.textViewQuestion);
            holder.radioGrouproup = (RadioGroup) convertView.findViewById(R.id.radioGroup);
            holder.golosovanie = (LinearLayout) convertView.findViewById(R.id.golosovanie);
            holder.photogrid = (LinearLayout) convertView.findViewById(R.id.photogrid);
            holder.progressBarLayout = (LinearLayout) convertView.findViewById(R.id.progressBarLayout);
            holder.progressBarFirst = (IconRoundCornerProgressBar) convertView.findViewById(R.id.progressBarFirst);
            holder.progressBarSecond = (IconRoundCornerProgressBar) convertView.findViewById(R.id.progressBarSecond);
            holder.progressBarThird = (IconRoundCornerProgressBar) convertView.findViewById(R.id.progressBarThird);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position % 2 == 0) {
            holder.photogrid.setVisibility(View.VISIBLE);
            holder.golosovanie.setVisibility(View.GONE);
        } else {
            holder.photogrid.setVisibility(View.GONE);
            holder.golosovanie.setVisibility(View.VISIBLE);
            holder.radioGrouproup.setVisibility(View.VISIBLE);
            holder.progressBarLayout.setVisibility(View.GONE);
        }
        holder.radioGrouproup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                if (checkedRadioButton.isChecked()) {
                    holder.radioGrouproup.setVisibility(View.GONE);
                    holder.progressBarLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    return convertView;
    }
}
