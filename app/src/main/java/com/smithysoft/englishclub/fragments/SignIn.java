package com.smithysoft.englishclub.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smithysoft.englishclub.R;

/**
 * Created by Philip on 07.07.2015.
 */
public class SignIn extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in,container, false);
        return view;
    }
}
