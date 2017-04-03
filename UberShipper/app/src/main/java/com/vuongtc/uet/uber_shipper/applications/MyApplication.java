package com.vuongtc.uet.uber_shipper.applications;

import android.app.Application;

import com.vuongtc.uet.uber_shipper.databases.DatabaseManager;
import com.vuongtc.uet.uber_shipper.users.AccountInfo;

/**
 * Created by vuongtc on 3/22/2017.
 */
public class MyApplication extends Application {
    private AccountInfo accountInfo;
    private DatabaseManager databaseManager;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
