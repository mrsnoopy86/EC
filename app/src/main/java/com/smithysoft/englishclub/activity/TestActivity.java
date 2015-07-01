package com.smithysoft.englishclub.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.adapters.CastomAdapter;
import com.smithysoft.englishclub.utils.Item;

import java.util.ArrayList;

/**
 * Created by User on 30.06.2015.
 */
public class TestActivity extends Activity implements OnShowcaseEventListener{
    ListView lv;
    ArrayList<Item> list = new ArrayList<>();
    CastomAdapter castomAdapter;
    ShowcaseView sv;
    private static final float ALPHA_DIM_VALUE = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        castomAdapter = new CastomAdapter(this,list);
        fillArray();

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(castomAdapter);
        castomAdapter.notifyDataSetChanged();

        RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lps.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        int margin = ((Number) (getResources().getDisplayMetrics().density * 12)).intValue();
        lps.setMargins(margin, margin, margin, margin+80);

        ViewTarget target = new ViewTarget(R.id.listView, this);
        sv = new ShowcaseView.Builder(this, true)
                .setTarget(target)
                .setContentTitle("Example")
                .setContentText("Now you can learning")
                .setStyle(R.style.CustomShowcaseTheme2)
                .setShowcaseEventListener(this)
                .build();
        sv.setButtonPosition(lps);
        sv.show();
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
