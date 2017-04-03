package com.vuongtc.uet.uber_shipper.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuongtc.uet.uber_shipper.provinces.District;
import com.vuongtc.uet.uber_shipper.provinces.Ward;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class DistrictManager {

    private static final String SQL_GET_DISTRICTS = "SELECT *FROM DISTRICTS WHERE PROVINCEID = '";
    private static final String DISTRICT_ID = "districtid";
    private static final String  DISTRICT_NAME= "name";
    private static final String  DISTRICT_TYPE= "type";
    private static final String  DISTRICT_LOCATION= "location";
    private static final String  DISTRICT_PROVINCE_ID= "provinceid";

    private SQLiteDatabase database;
    private WardManager wardManager;

    public DistrictManager(SQLiteDatabase database) {
        this.database = database;
        wardManager = new WardManager(database);
    }

    public ArrayList<District> getDistricts(String provinceid){

        ArrayList<District> districts = new ArrayList<District>();

        String query = SQL_GET_DISTRICTS + provinceid +"'";

        Cursor cursor = database.rawQuery(query,null);
        if(cursor != null){
            int in_district_id,in_district_name,in_district_type,in_district_location,in_district_provinceid;

            in_district_id = cursor.getColumnIndex(DISTRICT_ID);
            in_district_name = cursor.getColumnIndex(DISTRICT_NAME);
            in_district_type = cursor.getColumnIndex(DISTRICT_TYPE);
            in_district_location = cursor.getColumnIndex(DISTRICT_LOCATION);
            in_district_provinceid = cursor.getColumnIndex(DISTRICT_PROVINCE_ID);

            District district;
            ArrayList<Ward> wards;
            String distric_id,district_name,district_type,district_location,district_provinceid;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                distric_id = cursor.getString(in_district_id);
                district_type = cursor.getString(in_district_type);
                district_name = cursor.getString(in_district_name);
                district_location = cursor.getString(in_district_location);
                district_provinceid = cursor.getString(in_district_provinceid);
                wards = wardManager.getWards(distric_id);

                district = new District(distric_id,district_name,district_type,district_location,district_provinceid,wards);
                districts.add(district);

                cursor.moveToNext();
            }
        }

        return districts;
    }
}
