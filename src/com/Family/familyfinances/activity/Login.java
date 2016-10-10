package com.Family.familyfinances.activity;

import com.Family.familyfinances.dao.UserDAO;
import com.Family.familyfinances.model.Tb_user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	EditText txtName,txtpwd;
	Button btnlogin, btnupdate,btnzhuc,btnclose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtpwd = (EditText)findViewById(R.id.txtPwd);
		txtName = (EditText)findViewById(R.id.txtLogin);
		btnlogin = (Button)findViewById(R.id.btnLogin);
		btnupdate = (Button)findViewById(R.id.btnUpdate);
		btnzhuc = (Button)findViewById(R.id.btnAdd);

		btnlogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// 获取控件
				String UserName=txtName.getText().toString().trim();
				String Password=txtpwd.getText().toString().trim();
				UserDAO objUserDAO=new UserDAO(Login.this);
				Tb_user tb_User=new Tb_user();
				tb_User.setName(UserName);
				tb_User.setPassword(Password);
				boolean flag=objUserDAO.Login(tb_User);
				if(!"".equals(UserName)&&!"".equals(Password)){
					//判断用户名和密码是否跟数据库中一致
					if(flag){
						Toast.makeText(Login.this, "登录成功",Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(Login.this,MainActivity.class);
						startActivity(intent);
					}
					else{
						Toast.makeText(Login.this, "登录失败",Toast.LENGTH_SHORT).show();
					}
				}
				else{
					Toast.makeText(Login.this, "用户和密码不能为空",Toast.LENGTH_LONG).show();
				}
			}
		});
		btnzhuc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 跳转到注册页面
				Intent intent = new Intent();
				intent.setAction("new");
				startActivity(intent);
			}
		});
	}
}
