package com.Family.familyfinances.model;

//收入信息实体类
public class Tb_Infamily
{
	//收入编号
	private int _id;
	//收入金额
	private double money;
	//收入时间
	private String time;
	//收入类别
	private String type;
	//收入付款方
	private String handler;
	//收入备注
	private String mark;
	//默认构造函数
	public Tb_Infamily()
	{
		super();
	}
	public Tb_Infamily(int id, double money, String time, String type,
			String handler, String mark) {
		super();
		this._id = id;
		this.money = money;
		this.time = time;
		this.type = type;
		this.handler = handler;
		this.mark = mark;
	}
	//收入编号的可读属性
	public int getid()
	{
		return _id;
	}
	//收入编号的可写属性
	public void setid(int id)
	{
		this._id = id;
	}
	//收入金额的可读属性
	public double getMoney()
	{
		return money;
	}
	//收入金额的可写属性
	public void setMoney(double money)
	{
		this.money = money;
	}
	//收入时间的可读属性
	public String getTime()
	{
		return time;
	}
	//收入时间的可写属性
	public void setTime(String time)
	{
		this.time = time;
	}
	//收入类别的可读属性
	public String getType()
	{
		return type;
	}
	//收入类别的可写属性
	public void setType(String type)
	{
		this.type = type;
	}
	//收入付款方的可读属性
	public String getHandler()
	{
		return handler;
	}
	//收入付款方的可写属性
	public void setHandler(String handler)
	{
		this.handler = handler;
	}
	//收入备注的可读属性
	public String getMark()
	{
		return mark;
	}
	//收入备注的可写属性
	public void setMark(String mark)
	{
		this.mark = mark;
	}
}
