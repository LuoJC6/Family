package com.Family.familyfinances.model;

public class Tb_flag {
	private int _id;// 存储便签编号
	private String flag;// 存储便签信息

	public Tb_flag()// 默认构造函数
	{
		super();
	}
	// 定义有参构造函数，用来初始化便签信息实体类中的各个字段
	public Tb_flag(int id, String flag) {
		super();
		//为便签号赋值
		this._id = id; 
		// 为便签信息赋值
		this.flag = flag;
	}
	// 设置便签编号的可读属性
	public int getid()
	{
		return _id;
	}
	// 设置便签编号的可写属性
	public void setid(int id)
	{
		this._id = id;
	}
	// 设置便签信息的可读属性
	public String getFlag()
	{
		return flag;
	}
	// 设置便签信息的可写属性
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
}

