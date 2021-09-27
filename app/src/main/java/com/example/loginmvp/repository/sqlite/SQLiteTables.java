package com.example.loginmvp.repository.sqlite;

import android.provider.BaseColumns;
import android.security.keystore.UserNotAuthenticatedException;

import com.example.loginmvp.pojo.User;

public abstract class SQLiteTables {

    public static final String CREATE_TABLE_USER = "create table " + UserEntry.TABLE_NAME_USER +
            "("
            + UserEntry.COL_USER_ID + " integer primary key autoincrement,"
            + UserEntry.COL_USERNAME + " text,"
            + UserEntry.COL_PASSWORD + " text,"
            + "UNIQUE (" + UserEntry.COL_USER_ID + "))";

    public static final String DROP_TABLE_USER = "drop table if exists " + UserEntry.TABLE_NAME_USER;

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME_USER = "user";

        public static final String COL_USER_ID = "_id";
        public static final String COL_USERNAME = "username";
        public static final String COL_PASSWORD = "password";
    }
}
