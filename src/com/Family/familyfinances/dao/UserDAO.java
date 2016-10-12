package com.Family.familyfinances.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.Family.familyfinances.model.*;

public class UserDAO {
	// 创建DBOpenHelper对象
	private dbOpenHelper helper;
	// 创建SQLiteDatabase对象
	private SQLiteDatabase db;
	// 定义构造函数
	public UserDAO(Context context)
	{
		// 初始化DBOpenHelper对象
		helper = new dbOpenHelper(context);
	}

	/**
	 * 添加用户信息
	 * 
	 * @param tb_user
	 */
	public void add(Tb_user tb_user) {
		// 初始化SQLiteDatabase对象
		db = helper.getWritableDatabase();
		// 执行添加用户操作
		db.execSQL("insert into tb_user (password,name) values (?,?)",
				new Object[] {tb_user.getName(), tb_user.getPassword() });
	}

	/**
	 * 设置密码信息
	 * 
	 * @param tb_pwd
	 */
	public void update(Tb_user tb_user) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 执行修改密码操作
		db.execSQL("update tb_user set password = ? where name = ?",
				new Object[] { tb_user.getName(), tb_user.getPassword()});
	}

	/**
	 * 查找密码信息
	 * 
	 * @return
	 */
	public Tb_user find() {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 查找密码并存储到Cursor类中
		Cursor cursor = db.rawQuery("select password from tb_pwd", null);
		if (cursor.moveToNext())// 遍历查找到的密码信息
		{
			// 将密码存储到Tb_user类中
			return new Tb_user(cursor.getString(cursor.getColumnIndex("password")),
					cursor.getString(cursor.getColumnIndex("name")));
		}
		// 如果没有信息，则返回null
		return null;
	}

	public long getCount() {
		// 初始化SQLiteDatabase对象
		db = helper.getWritableDatabase();
		// 获取密码信息的记录数
		Cursor cursor = db.rawQuery("select count(name) from tb_pwd", null);
		// 判断Cursor中是否有数据
		if (cursor.moveToNext())
		{
			// 返回总记录数
			return cursor.getLong(0);
		}
		// 如果没有数据，则返回0
		return 0;
	}
/**
 * 登录验证
 * @param tb_User 
 */
public boolean Login(Tb_user tb_User)
{
	db=helper.getReadableDatabase();
	String sql="select * from tb_user where name=? and password=?";
	Cursor cursor=db.rawQuery(sql, new String[]{
			tb_User.getName(),
			tb_User.getPassword()});
	 if(cursor.moveToNext()==true){
            cursor.close();
            return true;
        }
        return false;
}

}

