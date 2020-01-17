/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

package com.microsoft.device.display.samples.complementarycontext.Fragment;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.microsoft.device.display.samples.complementarycontext.R;
import com.microsoft.device.display.samples.complementarycontext.Slide;

import java.util.ArrayList;

public class SlideFragment extends Fragment {
    private static final String CONTENT = "content";
    private String content;

    private static SlideFragment newInstance(Slide slide) {
        SlideFragment testFragment = new SlideFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CONTENT, slide.getContent());
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_layout, container, false);
        TextView textView = view.findViewById(R.id.text_view);
        if (getArguments() != null) {
            content = getArguments().getString(CONTENT);
            textView.setText(content);
        }
        return view;
    }

    @Override
    @NonNull
    public String toString() {
        return content;
    }

    // Init fragments for ViewPager
    public static SparseArray<SlideFragment> getFragments(ArrayList<Slide> slides) {
        SparseArray<SlideFragment> fragments = new SparseArray<>();
        int i = 0;
        for (Slide slide : slides) {
            fragments.put(i++, SlideFragment.newInstance(slide));
        }
        return fragments;
    }
}
