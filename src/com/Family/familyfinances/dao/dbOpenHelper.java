package com.Family.familyfinances.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class dbOpenHelper extends SQLiteOpenHelper {

	public dbOpenHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}
	// 定义数据库版本号
	private static final int VERSION = 1;
	// 定义数据库名
	private static final String DBNAME = "family.db";
	// 定义构造函数
	public dbOpenHelper(Context context){
		// 重写基类的构造函数
		super(context, DBNAME, null, VERSION);
	}
	// 创建数据库
	@Override
	public void onCreate(SQLiteDatabase db){
		// 创建支出信息表
		db.execSQL("create table tb_Outfamily (_id integer primary key,money decimal,time varchar(10),"
				+ "type varchar(10),address varchar(100),mark varchar(200))");
		// 创建收入信息表
		db.execSQL("create table tb_Infamily (_id integer primary key,money decimal,time varchar(10),"
				+ "type varchar(10),handler varchar(100),mark varchar(200))");
		// 创建用户表
		db.execSQL("create table tb_user (name varchar(50),password varchar(20))");
		// 创建便签信息表
		db.execSQL("create table tb_flag (_id integer primary key,flag varchar(200))");
	}
	// 覆写基类的onUpgrade方法，以便数据库版本更新
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}
}
