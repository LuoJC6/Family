package com.Family.familyfinances.activity;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.dao.OutfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;
import com.Family.familyfinances.model.Tb_Outfamily;

public class ManageIncome extends Activity {
	protected static final int DATE_DIALOG_ID = 0;// 创建日期对话框常量
	TextView tvtitle, textView;// 创建两个TextView对象
	EditText txtMoney, txtTime, txtHA, txtMark;// 创建4个EditText对象
	Spinner spType;// 创建Spinner对象
	Button btnEdit, btnDel;// 创建两个Button对象
	String[] strInfos;// 定义字符串数组
	String strid, strType;// 定义两个字符串变量，分别用来记录信息编号和管理类型

	private int mYear;// 年
	private int mMonth;// 月
	private int mDay;// 日

	OutfamilyDAO out = new OutfamilyDAO(ManageIncome.this);// 创建OutaccountDAO对象
	InfamilyDAO in = new InfamilyDAO(ManageIncome.this);// 创建InaccountDAO对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manage_income);// 设置布局文件
		tvtitle = (TextView) findViewById(R.id.inouttitle);// 获取标题标签对象
		textView = (TextView) findViewById(R.id.tvInOut);// 获取地点/付款方标签对象
		txtMoney = (EditText) findViewById(R.id.txtInOutMoney);// 获取金额文本框
		txtTime = (EditText) findViewById(R.id.txtInOutTime);// 获取时间文本框
		spType = (Spinner) findViewById(R.id.spInOutType);// 获取类别下拉列表
		txtHA = (EditText) findViewById(R.id.txtInOut);// 获取地点/付款方文本框
		txtMark = (EditText) findViewById(R.id.txtInOutMark);// 获取备注文本框
		btnEdit = (Button) findViewById(R.id.btnInOutEdit);// 获取修改按钮
		btnDel = (Button) findViewById(R.id.btnInOutDelete);// 获取删除按钮

		Intent intent = getIntent();// 创建Intent对象
		Bundle bundle = intent.getExtras();// 获取传入的数据，并使用Bundle记录
		strInfos = bundle.getStringArray(Showinfo.FLAG);// 获取Bundle中记录的信息
		strid = strInfos[0];// 记录id
		strType = strInfos[1];// 记录类型
		if (strType.equals("btnoutinfo"))// 如果类型是btnoutinfo
		{
			tvtitle.setText("支出管理");// 设置标题为“支出管理”
			textView.setText("地  点：");// 设置“地点/付款方”标签文本为“地 点：”
			// 根据编号查找支出信息，并存储到Tb_outaccount对象中
			Tb_Outfamily tbout = out.find(Integer
					.parseInt(strid));
			txtMoney.setText(String.valueOf(tbout.getMoney()));// 显示金额
			txtTime.setText(tbout.getTime());// 显示时间
			spType.setPrompt(tbout.getType());// 显示类别
			txtHA.setText(tbout.getAddress());// 显示地点
			txtMark.setText(tbout.getMark());// 显示备注
		} else if (strType.equals("btnininfo"))// 如果类型是btnininfo
		{
			tvtitle.setText("收入管理");// 设置标题为“收入管理”
			textView.setText("付款方：");// 设置“地点/付款方”标签文本为“付款方：”
			// 根据编号查找收入信息，并存储到Tb_outaccount对象中
			Tb_Infamily tbin = in.find(Integer
					.parseInt(strid));
			txtMoney.setText(String.valueOf(tbin.getMoney()));// 显示金额
			txtTime.setText(tbin.getTime());// 显示时间
			spType.setPrompt(tbin.getType());// 显示类别
			txtHA.setText(tbin.getHandler());// 显示付款方
			txtMark.setText(tbin.getMark());// 显示备注
		}

		txtTime.setOnClickListener(new OnClickListener() {// 为时间文本框设置单击监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);// 显示日期选择对话框
			}
		});

		btnEdit.setOnClickListener(new OnClickListener() {// 为修改按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (strType.equals("btnoutinfo"))// 判断类型如果是btnoutinfo
				{
					Tb_Outfamily tbOut = new Tb_Outfamily();// 创建Tb_outaccount对象
					tbOut.setid(Integer.parseInt(strid));// 设置编号
					tbOut.setMoney(Double.parseDouble(txtMoney
							.getText().toString()));// 设置金额
					tbOut.setTime(txtTime.getText().toString());// 设置时间
					tbOut.setType(spType.getSelectedItem().toString());// 设置类别
					tbOut.setAddress(txtHA.getText().toString());// 设置地点
					tbOut.setMark(txtMark.getText().toString());// 设置备注
					out.update(tbOut);// 更新支出信息
				} else if (strType.equals("btnininfo"))// 判断类型如果是btnininfo
				{
					Tb_Infamily tbIn = new Tb_Infamily();// 创建Tb_inaccount对象
					tbIn.setid(Integer.parseInt(strid));// 设置编号
					tbIn.setMoney(Double.parseDouble(txtMoney.getText()
							.toString()));// 设置金额
					tbIn.setTime(txtTime.getText().toString());// 设置时间
					tbIn.setType(spType.getSelectedItem().toString());// 设置类别
					tbIn.setHandler(txtHA.getText().toString());// 设置付款方
					tbIn.setMark(txtMark.getText().toString());// 设置备注
					in.update(tbIn);// 更新收入信息
				}
				// 弹出信息提示
				Toast.makeText(ManageIncome.this, "数据修改成功！", Toast.LENGTH_SHORT)
						.show();
			}
		});

		btnDel.setOnClickListener(new OnClickListener() {// 为删除按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (strType.equals("btnoutinfo"))// 判断类型如果是btnoutinfo
				{
					out.detele(Integer.parseInt(strid));// 根据编号删除支出信息
				} else if (strType.equals("btnininfo"))// 判断类型如果是btnininfo
				{
					in.detele(Integer.parseInt(strid));// 根据编号删除收入信息
				}
				Toast.makeText(ManageIncome.this, "〖数据〗删除成功！", Toast.LENGTH_SHORT)
						.show();
			}
		});

		final Calendar c = Calendar.getInstance();// 获取当前系统日期
		mYear = c.get(Calendar.YEAR);// 获取年份
		mMonth = c.get(Calendar.MONTH);// 获取月份
		mDay = c.get(Calendar.DAY_OF_MONTH);// 获取天数
		updateDisplay();// 显示当前系统时间
	}

	@Override
	protected Dialog onCreateDialog(int id)// 重写onCreateDialog方法
	{
		switch (id) {
		case DATE_DIALOG_ID:// 弹出日期选择对话框
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;// 为年份赋值
			mMonth = monthOfYear;// 为月份赋值
			mDay = dayOfMonth;// 为天赋值
			updateDisplay();// 显示设置的日期
		}
	};

	private void updateDisplay() {
		// 显示设置的时间
		txtTime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}
