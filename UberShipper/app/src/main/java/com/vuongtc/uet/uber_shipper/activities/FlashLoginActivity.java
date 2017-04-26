package com.vuongtc.uet.uber_shipper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vuongtc.uet.uber_shipper.R;

public class FlashLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_customer;
    private Button btn_login_shipper;
    private Button btn_login_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_login);
        initViews();
    }

    private void initViews() {
        btn_login_customer = (Button)findViewById(R.id.btn_login_customer);
        btn_login_shipper = (Button)findViewById(R.id.btn_login_shipper);
        btn_login_shop = (Button)findViewById(R.id.btn_login_by_shop);

        btn_login_customer.setOnClickListener(this);
        btn_login_shop.setOnClickListener(this);
        btn_login_shipper.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_login_customer:
                break;
            case R.id.btn_login_by_shop:
                startShopLoginActivity();
                break;
            case R.id.btn_login_shipper:
                startShipperLoginActivity();
                break;
        }

    }

    private void startShopLoginActivity(){
        Intent shopLoginIntent = new Intent(this,ShopLoginActivity.class);
        startActivity(shopLoginIntent);
    }

    private void startShipperLoginActivity(){
        Intent shipperLoginIntent = new Intent(this,ShipperLoginActivity.class);
        startActivity(shipperLoginIntent);
    }
}
