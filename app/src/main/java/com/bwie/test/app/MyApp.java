package com.bwie.test.app;

import android.app.Application;

import com.bwie.test.sqldao.DaoMaster;
import com.bwie.test.sqldao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application{
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "baway1.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
