package com.Family.familyfinances.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;

public class AddIncome extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_addincome);
		//获取控件
		final EditText txtInMoney;
		final EditText txtInTime;
		final EditText txtInHandler, txtInMark;
		final EditText spInType;
		final Button btnSave,btnCancel;
		 txtInMoney = (EditText)findViewById(R.id.txtInMoney);
		 txtInTime = (EditText)findViewById(R.id.txtInTime);
		 txtInHandler = (EditText)findViewById(R.id.txtInHandler);
		 txtInMark = (EditText)findViewById(R.id.txtInMark);
		 spInType =(EditText)findViewById(R.id.spInType);
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
							spInType.getText().toString());// 根据输入的密码创建Tb_pwd对象
				
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
	}


}
