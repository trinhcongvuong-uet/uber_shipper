package com.vuongtc.uet.uber_shipper.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.vuongtc.uet.uber_shipper.R;
import com.vuongtc.uet.uber_shipper.activities.MainActivity;
import com.vuongtc.uet.uber_shipper.adapters.DistrictAdapter;
import com.vuongtc.uet.uber_shipper.adapters.ProvinceAdapter;
import com.vuongtc.uet.uber_shipper.applications.MyApplication;
import com.vuongtc.uet.uber_shipper.databases.DatabaseManager;

import java.util.ArrayList;

/**
 * Created by vuongtc on 3/22/2017.
 */
public class AddressPostFragment extends Fragment {

    private Context mContext;
    private View rootView;

    private Spinner spinnerProvinces;
    private Spinner spinnerDistricts;

    private ProvinceAdapter provinceAdapter;
    private DistrictAdapter districtAdapter;

    private ArrayList<String> string_provinces = new ArrayList<String>();

    public void setString_districts(int i) {
        spinnerDistricts.setEnabled(true);
        MyApplication myApplication = (MyApplication) ((MainActivity)mContext).getApplication();
        DatabaseManager databaseManager = myApplication.getDatabaseManager();
        String id = provinceAdapter.getProvinces().get(i).getProvince_id();

        districtAdapter = new DistrictAdapter(databaseManager.getDistricts(id));
        int count_districts = districtAdapter.getDistricts().size();
        string_districts.clear();
        for(int j = 0; j<count_districts;j++){
            string_districts.add(districtAdapter.getDistricts().get(j).getDistrict_name());
        }

        ArrayAdapter<String> districtArrayAdapter = new ArrayAdapter<String>
                (mContext,android.R.layout.simple_spinner_item,string_districts);
        districtArrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        districtArrayAdapter.notifyDataSetChanged();
        spinnerDistricts.setAdapter(districtArrayAdapter);

        spinnerDistricts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private ArrayList<String> string_districts = new ArrayList<String>();


    public AddressPostFragment(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_addresspost, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        spinnerDistricts = (Spinner) rootView.findViewById(R.id.spinner_districts);
        spinnerProvinces = (Spinner) rootView.findViewById(R.id.spinner_provinces);
        spinnerDistricts.setEnabled(false);

        MyApplication myApplication = (MyApplication) ((MainActivity)mContext).getApplication();
        DatabaseManager databaseManager = myApplication.getDatabaseManager();

        provinceAdapter = new ProvinceAdapter(databaseManager.getProvinces());
        int count_provinces = provinceAdapter.getProvinces().size();
        for(int i = 0;i<count_provinces;i++){
            string_provinces.add(provinceAdapter.getProvinces().get(i).getProvince_name());
        }

        final ArrayAdapter<String> provinceArrayAdapter = new ArrayAdapter<String>
                (mContext,android.R.layout.simple_spinner_item,string_provinces);
        provinceArrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        provinceArrayAdapter.notifyDataSetChanged();
        spinnerProvinces.setAdapter(provinceArrayAdapter);

        spinnerProvinces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setString_districts(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
