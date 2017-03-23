package com.vuongtc.uet.uber_shipper.databases;

import android.app.Application;

import com.vuongtc.uet.uber_shipper.users.AccountInfo;

/**
 * Created by vuongtc on 3/22/2017.
 */
public class MyApplication extends Application {
    private AccountInfo accountInfo;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
