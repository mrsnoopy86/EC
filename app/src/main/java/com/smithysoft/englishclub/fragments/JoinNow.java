package com.smithysoft.englishclub.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smithysoft.englishclub.R;

/**
 * Created by Philip on 07.07.2015.
 */
public class JoinNow extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_join_now, container,false);

        return view;
    }
}
