package com.Family.familyfinances.activity;

import com.Family.familyfinances.dao.UserDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	EditText txtlogin,txtpwd;
	Button btnlogin, btnupdate,btnzhuc,btnclose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtpwd = (EditText)findViewById(R.id.txtPwd);
		txtlogin = (EditText)findViewById(R.id.txtLogin);
		btnlogin = (Button)findViewById(R.id.btnLogin);
		btnupdate = (Button)findViewById(R.id.btnUpdate);
		btnzhuc = (Button)findViewById(R.id.btnAdd);

		btnlogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				UserDAO userDAO = new UserDAO(Login.this);
//				//判断是否有该用户及是否输入了密码
//			
//					//判断输入密码是否与数据库中保存的一致
//					if (userDAO.find().getPassword()
//							.equals(txtpwd.getText().toString())|| 
//						userDAO.find().getName()
//							.equals(txtlogin.getText().toString())	
//							) {
//						Intent intent = new Intent(Login.this,MainActivity.class);
//						startActivity(intent);
//					} else {
//						//弹出信息提示							
//						Toast.makeText(Login.this, "请输入正确的用户名密码！",
//								Toast.LENGTH_SHORT).show();
//					}
				Intent intent = new Intent();
				intent.setAction("Main");
				startActivity(intent);
			}
		});
		btnzhuc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 跳转到注册页面
//				Intent intent = new Intent();
//				intent.setAction("t");
//				startActivity(intent);
				Intent intent = new Intent();
				intent.setAction("new");
				startActivity(intent);
			}
		});
	}
}
