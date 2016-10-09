package com.Family.familyfinances.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity {
	Button btnXinZ;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geryy);
        btnXinZ=(Button)this.findViewById(R.id.btnXinZZC);
        btnXinZ.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(FirstActivity.this,SecoundActivity.class);
				startActivity(intent);
			}
			});
        }
}
