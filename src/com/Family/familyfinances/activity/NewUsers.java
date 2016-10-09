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
		txtname = (EditText) findViewById(R.id.txtName);//获取用户名文本框
		txtpwd = (EditText) findViewById(R.id.txtPwd);// 获取密码文本框
		btnnew = (Button) findViewById(R.id.btnNewLogin);// 获取设置按钮
		btnnew.setOnClickListener(new OnClickListener() {// 为设置按钮添加监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(NewUsers.this,Login.class);
				UserDAO userDAO = new UserDAO(NewUsers.this);// 创建PwdDAO对象
				Tb_user tb_pwd = new Tb_user(txtpwd.getText().toString(),txtname.getText().toString());// 根据输入的密码创建Tb_pwd对象
				
					userDAO.add(tb_pwd);// 添加用户密码
				 
				// 弹出信息提示
				Toast.makeText(NewUsers.this, "新增用户成功！", Toast.LENGTH_SHORT)
						.show();
				startActivity(intent);
			}
		});
	}
}