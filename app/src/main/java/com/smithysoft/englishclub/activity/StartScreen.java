package com.smithysoft.englishclub.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.smithysoft.englishclub.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Admin on 28.06.2015.
 */
public class StartScreen extends Activity {
    private MaterialEditText login, password;
    private final int DIALOG_CREATE_PROFILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        login = (MaterialEditText) findViewById(R.id.editTextLogin);
        password = (MaterialEditText) findViewById(R.id.editTextPass);
    }

    public void onCreateProfile(View view) {

//        showDialog(DIALOG_CREATE_PROFILE);
        Intent intent = new Intent(this, TTTTT.class);
        startActivity(intent);
    }

    public void onSingIn(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
//        if(!TextUtils.isEmpty(login.getText().toString()) || !TextUtils.isEmpty(password.getText().toString())){
//            if(login.getText().toString().equals("tremtyachiy@gmail.com") && password.getText().toString().equals("tremtyachiy")){
//                Toast.makeText(this, "Sing in", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Login or password incorrect", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(this, "Input your e-mail and password", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LinearLayout dialogView = (LinearLayout) getLayoutInflater().inflate(R.layout.alert_dialog_create_login, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        return dialog.create();
    }

    public void onDialogButtonCreate(View view) {
        switch (view.getId()){
            case R.id.confirm_button_create:
                dismissDialog(DIALOG_CREATE_PROFILE);
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Successfully")
                        .setConfirmText("OK")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();
                                }
                        })
                        .show();
                break;
            case R.id.cancel_button_create:
                dismissDialog(DIALOG_CREATE_PROFILE);
                break;
            default:
                break;

        }
    }
}
