package com.vuongtc.uet.uber_shipper.provinces;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class Ward {
    private String ward_id;
    private String ward_name;
    private String ward_type;
    private String ward_location;
    private String district_id;

    public Ward(String ward_id, String ward_name, String ward_type, String ward_location, String district_id) {
        this.ward_id = ward_id;
        this.ward_name = ward_name;
        this.ward_type = ward_type;
        this.ward_location = ward_location;
        this.district_id = district_id;
    }

    public String getWard_id() {
        return ward_id;
    }

    public void setWard_id(String ward_id) {
        this.ward_id = ward_id;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    public String getWard_type() {
        return ward_type;
    }

    public void setWard_type(String ward_type) {
        this.ward_type = ward_type;
    }

    public String getWard_location() {
        return ward_location;
    }

    public void setWard_location(String ward_location) {
        this.ward_location = ward_location;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }
}
