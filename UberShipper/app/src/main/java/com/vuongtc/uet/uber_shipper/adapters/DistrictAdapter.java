package com.vuongtc.uet.uber_shipper.adapters;

import com.vuongtc.uet.uber_shipper.provinces.District;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/30/2017.
 */

public class DistrictAdapter  {

    private ArrayList<District> districts;

    public DistrictAdapter(ArrayList<District> districts) {
        this.districts = districts;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }
}
