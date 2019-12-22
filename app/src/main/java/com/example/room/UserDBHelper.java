package com.example.room;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "userDB.db";
    private static final String DB_TABLE_NAME = "users";
    private static final String ID = "Id";
    private static final String UNIQUE_USERID = "username";
    private static final String PASSWORD = "password";
    private static final int VERSION = 1;

    private Context context;

    private static final String TABLE_CREATION = "CREATE TABLE "+DB_TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+UNIQUE_USERID+" VARCHAR(255) NOT NULL UNIQUE, "+PASSWORD+" TEXT NOT NULL); ";
    private static final String TABLE_DELETION = "DROP TABLE IF EXISTS "+ DB_TABLE_NAME;



    public UserDBHelper(Context context) {

        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            //Toast.makeText(context,"onCreate is called",Toast.LENGTH_LONG);
            sqLiteDatabase.execSQL(TABLE_CREATION);
        }catch (Exception e){
            //Toast.makeText(context,"exception raised "+e,Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            //Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_LONG);
            sqLiteDatabase.execSQL(TABLE_DELETION);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            //Toast.makeText(context,"exception raised "+e,Toast.LENGTH_LONG);
        }
    }

    public long insertData(UserData entry){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues userDetails = new ContentValues();

        userDetails.put(UNIQUE_USERID,entry.getName());
        userDetails.put(PASSWORD,entry.getKey());

        long id = sqLiteDatabase.insert(DB_TABLE_NAME,null,userDetails);
        return id;

    }

    public Boolean findKey(String username, String password){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DB_TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount()==0){
            result = false;
        }
        else{
            while(!cursor.isAfterLast()){//because moveToNext returns false if the cursor is already past last entry
                while(cursor.moveToNext()){
                    String user = cursor.getString(1);
                    String pass = cursor.getString(2);

                    if(user.equals(username) && pass.equals(password)){
                        result = true;
                        break;
                    }
                }
            }
            cursor.close();
        }
        return result;
    }
}
