package com.paypal.gdelapena.alaccy;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CoordinatesFragment  extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView mLat;

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


        mLat = (TextView) rootView.findViewById(R.id.lat_val);

        return rootView;
    }


    public void UpdateView (Location location){
        mLat.setText(String.format("%f", location.getLatitude()));
    }


}
