package com.example.loginmvp.repository.sqlite.sqliteControllerEntities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.RelativeDateTimeFormatter;

import com.example.loginmvp.pojo.User;
import com.example.loginmvp.repository.sqlite.SQLiteHelper;
import com.example.loginmvp.repository.sqlite.SQLiteTables;
import com.example.loginmvp.repository.sqlite.gestordb.ISQLiteControllerUser;

public class SQLiteControllerUser implements ISQLiteControllerUser {

    private Context context;
    private SQLiteHelper sqLiteHelper;
    private User user;

    public SQLiteControllerUser(Context context) {
        this.context = context;
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    @Override
    public boolean registerUser(User user) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLiteTables.UserEntry.COL_USERNAME, user.getUsername());
        cv.put(SQLiteTables.UserEntry.COL_PASSWORD, user.getPassword());
        long regId = db.insert(SQLiteTables.UserEntry.TABLE_NAME_USER,
                null,
                cv);

        if (regId != -1)
            return true;
        return false;
    }
    @Override
    public boolean existsUser(User user) {
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        String[] columns = {
                SQLiteTables.UserEntry.COL_USER_ID,
                SQLiteTables.UserEntry.COL_USERNAME
        };
        String selectionArgs = SQLiteTables.UserEntry.COL_USERNAME + "=? and "
                + SQLiteTables.UserEntry.COL_PASSWORD + "=?";
        String[] args = {
                user.getUsername(),
                user.getPassword()
        };

        Cursor c = db.query(SQLiteTables.UserEntry.TABLE_NAME_USER,
                columns,
                selectionArgs,
                args,
                null,
                null,
                null
        );


        if (c.moveToFirst())
        {
            this.user = new User(
                    c.getString(1)
            );
            return true;
        }else
            return false;
    }

    @Override
    public User getUser() {

        return this.user;
    }
}
