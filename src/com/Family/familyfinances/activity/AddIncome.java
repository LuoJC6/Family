package com.Family.familyfinances.activity;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;
	public class AddIncome extends Activity{
		protected static final int DATE_DIALOG_ID = 0;// 创建日期对话框常量
		EditText txtInTime;
		private int mYear;// 年
		private int mMonth;// 月
		private int mDay;// 日
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_addincome);
		//获取控件
		final EditText txtInMoney;
		final EditText txtInHandler, txtInMark;
		final Spinner spInType;
		final Button btnSave,btnCancel;
		 txtInMoney = (EditText)findViewById(R.id.txtInMoney);
		 txtInTime = (EditText)findViewById(R.id.txtInTime);
		 txtInHandler = (EditText)findViewById(R.id.txtInHandler);
		 txtInMark = (EditText)findViewById(R.id.txtInMark);
		 spInType =(Spinner)findViewById(R.id.spInType);
		btnSave = (Button)findViewById(R.id.btnSave);
		btnCancel = (Button)findViewById(R.id.btnCancel);
		//保存按钮单击事件
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				InfamilyDAO infamilyDAO = new InfamilyDAO(AddIncome.this);// 创建PwdDAO对象
				Tb_Infamily tb_infamily=new Tb_Infamily(infamilyDAO.getMaxId() + 1,Double.valueOf(txtInMoney.getText().toString()),
							txtInTime.getText().toString(),
							txtInHandler.getText().toString(),
							txtInMark.getText().toString(),
							spInType.getSelectedItem().toString());// 根据输入的密码创建Tb_pwd对象
				
				infamilyDAO.add(tb_infamily);// 添加收入信息
				//提示信息
				Toast.makeText(AddIncome.this, "新增成功", Toast.LENGTH_SHORT)
				.show();
				finish();
			}
		});
		//取消按钮单击事件
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		txtInTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 弹出日期选择框
				showDialog(DATE_DIALOG_ID);// 显示日期选择对话框
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
		txtInTime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}
