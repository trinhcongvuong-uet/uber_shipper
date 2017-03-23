package com.vuongtc.uet.uber_shipper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuongtc.uet.uber_shipper.R;

/**
 * Created by vuongtc on 3/22/2017.
 */
public class GpsPostFragment extends Fragment {

    public GpsPostFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gpspost, container, false);
    }
}
