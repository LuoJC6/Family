package com.Family.familyfinances.activity;

import com.Family.familyfinances.dao.UserDAO;
import com.Family.familyfinances.model.Tb_user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PwdFind extends Activity {
	EditText txtname,txtpwd;
	Button btnOK;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mimasz);

		txtname = (EditText) findViewById(R.id.txtName);
		txtpwd = (EditText) findViewById(R.id.txtPwd);
		btnOK = (Button) findViewById(R.id.btnok);

		btnOK.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserDAO pwdDAO = new UserDAO(PwdFind.this);
				Tb_user tb_pwd = new Tb_user(txtpwd.getText().toString(),txtname.getText().toString());
				if (pwdDAO.getCount() == 0) {
					pwdDAO.add(tb_pwd);
				} else {
					pwdDAO.update(tb_pwd);
				}
				Toast.makeText(PwdFind.this, "密码找回成功", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
