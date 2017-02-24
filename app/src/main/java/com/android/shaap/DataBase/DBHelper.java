package com.android.shaap.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

// Created By Hossein
public class DBHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.android.shaap/databases/";
    private static String DB_NAME = "dubsat.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 3);
        this.myContext = context;
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if (dbExist) {
        } else {
            this.getReadableDatabase();

            try {
                copyDataBase();
                Log.e("", "createDatabase database created");
            } catch (IOException e) {
                throw new Error("Error Copying DataBase");
            }
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = myContext.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutPut = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = myInput.read(buffer)) > 0) {
            myOutPut.write(buffer, 0, length);
        }
        myOutPut.close();
        myOutPut.flush();

        myInput.close();
        Log.i("db", "copy");
    }

    public void OpenDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Log.i("db", "open");
        myDataBase.close();
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            String myPath = DB_PATH + DB_NAME;
            this.myContext.deleteDatabase(myPath);
            try {
                this.copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}