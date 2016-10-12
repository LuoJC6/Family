package com.Family.familyfinances.activity;

import java.util.List;

import com.Family.familyfinances.dao.InfamilyDAO;
import com.Family.familyfinances.model.Tb_Infamily;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class income extends Activity {
	
	public static final String FLAG = "id";
	ListView lvinfo;
	String strType = "";
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);
        
        lvinfo = (ListView)findViewById(R.id.lvinaccountinfo);
        ShowInfo(R.id.btnWoDSR);
    }
    private void ShowInfo(int intType){
    	String[] strInfo = null;
    	ArrayAdapter<String> arrayAdapter = null;
    	strType = "btnWoDSR";
    	InfamilyDAO inaccountinfo = new InfamilyDAO(income.this);
    	List<Tb_Infamily> listinfos = inaccountinfo.getScrollData(0,(int)inaccountinfo.getCount());
    	String[] strInfos = new String[listinfos.size()];
    	int m=0;
    	for(Tb_Infamily Tb_Infamily:listinfos){
    		strInfos[m] = Tb_Infamily.getid()+ " " + "|"+ "        " +Tb_Infamily.getType()+"        "+String.valueOf(Tb_Infamily.getMoney())+"元"+ "         " +Tb_Infamily.getTime();
    		m++;
    	}
    	arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
    	lvinfo.setAdapter(arrayAdapter);
    }
}
