package com.speakreminder.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_LIST = "list";
	public static final String TABLE_ITEM = "item";

	public static final String COLUMN_LIST_ID = "list_id";
	public static final String COLUMN_ITEM_ID = "item_id";
	public static final String COLUMN_LIST_NAME = "name";
	public static final String COLUMN_ITEM_NAME = "name";

	private static final String DATABASE_NAME = "speak_reminder.db";
	private static final int DATABASE_VERSION = 1;

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Creating database
		db.execSQL("create table " + TABLE_LIST + "("  
				+ COLUMN_LIST_ID + " integer primary key autoincrement, " 
				+ COLUMN_LIST_NAME + " text not null);");
		
		// Creating database
		db.execSQL("create table " + TABLE_ITEM + "("  
				+ COLUMN_ITEM_ID + " integer primary key autoincrement, " 
				+ COLUMN_ITEM_NAME + " text not null);"
				+ "FOREIGN KEY("+ COLUMN_LIST_ID +") REFERENCES "+ TABLE_LIST +"("+COLUMN_LIST_ID+") ON DELETE CASCADE ON UPDATE CASCADE" +
				");"); 
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// use when update the db
	}
	
}
