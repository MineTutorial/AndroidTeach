package com.sun.androidlearn.ui.day01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.androidlearn.R;

/**
 * Author: jfson sun
 * Create on:  2020/3/28
 * Question:
 * Description:
 * Train of thought:
 */
public class TestFragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_two, container, false);
    }

}
