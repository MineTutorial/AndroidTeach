package com.sun.androidlearn.ui.day01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.androidlearn.R;

public class TestFragmentMyFour extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_test04, container, false);
    }

}
