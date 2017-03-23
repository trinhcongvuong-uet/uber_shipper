package com.vuongtc.uet.uber_shipper.provinces;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class District {
    private String district_id;
    private String district_name;
    private String district_type;
    private String district_location;
    private String province_id;
    private ArrayList<Ward> district_ward;

    public District(String district_id, String district_name, String district_type, String district_location,
                    String province_id, ArrayList<Ward> district_ward) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.district_type = district_type;
        this.district_location = district_location;
        this.province_id = province_id;
        this.district_ward = district_ward;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getDistrict_type() {
        return district_type;
    }

    public void setDistrict_type(String district_type) {
        this.district_type = district_type;
    }

    public String getDistrict_location() {
        return district_location;
    }

    public void setDistrict_location(String district_location) {
        this.district_location = district_location;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public ArrayList<Ward> getDistrict_ward() {
        return district_ward;
    }

    public void setDistrict_ward(ArrayList<Ward> district_ward) {
        this.district_ward = district_ward;
    }
}
