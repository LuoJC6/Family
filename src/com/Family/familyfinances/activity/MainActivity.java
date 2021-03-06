package com.Family.familyfinances.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {
   
	private TabHost tabHost;
	private RadioGroup radiogroup;
	Button btn1,btn2,btn3,btnPwd,btnofwe;
	private RadioButton ShouY,GeRYY,GeRSZ;
	private Button btnXinZZC,btnXinZSR,btnXinZBQ,btnWoDZC,btnWoDSR,btnWoDBQ,btnShuJGL;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
//        final EditText txtlogin = (EditText)findViewById(R.id.txtLogin);
        
        radiogroup = (RadioGroup)findViewById(R.id.radiogroup);
        ShouY = (RadioButton)findViewById(R.id.ShouY);
        GeRYY = (RadioButton)findViewById(R.id.GeRYY);
        GeRSZ = (RadioButton)findViewById(R.id.GeRSZ);
        
        
        LayoutInflater infater = LayoutInflater.from(this);
        infater.inflate(R.layout.activity_first, tabHost.getTabContentView());
        infater.inflate(R.layout.activity_geryy, tabHost.getTabContentView());
        infater.inflate(R.layout.system_setting, tabHost.getTabContentView());
        
        tabHost.addTab(tabHost.newTabSpec("tab01").setIndicator("首页").setContent(R.id.first));
        tabHost.addTab(tabHost.newTabSpec("tab02").setIndicator("个人应用").setContent(R.id.geryy));
        tabHost.addTab(tabHost.newTabSpec("tab03").setIndicator("系统设置").setContent(R.id.setting));

        //设置监听事件
        checkListener checkradio = new checkListener();
        radiogroup.setOnCheckedChangeListener(checkradio);
        
        btnShuJGL = (Button)findViewById(R.id.btnShuJGL);
        btnShuJGL.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 				Intent intent = new Intent();
 				intent.setAction("shujgl");
 				startActivity(intent);
 		}
 		
 		
 	});
        btnXinZBQ = (Button)findViewById(R.id.btnXinZBQ);
        btnXinZBQ.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("xinzbb");
				startActivity(intent);
 		}
 	});
        btnXinZZC = (Button)findViewById(R.id.btnXinZZC);
        btnXinZZC.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("xinzzc");
				startActivity(intent);
 		}
 	});
        btnXinZSR = (Button)findViewById(R.id.btnXinZSR);
        btnXinZSR.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("xinzsr");
				startActivity(intent);
 		}
 	});
        btnWoDZC = (Button)findViewById(R.id.btnWoDZC);
        btnWoDZC.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("WoZC");
				startActivity(intent);
 		}
 	});
        btnWoDBQ = (Button)findViewById(R.id.btnWoDBQ);
        btnWoDBQ.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("wodbq");
				startActivity(intent);
 		}
 	});
        btnWoDSR = (Button)findViewById(R.id.btnWoDSR);
        btnWoDSR.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intent = new Intent();
				intent.setAction("wodsr");
				startActivity(intent);
 		}
 	});
        btn1=(Button)this.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("one");
				startActivity(intent);
			}
			});
        btn2=(Button)this.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("two");
				startActivity(intent);
			}
			});
        btn3=(Button)this.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("three");
				startActivity(intent);
			}
			});
        btnPwd=(Button)this.findViewById(R.id.btnPwdsetting);
        btnPwd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("Pwd");
				startActivity(intent);
			}
			});
        
        btnofwe=(Button)this.findViewById(R.id.btnOfwe);
        btnofwe.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("Ofwe");
				startActivity(intent);
			}
			});
        /**
         * 退出系统
         * */
        Button btnExit = (Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
 				Intent intent = new Intent(Intent.ACTION_MAIN);
 				intent.addCategory(Intent.CATEGORY_HOME);
 				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 				startActivity(intent);
 				System.exit(0);
 			
 		}
 	});
        /**
         * 图片轮播*/
        mViewPaper = (ViewPager) findViewById(R.id.vp);
		
		//显示的图片
		images = new ArrayList<ImageView>();
		for(int i = 0; i < imageIds.length; i++){
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(imageIds[i]);
			images.add(imageView);
		}


		
		//显示的小点
		dots = new ArrayList<View>();
		dots.add(findViewById(R.id.dot_0));
		dots.add(findViewById(R.id.dot_1));
		dots.add(findViewById(R.id.dot_2));
		dots.add(findViewById(R.id.dot_3));
		dots.add(findViewById(R.id.dot_4));
		
		title = (TextView) findViewById(R.id.title);
		title.setText(titles[0]);
		
		adapter = new ViewPagerAdapter();
		mViewPaper.setAdapter(adapter);
		
		mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
		
			@Override
			public void onPageSelected(int position) {
				title.setText(titles[position]);
				dots.get(position).setBackgroundResource(R.drawable.dot_focused);
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				
				oldPosition = position;
				currentItem = position;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

	/**
	 * 自定义Adapter
	 *
	 */
	private class ViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			view.addView(images.get(position));
			return images.get(position);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 利用线程池定时执行动画轮播
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(
				new ViewPageTask(), 
				2, 
				2, 
				TimeUnit.SECONDS);
	}
	
	
	private class ViewPageTask implements Runnable{

		@Override
		public void run() {
			currentItem = (currentItem + 1) % imageIds.length;
			mHandler.sendEmptyMessage(0);
		}
	}
	
	/**
	 * 接收子线程传递过来的数据
	 */
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			mViewPaper.setCurrentItem(currentItem);
		};
	};
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	//图片轮播
	private ViewPager mViewPaper;
	private List<ImageView> images;
	private List<View> dots;
	private int currentItem;
	private TextView title;
	private ViewPagerAdapter adapter;
	private ScheduledExecutorService scheduledExecutorService;
	//记录上一次点的位置
	private int oldPosition = 0;
	//存放图片的id
	private int[] imageIds = new int[]{
			R.drawable.a,
			R.drawable.b,
			R.drawable.c,
			R.drawable.d,
			R.drawable.e
	};
	//存放图片的标题
		private String[]  titles = new String[]{
	        	"这四大家庭理财陷阱，你必须了解",	
	        	"年轻妈妈家庭理财绝招",	
	        	"低收入家庭理财绝招",	
	        	"新婚购房后如何家庭理财",
	        	"家庭理财,投资 理财 ,项目投资"
	        };
	    public class checkListener implements OnCheckedChangeListener{
	        @Override
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	            // TODO Auto-generated method stub
	            //setCurrentTab 通过标签索引设置当前显示的内容
	            //setCurrentTabByTag 通过标签名设置当前显示的内容
	            switch(checkedId){
	            case R.id.ShouY:
	                tabHost.setCurrentTab(0);
	                //或
	                //tabhost.setCurrentTabByTag("tag1");
	                break;
	            case R.id.GeRYY:
	            	tabHost.setCurrentTab(1);
	                break;
	            case R.id.GeRSZ:
	            	tabHost.setCurrentTab(2);
	                break;
	            }

	            
	        }
	    }
}