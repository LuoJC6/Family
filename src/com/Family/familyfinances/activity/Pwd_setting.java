package com.Family.familyfinances.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Family.familyfinances.dao.UserDAO;
import com.Family.familyfinances.model.Tb_user;

public class Pwd_setting extends Activity {
	EditText txtpwd;// 创建EditText对象
	Button btnsetting, btnqux;// 创建两个Button对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mimasz);// 设置布局文件

		txtpwd = (EditText) findViewById(R.id.txtPwd);// 获取密码文本框
		btnsetting = (Button) findViewById(R.id.btnszpwd);// 获取设置按钮
		btnqux = (Button) findViewById(R.id.btnquxiao);// 获取取消按钮

		btnsetting.setOnClickListener(new OnClickListener() {// 为设置按钮添加监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserDAO pwdDAO = new UserDAO(Pwd_setting.this);
				Tb_user tb_pwd = new Tb_user(txtpwd.getText().toString());
				if (pwdDAO.getCount() == 0) {// 判断数据库中是否已经设置了密码
					pwdDAO.add(tb_pwd);// 添加用户密码
				} else {
					pwdDAO.update(tb_pwd);// 修改用户密码
				}
				// 弹出信息提示
				Toast.makeText(Pwd_setting.this, "密码设置成功！", Toast.LENGTH_SHORT)
						.show();
			}
		});

		btnqux.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//退出当前页面,跳转到登录页面，验证密码
				Intent intent = new Intent(Pwd_setting.this,Login.class);
				startActivity(intent);
			}
		});
	}
}

