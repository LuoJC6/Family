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
		btnlogin = (Button)findViewById(R.id.btnLogin);
		btnupdate = (Button)findViewById(R.id.btnUpdate);
		btnzhuc = (Button)findViewById(R.id.btnAdd);

		btnlogin.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// 创建Intent对象
				UserDAO pwdDAO = new UserDAO(Login.this);// 创建PwdDAO对象
				// 判断是否有密码及是否输入了密码
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtpwd.getText().toString().isEmpty()) {
					Toast.makeText(Login.this, "登录成功！！！",
							Toast.LENGTH_SHORT).show();
					startActivity(intent);// 启动主Activity
				} else {
					// 判断输入的密码是否与数据库中的密码一致
					if (pwdDAO.find().getPassword()
							.equals(txtpwd.getText().toString())) {
						startActivity(intent);// 启动主Activity
					} else {
						// 弹出信息提示
						Toast.makeText(Login.this, "请输入正确的登录密码！",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtpwd.setText("");// 清空密码文本框
			}
		});
		btnzhuc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 跳转到设置登录密码页面
				Intent intent = new Intent();
				intent.setAction("new");
				startActivity(intent);
			}
		});
       btnupdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 跳转到找回密码页面
				Intent intent = new Intent();
				intent.setAction("zhmm");
				startActivity(intent);
			}
       });
	}
}
