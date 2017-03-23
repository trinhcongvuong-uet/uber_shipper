package com.vuongtc.uet.uber_shipper.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuongtc.uet.uber_shipper.provinces.Ward;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class WardManager {

    private static final String SQL_GET_WARDS = "SELECT * FROM WARDS WHERE DISTRICTID = '";
    private static final String WARD_ID = "WARDID";
    private static final String WARD_NAME = "NAME";
    private static final String WARD_TYPE = "TYPE";
    private static final String WARD_LOCATION = "LOCATION";
    private static final String WARD_DISTRICT_ID = "DISTRICTID";

    private SQLiteDatabase database;

    public WardManager(SQLiteDatabase database) {
        this.database = database;
    }

    public ArrayList<Ward> getWards(String districtid){
        ArrayList<Ward> wards = new ArrayList<Ward>();

        String query = SQL_GET_WARDS + districtid +"'";
        Cursor cursor = database.rawQuery(query,null);

        if(cursor != null){
            int in_ward_id, in_ward_name, in_ward_type, in_ward_location, in_ward_districtid;

            in_ward_id = cursor.getColumnIndex(WARD_ID);
            in_ward_name = cursor.getColumnIndex(WARD_ID);
            in_ward_type = cursor.getColumnIndex(WARD_ID);
            in_ward_location = cursor.getColumnIndex(WARD_ID);
            in_ward_districtid = cursor.getColumnIndex(WARD_ID);

            String ward_id,ward_name,ward_type,ward_location,ward_districtid;
            Ward ward;

            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ward_id = cursor.getString(in_ward_id);
                ward_name = cursor.getString(in_ward_name);
                ward_type = cursor.getString(in_ward_type);
                ward_location = cursor.getString(in_ward_location);
                ward_districtid = cursor.getString(in_ward_districtid);

                ward = new Ward(ward_id,ward_name,ward_type,ward_location,ward_districtid);
                wards.add(ward);

                cursor.moveToNext();
            }
        }
        return wards;
    }
}
