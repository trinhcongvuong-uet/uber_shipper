package com.vuongtc.uet.uber_shipper.adapters;

import com.vuongtc.uet.uber_shipper.provinces.Provinces;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/30/2017.
 */

public class ProvinceAdapter{

    private ArrayList<Provinces> provinces;

    public ProvinceAdapter(ArrayList<Provinces> provinces) {
        this.provinces = provinces;
    }

    public ArrayList<Provinces> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Provinces> provinces) {
        this.provinces = provinces;
    }
}
