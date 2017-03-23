package com.vuongtc.uet.uber_shipper.provinces;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class Province {
    private String province_id;
    private String province_name;
    private String province_type;
    private ArrayList<District> province_district;

    public Province(String province_id, String province_name, String province_type,ArrayList<District> province_district) {
        this.province_id = province_id;
        this.province_name = province_name;
        this.province_type = province_type;
        this.province_district = province_district;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getProvince_type() {
        return province_type;
    }

    public void setProvince_type(String province_type) {
        this.province_type = province_type;
    }

    public ArrayList<District> getProvince_district() {
        return province_district;
    }

    public void setProvince_district(ArrayList<District> province_district) {
        this.province_district = province_district;
    }
}
