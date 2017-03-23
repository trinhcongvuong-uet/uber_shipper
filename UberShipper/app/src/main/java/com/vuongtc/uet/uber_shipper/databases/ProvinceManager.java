package com.vuongtc.uet.uber_shipper.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuongtc.uet.uber_shipper.provinces.District;
import com.vuongtc.uet.uber_shipper.provinces.Province;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class ProvinceManager {

    private static final String SQL_GET_PROVINCES = "SELECT * FROM PROVINCES";
    private static final String PROVINCE_ID = "PROVINCEID";
    private static final String PROVINCE_NAME = "NAME";
    private static final String PROVINCE_TYPE = "TYPE";

    private SQLiteDatabase database;
    private DistrictManager districtManager;

    public ProvinceManager(SQLiteDatabase database) {
        this.database = database;
        districtManager = new DistrictManager(database);
    }

    public ArrayList<Province> getProvinces(){
        ArrayList<Province> provinces = new ArrayList<Province>();

        Cursor cursor = database.rawQuery(SQL_GET_PROVINCES,null);
        if(cursor != null) {
            int in_province_id, in_province_name, in_province_type;
            in_province_id = cursor.getColumnIndex(PROVINCE_ID);
            in_province_name = cursor.getColumnIndex(PROVINCE_NAME);
            in_province_type = cursor.getColumnIndex(PROVINCE_TYPE);

            Province province;
            String province_id, province_name, province_type;
            ArrayList<District> districts;

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                province_id = cursor.getString(in_province_id);
                province_name = cursor.getString(in_province_name);
                province_type = cursor.getString(in_province_type);
                districts = districtManager.getDistricts(province_id);

                province = new Province(province_id, province_name, province_type,districts);
                provinces.add(province);
                cursor.moveToNext();
            }
        }
        return provinces;
    }
}
