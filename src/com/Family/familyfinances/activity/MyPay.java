package com.Family.familyfinances.activity;

import java.util.List;

import com.Family.familyfinances.dao.FlagDAO;
import com.Family.familyfinances.dao.OutfamilyDAO;
import com.Family.familyfinances.model.Tb_Outfamily;
import com.Family.familyfinances.model.Tb_flag;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyPay extends Activity {
	ListView payinfo;
	String strType = "";
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypay);
        
        payinfo = (ListView)findViewById(R.id.payinfo);
        ShowInfo(R.id.btnWoDZC);
    }
    private void ShowInfo(int intType){
    	String[] strInfo = null;
    	ArrayAdapter<String> arrayAdapter = null;
    	strType = "btnWoDZC";
    	OutfamilyDAO flag = new OutfamilyDAO(MyPay.this);
    	List<Tb_Outfamily> listinfos = flag.getScrollData(0,(int)flag.getCount());
    	String[] strInfos = new String[listinfos.size()];
    	int m=0;
    	for(Tb_Outfamily Tb_Outfamily:listinfos){
    		strInfos[m] = Tb_Outfamily.getid()+ " " + "|"+ "        " +Tb_Outfamily.getType()+"        "+String.valueOf(Tb_Outfamily.getMoney())+"元"+ "         " +Tb_Outfamily.getTime();
    		m++;
    	}
    	arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
    	payinfo.setAdapter(arrayAdapter);
    }
}
