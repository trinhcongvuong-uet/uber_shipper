package com.vuongtc.uet.uber_shipper.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.vuongtc.uet.uber_shipper.R;
import com.vuongtc.uet.uber_shipper.adapters.ViewPagerAdapter;
import com.vuongtc.uet.uber_shipper.applications.MyApplication;
import com.vuongtc.uet.uber_shipper.databases.DatabaseManager;
import com.vuongtc.uet.uber_shipper.fragments.AddressPostFragment;
import com.vuongtc.uet.uber_shipper.fragments.AllPostFragment;
import com.vuongtc.uet.uber_shipper.fragments.GpsPostFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView user_photo;
    private TextView user_email;
    private TextView user_name;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView toolbar_title;

    private TextView tv_logout;
    private DrawerLayout drawerLayout;
    private DatabaseManager databaseManager;

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initViews();
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        user_photo = (CircleImageView) findViewById(R.id.iv_user_photo);
        user_email = (TextView)findViewById(R.id.tv_user_email);
        user_name = (TextView)findViewById(R.id.tv_user_name);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        toolbar_title.setText("UBER SHIPPER");

        tv_logout = (TextView)findViewById(R.id.tv_logout);
        tv_logout.setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable ic_home = getResources().getDrawable(R.drawable.ic_home);
        getSupportActionBar().setHomeAsUpIndicator(ic_home);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        MyApplication myApplication = (MyApplication)getApplication();
//        AccountInfo accountInfo = myApplication.getAccountInfo();

        databaseManager = new DatabaseManager(this);
        myApplication.setDatabaseManager(databaseManager);

//        if(accountInfo.getUrlPhoto().equals(null)) {
//            Picasso.with(this).load(accountInfo.getUrlPhoto()).into(user_photo);
//        }
//        user_name.setText(accountInfo.getDisplayName());
//        user_email.setText(accountInfo.getEmail());

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllPostFragment(), "ALL");
        adapter.addFragment(new GpsPostFragment(), "GPS");
        adapter.addFragment(new AddressPostFragment(this), "ADDRESS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            updateDrawerLayout();
        }
        return true;
    }

    private void updateDrawerLayout(){
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.tv_logout:
//                googleLogout();
            default:
                break;
        }
    }
}
