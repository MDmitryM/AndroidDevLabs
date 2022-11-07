package com.example.lab21

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.widget.Toast

class DataBaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{

    override fun onCreate(db: SQLiteDatabase)
    {
        db.execSQL(DBContract.DBCreateStr())
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DBContract.DBDeleteStr())
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object
    {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }

    fun restoreData(db: SQLiteDatabase, dataList: ArrayList<HashMap<String, String>>)
    {
        dataList.clear()
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(BaseColumns._ID, DBContract.UserEntry.COLUMN_NAME_EMAIL,
            DBContract.UserEntry.COLUMN_NAME_PASSWORD)

        // Filter results WHERE "title" = 'My Title'
        //val selection = "${DBContract.UserEntry.COLUMN_NAME_EMAIL} = ?"
        //val selectionArgs = arrayOf("My Title")

        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${BaseColumns._ID} ASC"

        val cursor = db.query(
            DBContract.UserEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            sortOrder               // The sort order
        )

        val EMAIL_KEY = "e"
        val PASSWORD_KEY = "p"

        with(cursor) {
            while (moveToNext()) {
                val map: HashMap<String, String> =HashMap()
                val itemEmail = getString(getColumnIndexOrThrow(
                    DBContract.UserEntry.COLUMN_NAME_EMAIL))
                val itemPassword = getString(getColumnIndexOrThrow(
                    DBContract.UserEntry.COLUMN_NAME_PASSWORD))
                map.put(EMAIL_KEY, itemEmail)
                map.put(PASSWORD_KEY, itemPassword)
                dataList.add(map)
            }
        }
        cursor.close()
    }
}