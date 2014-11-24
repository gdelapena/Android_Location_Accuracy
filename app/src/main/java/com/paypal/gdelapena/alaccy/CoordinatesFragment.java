package com.paypal.gdelapena.alaccy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CoordinatesFragment  extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";


    public static CoordinatesFragment newInstance( int sectionNumber) {

        CoordinatesFragment fragment = new CoordinatesFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    public CoordinatesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coordinates, container, false);
        return rootView;
    }

}
