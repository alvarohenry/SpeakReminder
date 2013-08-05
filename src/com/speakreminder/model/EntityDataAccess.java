package com.speakreminder.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EntityDataAccess {

	// Database fields
	private SQLiteDatabase database;

	private SQLiteHelper dbHelper;

	private String[] allColumnsList = { SQLiteHelper.COLUMN_LIST_ID,
			SQLiteHelper.COLUMN_LIST_NAME };
	private String[] allColumnsItem = { SQLiteHelper.COLUMN_ITEM_ID,
			SQLiteHelper.COLUMN_ITEM_NAME };

	public EntityDataAccess(Context context) {
		dbHelper = new SQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public void deleteItem(Entity item) {
		database.delete(SQLiteHelper.TABLE_ITEM, SQLiteHelper.COLUMN_ITEM_ID
				+ " = " + item.getId(), null);
	}

	public void deleteList(Entity list) {
		database.delete(SQLiteHelper.TABLE_LIST, SQLiteHelper.COLUMN_LIST_ID
				+ " = " + list.getId(), null);
	}

	public List<Entity> getAllItems(Entity list) {
		List<Entity> items = new ArrayList<Entity>();

		Cursor cursor = database.query(SQLiteHelper.TABLE_ITEM, allColumnsItem,
				SQLiteHelper.COLUMN_LIST_ID + " = " + list.getId(), null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Entity item = cursorToComment(cursor);
			items.add(item);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return items;
	}

	public List<Entity> getAllList() {
		List<Entity> lists = new ArrayList<Entity>();

		Cursor cursor = database.query(SQLiteHelper.TABLE_LIST, allColumnsList,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Entity list = cursorToComment(cursor);
			lists.add(list);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return lists;
	}
	
	private Entity cursorToComment(Cursor cursor) {
		Entity entity = new Entity();
		entity.setId(cursor.getLong(0));
		entity.setName(cursor.getString(1));
		return entity;
	}
}
