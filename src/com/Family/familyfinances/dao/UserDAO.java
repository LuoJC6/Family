package com.Family.familyfinances.dao;

import com.Family.familyfinances.model.Tb_user;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
	private dbOpenHelper helper;// 创建DBOpenHelper对象
	private SQLiteDatabase db;// 创建SQLiteDatabase对象

	public UserDAO(Context context)// 定义构造函数
	{
		helper = new dbOpenHelper(context);// 初始化DBOpenHelper对象
	}

	/**
	 * 添加密码信息
	 * 
	 * @param tb_user
	 */
	public void add(Tb_user tb_pwd) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 执行添加密码操作
		db.execSQL("insert into tb_user (password) values (?)",
				new Object[] { tb_pwd.getPassword() });
	}

	/**
	 * 设置密码信息
	 * 
	 * @param tb_user
	 */
	public void update(Tb_user tb_pwd) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 执行修改密码操作
		db.execSQL("update tb_user set password = ?",
				new Object[] { tb_pwd.getPassword() });
	}

	/**
	 * 查找密码信息
	 * 
	 * @return
	 */
	public Tb_user find() {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 查找密码并存储到Cursor类中
		Cursor cursor = db.rawQuery("select password from tb_user", null);
		if (cursor.moveToNext())// 遍历查找到的密码信息
		{
			// 将密码存储到Tb_pwd类中
			return new Tb_user(cursor.getString(cursor
					.getColumnIndex("password")));
		}
		return null;// 如果没有信息，则返回null
	}

	public long getCount() {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		Cursor cursor = db.rawQuery("select count(password) from tb_user", null);// 获取密码信息的记录数
		if (cursor.moveToNext())// 判断Cursor中是否有数据
		{
			return cursor.getLong(0);// 返回总记录数
		}
		return 0;// 如果没有数据，则返回0
	}
}

