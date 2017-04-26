package com.vuongtc.uet.uber_shipper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuongtc.uet.uber_shipper.R;

public class ShopLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_shop;
    private TextView tv_register_shop;
    private ImageView iv_register_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_login);
        initViews();
    }

    private void initViews() {

        btn_login_shop = (Button)findViewById(R.id.btn_login_by_shop);
        iv_register_shop = (ImageView)findViewById(R.id.iv_register_shop);
        tv_register_shop = (TextView)findViewById(R.id.tv_register_shop);

        btn_login_shop.setOnClickListener(this);
        iv_register_shop.setOnClickListener(this);
        tv_register_shop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_login_by_shop:
                break;
            case R.id.iv_register_shop | R.id.tv_register_shop:
                break;
            default:
                break;
        }
    }
}
