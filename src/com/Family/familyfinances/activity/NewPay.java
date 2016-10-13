package com.Family.familyfinances.activity;

import com.Family.familyfinances.dao.OutfamilyDAO;
import com.Family.familyfinances.model.Tb_Outfamily;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPay extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.family_newpay);
		final EditText txtmoney = (EditText)findViewById(R.id.money);
		final EditText txttime = (EditText)findViewById(R.id.time);
		final EditText txttype = (EditText)findViewById(R.id.type);
		final EditText txtaddress = (EditText)findViewById(R.id.address);
		final EditText txtmark = (EditText)findViewById(R.id.mark);
		Button btnsave = (Button)findViewById(R.id.save);
		Button btnedit = (Button)findViewById(R.id.cancel);
		btnsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OutfamilyDAO outfamilyDAO = new OutfamilyDAO(NewPay.this);
				Tb_Outfamily tb_outfamily = new Tb_Outfamily(outfamilyDAO.getMaxId() + 1,
						Double.valueOf(txtmoney.getText().toString()),
						txttime.getText().toString(),
						txttype.getText().toString(),
						txtaddress.getText().toString(),
						txtmark.getText().toString());
				
				outfamilyDAO.add(tb_outfamily);
				 
				Toast.makeText(NewPay.this, "新增成功", Toast.LENGTH_SHORT)
						.show();
				finish();
			}
		});
		//取消按钮单击事件
		btnedit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}
}
