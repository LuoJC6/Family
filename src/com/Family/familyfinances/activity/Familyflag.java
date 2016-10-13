package com.Family.familyfinances.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Family.familyfinances.dao.FlagDAO;
import com.Family.familyfinances.model.Tb_flag;

public class Familyflag extends Activity {
	EditText txtFlag;
	Button btnflagSaveButton;
	Button btnflagCancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_flag);

		txtFlag = (EditText) findViewById(R.id.txtFlag);
		btnflagSaveButton = (Button) findViewById(R.id.btnflagSave);
		btnflagCancelButton = (Button) findViewById(R.id.btnflagCancel);
		btnflagSaveButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						String strFlag = txtFlag.getText().toString();
						if (!strFlag.isEmpty()) {
							FlagDAO flagDAO = new FlagDAO(Familyflag.this);
							Tb_flag tb_flag = new Tb_flag(
									flagDAO.getMaxId() + 1, strFlag);
							flagDAO.add(tb_flag);
							Toast.makeText(Familyflag.this, "便签数据添加成功！！",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(Familyflag.this, "请输入便签！！",
									Toast.LENGTH_SHORT).show();
						}
						finish();
					}
				});

		btnflagCancelButton.setOnClickListener(new OnClickListener() {
			//清空便签文本框
					@Override
					public void onClick(View arg0) {
						txtFlag.setText("");
					}
				});
	}
}

