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
	Button btnlogin, btnupdate,btnzhuce,btnclose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtpwd = (EditText)findViewById(R.id.txtPwd);
		txtlogin = (EditText)findViewById(R.id.txtLogin);
		btnlogin = (Button)findViewById(R.id.btnLogin);
		btnupdate = (Button)findViewById(R.id.btnUpdate);
		btnzhuce = (Button)findViewById(R.id.btnAdd);

		btnlogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);
				UserDAO pwdDAO = new UserDAO(Login.this);
				//判断是否有密码及是否输入了密码
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);
				} else {
					//判断输入密码是否与数据库中保存的一直
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);
					} else {
						//弹出信息提示
						Toast.makeText(Login.this, "请输入正确的密码！",
								Toast.LENGTH_SHORT).show();
					}
				}
				//清空密码文本框
				txtlogin.setText("");
			}
		});
        //退出程序
//		btnclose.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				finish();
//			}
//		});
	}
}
