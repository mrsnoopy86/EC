package com.smithysoft.englishclub.newactivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smithysoft.englishclub.R;

/**
 * Created by Admin on 09.07.2015.
 */
public class LoginScreen extends Activity implements View.OnTouchListener{
    private Button vk_button;
    private Button facebook_button;
    private Button twitter_button;
    private Button youtube_button;
    private Button linkedin_button;
    private Button instagram_button;
    private Button open_social;
    private Button button_log_in;
    private Button button_sing_up;
    private Button button_log_second_in;
    private TextView tvAbout;
    private EditText etLogin;
    private EditText etPassword;
    private LinearLayout ask_question;
    private Button button_ask_question;
    private int OPEN_SOCIAL = 0;
    private int OPEN_ASK = 0;
    private int OPEN_LOGIN_IN = 0;
    private final int DURATION_ANIMATION_SOCIAL = 150;
    private NotificationManager nm;
    private final int NOTIFICATION_ID = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.loginscreen);
        vk_button = (Button) findViewById(R.id.vk_button);
        facebook_button = (Button) findViewById(R.id.facebook_button);
        twitter_button = (Button) findViewById(R.id.twitter_button);
        youtube_button = (Button) findViewById(R.id.youtube_button);
        linkedin_button = (Button) findViewById(R.id.linkedin_button);
        instagram_button = (Button) findViewById(R.id.instagram_button);
        open_social = (Button) findViewById(R.id.open_social);
        button_log_in = (Button) findViewById(R.id.button_log_in_screen);
        button_sing_up = (Button) findViewById(R.id.button_sing_up_screen);
        button_log_second_in = (Button) findViewById(R.id.button_log_second_in);
        tvAbout = (TextView) findViewById(R.id.tvAbout);
        etLogin = (EditText) findViewById(R.id.et_login);
        etPassword = (EditText) findViewById(R.id.et_password);
        ask_question = (LinearLayout) findViewById(R.id.ask_question);
        button_ask_question = (Button) findViewById(R.id.button_ask_question);
        vk_button.setVisibility(View.GONE);
        facebook_button.setVisibility(View.GONE);
        twitter_button.setVisibility(View.GONE);
        youtube_button.setVisibility(View.GONE);
        linkedin_button.setVisibility(View.GONE);
        instagram_button.setVisibility(View.GONE);
        open_social.setVisibility(View.VISIBLE);
        relativeLayout.setOnTouchListener(this);
        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void onOpenSocial(View view){
        openAnimationSocial();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(OPEN_SOCIAL == 1) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                closeAnimationSocial();
            }
        }
        if(OPEN_ASK == 1) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                closeAskQuestion();
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(OPEN_LOGIN_IN == 1){
            closeAnimationLoginIn();
            OPEN_LOGIN_IN = 0;
        } else {
            super.onBackPressed();
        }
    }

    public void onOpenAskQuestion(View view) {
        openAskQuestion();
    }

    public void onLogIn(View view){
        openAnimationLoginIn();
        if(OPEN_SOCIAL == 1){
            closeAnimationSocial();
            OPEN_SOCIAL = 0;
        }
        if(OPEN_ASK == 1){
            closeAskQuestion();
            OPEN_ASK = 0;
        }
    }

    private void openAnimationLoginIn(){
        OPEN_LOGIN_IN = 1;
        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation animation1 = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.slide_in_down);
        animation.setDuration(300);
        animation1.setDuration(300);
        animation2.setDuration(300);
        animation3.setDuration(300);
        animation3.setDuration(300);
        animation4.setDuration(300);
        button_log_in.setAnimation(animation3);
        button_sing_up.setAnimation(animation1);
        tvAbout.setAnimation(animation3);
        button_log_in.setVisibility(View.GONE);
        button_sing_up.setVisibility(View.GONE);
        tvAbout.setVisibility(View.GONE);
        button_log_second_in.setVisibility(View.VISIBLE);
        etLogin.setVisibility(View.VISIBLE);
        etPassword.setVisibility(View.VISIBLE);
        button_log_second_in.setAnimation(animation4);
        etLogin.setAnimation(animation);
        etPassword.setAnimation(animation2);
    }

    private void closeAnimationLoginIn(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation animation2 = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animation3 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.slide_out_down);
        animation.setDuration(300);
        animation1.setDuration(300);
        animation2.setDuration(300);
        animation3.setDuration(300);
        animation3.setDuration(300);
        animation4.setDuration(300);
        button_log_in.setAnimation(animation3);
        button_sing_up.setAnimation(animation1);
        tvAbout.setAnimation(animation3);
        button_log_in.setVisibility(View.VISIBLE);
        button_sing_up.setVisibility(View.VISIBLE);
        tvAbout.setVisibility(View.VISIBLE);
        button_log_second_in.setVisibility(View.GONE);
        etLogin.setVisibility(View.GONE);
        etPassword.setVisibility(View.GONE);
        button_log_second_in.setAnimation(animation4);
        etLogin.setAnimation(animation);
        etPassword.setAnimation(animation2);
    }

    private void openAnimationSocial(){
        if(OPEN_ASK == 1){
            closeAskQuestion();
            OPEN_ASK = 0;
        }
        vk_button.setVisibility(View.VISIBLE);
        facebook_button.setVisibility(View.VISIBLE);
        twitter_button.setVisibility(View.VISIBLE);
        youtube_button.setVisibility(View.VISIBLE);
        linkedin_button.setVisibility(View.VISIBLE);
        instagram_button.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.makeInAnimation(this, true);
        animation.setStartOffset(150);
        animation.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animation2 = AnimationUtils.makeInAnimation(this, true);
        animation2.setStartOffset(250);
        animation2.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animation3 = AnimationUtils.makeInAnimation(this, true);
        animation3.setStartOffset(400);
        animation3.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animation4 = AnimationUtils.makeInAnimation(this, true);
        animation4.setStartOffset(550);
        animation4.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animation5 = AnimationUtils.makeInAnimation(this, true);
        animation5.setStartOffset(700);
        animation5.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animation6 = AnimationUtils.makeInAnimation(this, true);
        animation6.setStartOffset(850);
        animation6.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        open_social.startAnimation(animationOut);
        vk_button.startAnimation(animation);
        facebook_button.startAnimation(animation2);
        twitter_button.startAnimation(animation4);
        youtube_button.startAnimation(animation6);
        linkedin_button.startAnimation(animation3);
        instagram_button.startAnimation(animation5);
        open_social.setVisibility(View.GONE);
        OPEN_SOCIAL = 1;
    }

    private void closeAnimationSocial(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation5 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        Animation animation6 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        animation.setStartOffset(150);
        animation.setDuration(DURATION_ANIMATION_SOCIAL);
        animation2.setStartOffset(250);
        animation2.setDuration(DURATION_ANIMATION_SOCIAL);
        animation3.setStartOffset(400);
        animation3.setDuration(DURATION_ANIMATION_SOCIAL);
        animation4.setStartOffset(550);
        animation4.setDuration(DURATION_ANIMATION_SOCIAL);
        animation5.setStartOffset(700);
        animation5.setDuration(DURATION_ANIMATION_SOCIAL);
        animation6.setStartOffset(850);
        animation6.setDuration(DURATION_ANIMATION_SOCIAL);
        Animation animationOut = AnimationUtils.makeInAnimation(this, true);
        animationOut.setStartOffset(900);
        vk_button.startAnimation(animation);
        facebook_button.startAnimation(animation2);
        twitter_button.startAnimation(animation4);
        youtube_button.startAnimation(animation6);
        linkedin_button.startAnimation(animation3);
        instagram_button.startAnimation(animation5);
        vk_button.setVisibility(View.GONE);
        facebook_button.setVisibility(View.GONE);
        twitter_button.setVisibility(View.GONE);
        youtube_button.setVisibility(View.GONE);
        linkedin_button.setVisibility(View.GONE);
        instagram_button.setVisibility(View.GONE);
        open_social.startAnimation(animationOut);
        open_social.setVisibility(View.VISIBLE);
        OPEN_SOCIAL = 0;
    }

    private void openAskQuestion(){
        if(OPEN_SOCIAL == 1){
            closeAnimationSocial();
            OPEN_SOCIAL = 0;
        }
        Animation animation = AnimationUtils.makeOutAnimation(this, true);
        animation.setDuration(250);
        button_ask_question.startAnimation(animation);
        button_ask_question.setVisibility(View.GONE);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_from_board);
        animation1.setStartOffset(250);
        animation1.setDuration(350);
        ask_question.setVisibility(View.VISIBLE);
        ask_question.startAnimation(animation1);
        OPEN_ASK = 1;
    }

    private void closeAskQuestion(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        animation.setStartOffset(350);
        animation.setDuration(250);
        button_ask_question.startAnimation(animation);
        button_ask_question.setVisibility(View.VISIBLE);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.slide_out_right_from_board);
        animation1.setDuration(350);
        ask_question.setVisibility(View.GONE);
        ask_question.startAnimation(animation1);
        OPEN_ASK = 0;
    }

    public void showNotification(View view) {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), LoginScreen.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_youtube_button)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_youtube_button))
                .setTicker("You haw a massage!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Some massage!")
                .setContentText("Look here for more details.");
        Notification notification = builder.build();

        nm.notify(NOTIFICATION_ID,notification);
    }
}