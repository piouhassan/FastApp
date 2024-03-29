package com.fast_ad.fast_ad.plugins.places;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Hp on 3/18/2016.
 */
public class DBAdapter {
    Context c;

    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DATABASE
    public DBAdapter openDB()
    {
        try {
            db=helper.getWritableDatabase();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this;
    }

    //CLOSE DATABASE
    public void closeDB()
    {
        try {
          helper.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }


    public long add(String name)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME,name);

            return db.insert(Constants.TB_NAME,Constants.ROW_ID,cv);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public Cursor getAllPlaces()
    {
        String[] columns={Constants.ROW_ID,Constants.NAME};

        return db.query(Constants.TB_NAME,columns,null,null,null,null,null);

    }
}














