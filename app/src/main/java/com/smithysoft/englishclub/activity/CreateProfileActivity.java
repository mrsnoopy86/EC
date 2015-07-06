package com.smithysoft.englishclub.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.smithysoft.englishclub.R;

/**
 * Created by Admin on 28.06.2015.
 */
public class CreateProfileActivity extends ActionBarActivity {
    Toolbar toolbar;
    SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofilescreen);
        initToolbar();
        initSlider();

    }

    private void initSlider() {
        sliderShow = (SliderLayout) findViewById(R.id.slider);

        sliderShow.setCustomAnimation(new DescriptionAnimation());

        DefaultSliderView DefaultSliderView = new DefaultSliderView(this);
        DefaultSliderView DefaultSliderViewTwo = new DefaultSliderView(this);
        DefaultSliderView DefaultSliderViewThre = new DefaultSliderView(this);

        DefaultSliderView.image(R.drawable.slider_one);
        DefaultSliderViewTwo.image(R.drawable.slider_two);
        DefaultSliderViewThre.image(R.drawable.slider_thre);

        sliderShow.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));



        sliderShow.addSlider(DefaultSliderView);
        sliderShow.addSlider(DefaultSliderViewTwo);
        sliderShow.addSlider(DefaultSliderViewThre);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a profile");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
