package com.smithysoft.englishclub.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.adapters.CustomAdapter;
import com.smithysoft.englishclub.utils.Item;

import java.util.ArrayList;

/**
 * Created by User on 30.06.2015.
 */
public class TestActivity extends ActionBarActivity implements OnShowcaseEventListener{
    ListView lv;
    ArrayList<Item> list = new ArrayList<>();
    CustomAdapter castomAdapter;
    ShowcaseView sv;
    private static final float ALPHA_DIM_VALUE = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        castomAdapter = new CustomAdapter(this,list);
        fillArray();


        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(castomAdapter);
        castomAdapter.notifyDataSetChanged();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Ivent");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

//        RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        lps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        lps.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        int margin = ((Number) (getResources().getDisplayMetrics().density * 12)).intValue();
//        lps.setMargins(margin, margin, margin, margin+80);
//
//        ViewTarget target = new ViewTarget(R.id.listView, this);
//        sv = new ShowcaseView.Builder(this, true)
//                .setTarget(target)
//                .setContentTitle("Example")
//                .setContentText("Now you can learning")
//                .setStyle(R.style.CustomShowcaseTheme2)
//                .setShowcaseEventListener(this)
//                .build();
//        sv.setButtonPosition(lps);
//        sv.show();

    }

    private void fillArray() {
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
    }

    @Override
    public void onShowcaseViewHide(ShowcaseView showcaseView) {
        lv.setAlpha(1f);
    }

    @Override
    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

    }

    @Override
    public void onShowcaseViewShow(ShowcaseView showcaseView) {
        dimView(lv);
    }

    private void dimView(View view) {
        view.setAlpha(ALPHA_DIM_VALUE);
    }
}
