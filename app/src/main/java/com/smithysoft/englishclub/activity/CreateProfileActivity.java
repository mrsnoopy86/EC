package com.smithysoft.englishclub.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.fragments.JoinNow;
import com.smithysoft.englishclub.fragments.SignIn;

/**
 * Created by Admin on 28.06.2015.
 */
public class CreateProfileActivity extends ActionBarActivity implements View.OnClickListener {
    Toolbar toolbar;
    SliderLayout sliderShow;
    Button joinNow;
    Button signIn;
    FragmentTransaction fragmentTransaction;
    JoinNow fragmentJoinNow;
    SignIn fragmentSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofilescreen);
        joinNow = (Button) findViewById(R.id.buttonSignIn);
        joinNow.setOnClickListener(this);
        signIn = (Button) findViewById(R.id.buttonSignIn);
        signIn.setOnClickListener(this);
        fragmentJoinNow = new JoinNow();
        fragmentSignIn = new SignIn();

        initToolbar();
        initSlider();
    }

    private void initSlider() {
        sliderShow = (SliderLayout) findViewById(R.id.slider);

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

    @Override
    public void onClick(View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.buttonJoinNow :
                Toast.makeText(this,"join now",Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSignIn:
                Toast.makeText(this,"Go in fragment",Toast.LENGTH_SHORT).show();
                fragmentTransaction.add(R.id.main_reg, fragmentJoinNow);
                fragmentTransaction.commit();
                break;
            default:
                break;
        }

    }
}
