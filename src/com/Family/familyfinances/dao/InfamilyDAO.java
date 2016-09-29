package com.Family.familyfinances.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.Family.familyfinances.model.Tb_Infamily;

public class InfamilyDAO {
	private dbOpenHelper helper;
	private SQLiteDatabase db;

	public InfamilyDAO(Context context)
	{
		helper = new dbOpenHelper(context);
	}

	/**
	 * 增加收入
	 * 
	 * @param tb_Infamily
	 */
	public void add(Tb_Infamily tb_Infamily) {
		db = helper.getWritableDatabase();
		db.execSQL(
				"insert into tb_Infamily (_id,money,time,type,handler,mark) values (?,?,?,?,?,?)",
				new Object[] { tb_Infamily.getid(), tb_Infamily.getMoney(),
						tb_Infamily.getTime(), tb_Infamily.getType(),
						tb_Infamily.getHandler(), tb_Infamily.getMark() });
	}

	/**
	 * 更新收入
	 * 
	 * @param tb_Infamily
	 */
	public void update(Tb_Infamily tb_Infamily) {
		db = helper.getWritableDatabase();
		db.execSQL(
				"update tb_Infamily set money = ?,time = ?,type = ?,handler = ?,mark = ? where _id = ?",
				new Object[] { tb_Infamily.getMoney(), tb_Infamily.getTime(),
						tb_Infamily.getType(), tb_Infamily.getHandler(),
						tb_Infamily.getMark(), tb_Infamily.getid() });
	}

	/**
	 * 查找收入信息
	 * 
	 * @param tb_Infamily
	 */
	public Tb_Infamily find(int id) {
		db = helper.getWritableDatabase();
		Cursor cursor = db
				.rawQuery(
						"select _id,money,time,type,handler,mark from tb_Infamily where _id = ?",
						new String[] { String.valueOf(id) });
		if (cursor.moveToNext())
		{
			return new Tb_Infamily(
					cursor.getInt(cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("handler")),
					cursor.getString(cursor.getColumnIndex("mark")));
		}
		return null;
	}

	/**
	 * 删除收入信息
	 * 
	 * @param tb_Infamily
	 */
	public void detele(Integer... ids) {
		if (ids.length > 0)
		{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ids.length; i++)
			{
				sb.append('?').append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			db = helper.getWritableDatabase();
			db.execSQL("delete from tb_Infamily where _id in (" + sb + ")",
					(Object[]) ids);
		}
	}
	public List<Tb_Infamily> getScrollData(int start, int count) {
		List<Tb_Infamily> tb_Infamily = new ArrayList<Tb_Infamily>();
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from tb_Infamily limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())
		{
			tb_Infamily.add(new Tb_Infamily(cursor.getInt(cursor
					.getColumnIndex("_id")), cursor.getDouble(cursor
					.getColumnIndex("money")), cursor.getString(cursor
					.getColumnIndex("time")), cursor.getString(cursor
					.getColumnIndex("type")), cursor.getString(cursor
					.getColumnIndex("handler")), cursor.getString(cursor
					.getColumnIndex("mark"))));
		}
		return tb_Infamily;
	}
	public long getCount() {
		db = helper.getWritableDatabase();
		Cursor cursor = db
				.rawQuery("select count(_id) from tb_Infamily", null);
		if (cursor.moveToNext())
		{
			return cursor.getLong(0);
		}
		return 0;
	}
	public int getMaxId() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select max(_id) from tb_Infamily", null);
		while (cursor.moveToLast()) {
			return cursor.getInt(0);
		}
		return 0;
	}
}
