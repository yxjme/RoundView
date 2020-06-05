package com.yxjme.flycoroundview.activity;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yxjme.flycoroundview.sqllite.DaoMaster;
import com.yxjme.flycoroundview.sqllite.DaoSession;

public class MyApp extends Application {


    static Context context ;


    public static Context getContext() {
        return context;
    }



    //获取Helper对象
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initDatabase();
    }


    /**
     * 初始化數據庫
     */
    private void initDatabase() {
        mHelper = new  DaoMaster.DevOpenHelper(this, "app.db");
        SQLiteDatabase db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }


    /**
     * dao
     *
     * @return
     */
    public static DaoSession getDaoSession() {
        return mDaoSession;
    }



    /**
     * 可寫
     * @return
     */
    public SQLiteDatabase getWDb() {
        return mHelper.getWritableDatabase();
    }

    /**
     * 可讀
     * @return
     */
    public SQLiteDatabase getRDb() {
        return mHelper.getReadableDatabase();
    }
}
