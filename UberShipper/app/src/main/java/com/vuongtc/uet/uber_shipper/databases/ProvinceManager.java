package com.vuongtc.uet.uber_shipper.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuongtc.uet.uber_shipper.provinces.District;
import com.vuongtc.uet.uber_shipper.provinces.Provinces;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class ProvinceManager {

    private static final java.lang.String SQL_GET_PROVINCES = "SELECT * FROM provinces";
    private static final java.lang.String PROVINCE_ID = "provinceid";
    private static final java.lang.String PROVINCE_NAME = "name";
    private static final java.lang.String PROVINCE_TYPE = "type";

    private SQLiteDatabase database;
    private DistrictManager districtManager;

    public ProvinceManager(SQLiteDatabase database) {
        this.database = database;
        districtManager = new DistrictManager(database);
    }

    public ArrayList<Provinces> getProvinces(){
        ArrayList<Provinces> provinces = new ArrayList<Provinces>();

        Cursor cursor = database.rawQuery(SQL_GET_PROVINCES,null);
        if(cursor != null) {
            int in_province_id, in_province_name, in_province_type;
            in_province_id = cursor.getColumnIndex(PROVINCE_ID);
            in_province_name = cursor.getColumnIndex(PROVINCE_NAME);
            in_province_type = cursor.getColumnIndex(PROVINCE_TYPE);

            Provinces province;
            java.lang.String province_id, province_name, province_type;
            ArrayList<District> districts;

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                province_id = cursor.getString(in_province_id);
                province_name = cursor.getString(in_province_name);
                province_type = cursor.getString(in_province_type);
                districts = districtManager.getDistricts(province_id);

                province = new Provinces(province_id, province_name, province_type,districts);
                provinces.add(province);
                cursor.moveToNext();
            }
        }
        return provinces;
    }
}
