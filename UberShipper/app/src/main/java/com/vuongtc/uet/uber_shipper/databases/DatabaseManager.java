package com.vuongtc.uet.uber_shipper.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.vuongtc.uet.uber_shipper.provinces.District;
import com.vuongtc.uet.uber_shipper.provinces.Provinces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vuongtc on 3/23/2017.
 */
public class DatabaseManager implements Serializable{

    private Context mContext;
    private SQLiteDatabase database;

    private WardManager wardManager;
    private DistrictManager districtManager;
    private ProvinceManager provinceManager;

    private final static java.lang.String DB_PATH = Environment.getDataDirectory().getPath()+"/data/com.vuongtc.uet.uber_shipper/databases";
    private static final java.lang.String DB_NAME = "database_district.sqlite";

    public DatabaseManager(Context mContext) {
        this.mContext = mContext;
        copyDB();
    }



    public void openDB(){
        java.lang.String path = DB_PATH+"/"+DB_NAME;
        if(database==null||database.isOpen()==false){
            database = SQLiteDatabase.openDatabase(DB_PATH+"/"+DB_NAME,null,SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public ArrayList<Provinces> getProvinces(){
        openDB();
        provinceManager = new ProvinceManager(database);
        ArrayList<Provinces> provinces = provinceManager.getProvinces();
        closeDB();
        return provinces;
    }

    public ArrayList<District> getDistricts(String provinceid){
        openDB();
        districtManager = new DistrictManager(database);
        ArrayList<District> districts = districtManager.getDistricts(provinceid);
        closeDB();
        return districts;
    }

    public void closeDB(){
        if(database!=null&&database.isOpen()){
            database.close();
            database = null;
        }
    }

    private void copyDB(){
        new File(DB_PATH).mkdirs();
        File file = new File(DB_PATH+"/"+DB_NAME);
        if(file.exists()){
            return;
        }

        try {
            file.createNewFile();
            InputStream inputStream = mContext.getAssets().open(DB_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int lenght;
            byte buff[] = new byte[1024];
            java.lang.String result = "";
            while ((lenght = inputStream.read(buff))>0){
                fileOutputStream.write(buff,0,lenght);
            }
            inputStream.close();
            fileOutputStream.close();
            Log.i("COPY","DB is Copy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
