package com.Family.familyfinances.model;

public class Tb_user {
	// 定义字符串，表示用户密码
	private String password;
	// 定义字符串，表示用户名
	private String name;
	// 默认构造函数
	public Tb_user()
	{
		super();
	}
	// 定义有参构造函数
	public Tb_user(String name, String password)
	{
		super();
		//为用户名赋值
		this.name=name;
		// 为密码赋值
		this.password = password;
	}
	// 定义用户名的可读属性
		public String getName()
		{
			return name;
		}
	// 定义密码的可读属性
	public String getPassword()
	{
		return password;
	}
	// 定义用户名的可写属性
		public void setName(String name)
		{
			this.name = name;
		}
	// 定义密码的可写属性
	public void setPassword(String password)
	{
		this.password = password;
	}
}
