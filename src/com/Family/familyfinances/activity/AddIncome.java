package com.Family.familyfinances.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;

public class AddIncome extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_addincome);
		final EditText txtmoney = (EditText)findViewById(R.id.txtInMoney);
		final EditText txttime = (EditText)findViewById(R.id.txtInTime);
		final EditText txttype = (EditText)findViewById(R.id.spInType);
		final EditText txtaddress = (EditText)findViewById(R.id.txtInHandler);
		final EditText txtmark = (EditText)findViewById(R.id.txtInMark);
		Button btnsave = (Button)findViewById(R.id.btnSave);
		Button btnExit = (Button)findViewById(R.id.btnCancel);
		btnsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InfamilyDAO infamilyDAO = new InfamilyDAO(AddIncome.this);
				Tb_Infamily tb_infamily = new Tb_Infamily(infamilyDAO.getMaxId() + 1,
						Double.valueOf(txtmoney.getText().toString()),
						txttime.getText().toString(),
						txttype.getText().toString(),
						txtaddress.getText().toString(),
						txtmark.getText().toString());
				
				infamilyDAO.add(tb_infamily);
				Toast.makeText(AddIncome.this, "新增成功", Toast.LENGTH_SHORT)
						.show();
				finish();
			}
		});
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
