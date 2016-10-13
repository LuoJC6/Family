package com.Family.familyfinances.activity;

import java.util.Calendar;

import com.Family.familyfinances.dao.OutfamilyDAO;
import com.Family.familyfinances.model.Tb_Outfamily;

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

public class NewPay extends Activity {
	protected static final int DATE_DIALOG_ID = 0;// 创建日期对话框常量
	EditText txttime;
	Spinner txttype;
	private int mYear;// 年
	private int mMonth;// 月
	private int mDay;// 日
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_newpay);
		final EditText txtmoney = (EditText)findViewById(R.id.money);
		txttime = (EditText)findViewById(R.id.time);
		final Spinner txttype = (Spinner)findViewById(R.id.paytype);
		final EditText txtaddress = (EditText)findViewById(R.id.address);
		final EditText txtmark = (EditText)findViewById(R.id.mark);
		Button btnsave = (Button)findViewById(R.id.save);
		Button btnedit = (Button)findViewById(R.id.cancel);
		btnsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OutfamilyDAO outfamilyDAO = new OutfamilyDAO(NewPay.this);
				Tb_Outfamily tb_outfamily = new Tb_Outfamily(outfamilyDAO.getMaxId() + 1,
						Double.valueOf(txtmoney.getText().toString()),
						txttime.getText().toString(),
						txttype.getSelectedItem().toString(),
						txtaddress.getText().toString(),
						txtmark.getText().toString());
				
				outfamilyDAO.add(tb_outfamily);
				 
				Toast.makeText(NewPay.this, "新增成功", Toast.LENGTH_SHORT)
						.show();
				finish();
			}
		});
		//取消按钮单击事件
		btnedit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
		//点击时间编辑框弹出日期选项
		txttime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
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
		txttime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}