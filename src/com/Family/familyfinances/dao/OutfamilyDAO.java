package com.Family.familyfinances.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.Family.familyfinances.model.Tb_Outfamily;

public class OutfamilyDAO {
	private dbOpenHelper helper;
	private SQLiteDatabase db;

	public OutfamilyDAO(Context context)
	{
		helper = new dbOpenHelper(context);
	}

	/**
	 * 增加支出记录
	 * 
	 * @param tb_Outfamily
	 */
	public void add(Tb_Outfamily tb_Outfamily) {
		db = helper.getWritableDatabase();
		db.execSQL(
				"insert into tb_Outfamily (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
				new Object[] { tb_Outfamily.getid(), tb_Outfamily.getMoney(),
						tb_Outfamily.getTime(), tb_Outfamily.getType(),
						tb_Outfamily.getAddress(), tb_Outfamily.getMark() });
	}

	/**
	 * 支出更新
	 * 
	 * @param tb_Outfamily
	 */
	public void update(Tb_Outfamily tb_Outfamily) {
		db = helper.getWritableDatabase();
		db.execSQL(
				"update tb_Outfamily set money = ?,time = ?,type = ?,address = ?,mark = ? where _id = ?",
				new Object[] { tb_Outfamily.getMoney(),
						tb_Outfamily.getTime(), tb_Outfamily.getType(),
						tb_Outfamily.getAddress(), tb_Outfamily.getMark(),
						tb_Outfamily.getid() });
	}

	/**
	 * 查找支出记录
	 * 
	 * @param id
	 * @return
	 */
	public Tb_Outfamily find(int id) {
		db = helper.getWritableDatabase();
		Cursor cursor = db
				.rawQuery(
						"select _id,money,time,type,address,mark from tb_Outfamily where _id = ?",
						new String[] { String.valueOf(id) });
		if (cursor.moveToNext())
		{
			return new Tb_Outfamily(
					cursor.getInt(cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("address")),
					cursor.getString(cursor.getColumnIndex("mark")));
		}
		return null;
	}

	/**
	 * 删除支出
	 * 
	 * @param ids
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
			db.execSQL("delete from tb_Outfamily where _id in (" + sb + ")",
					(Object[]) ids);
		}
	}
	public List<Tb_Outfamily> getScrollData(int start, int count) {
		List<Tb_Outfamily> tb_outaccount = new ArrayList<Tb_Outfamily>();
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from tb_Outfamily limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())
		{
			tb_outaccount.add(new Tb_Outfamily(cursor.getInt(cursor
					.getColumnIndex("_id")), cursor.getDouble(cursor
					.getColumnIndex("money")), cursor.getString(cursor
					.getColumnIndex("time")), cursor.getString(cursor
					.getColumnIndex("type")), cursor.getString(cursor
					.getColumnIndex("address")), cursor.getString(cursor
					.getColumnIndex("mark"))));
		}
		return tb_outaccount;
	}
	public long getCount() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select count(_id) from tb_Outfamily",
				null);
		if (cursor.moveToNext())
		{
			return cursor.getLong(0);
		}
		return 0;
	}
	public int getMaxId() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select max(_id) from tb_Outfamily", null);
		while (cursor.moveToLast()) {
			return cursor.getInt(0);
		}
		return 0;
	}
}
