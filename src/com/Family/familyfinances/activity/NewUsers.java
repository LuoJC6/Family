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
public class NewUsers extends Activity {
	EditText txtpwd,txtname;// 创建EditText对象
	Button btnnew;// 创建两个Button对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zcym_activity);
		txtpwd = (EditText) findViewById(R.id.txtPwd);// 获取密码文本框
		btnnew = (Button) findViewById(R.id.btnNewLogin);// 获取设置按钮
		btnnew.setOnClickListener(new OnClickListener() {// 为设置按钮添加监听事件
		UserDAO pwdDAO = new UserDAO(NewUsers.this);// 创建PwdDAO对象
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(pwdDAO.getCount() == 0|| pwdDAO.find().getPassword()
						.isEmpty())
				{
					Intent intent = new Intent(NewUsers.this,Login.class);
					UserDAO userDAO = new UserDAO(NewUsers.this);// 创建PwdDAO对象
					Tb_user tb_pwd = new Tb_user(txtpwd.getText().toString());// 根据输入的密码创建Tb_pwd对象
					userDAO.add(tb_pwd);// 添加用户密码
					// 弹出信息提示
					Toast.makeText(NewUsers.this, "登录密码设置成功！！", Toast.LENGTH_SHORT)
							.show();
					startActivity(intent);
					finish();
				}
				
				else{
				Toast.makeText(NewUsers.this, "已存在密码，请不要重复设置", Toast.LENGTH_SHORT)
				.show();
				}
			}
		});
	}
}
