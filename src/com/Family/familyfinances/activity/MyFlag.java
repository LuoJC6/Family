package com.Family.familyfinances.activity;

import java.util.List;

import com.Family.familyfinances.dao.FlagDAO;
import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;
import com.Family.familyfinances.model.Tb_flag;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyFlag extends Activity {
	ListView flaginfo;
	String strType = "";
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myflag);
        
        flaginfo = (ListView)findViewById(R.id.flaginfo);
        ShowInfo(R.id.btnWoDBQ);
    }
    private void ShowInfo(int intType){
    	String[] strInfo = null;
    	ArrayAdapter<String> arrayAdapter = null;
    	strType = "btnWoDBQ";
    	FlagDAO flag = new FlagDAO(MyFlag.this);
    	List<Tb_flag> listinfos = flag.getScrollData(0,(int)flag.getCount());
    	String[] strInfos = new String[listinfos.size()];
    	int m=0;
    	for(Tb_flag Tb_flag:listinfos){ 
    		strInfos[m] = Tb_flag.getid() + "   " +"|"+"       "+Tb_flag.getFlag();
    		m++;
    	}
    	arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
    	flaginfo.setAdapter(arrayAdapter);
    }
}
