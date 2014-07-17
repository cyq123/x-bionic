package com.imcore.xbionic.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.imcore.xbionic.R;
import com.imcore.xbionic.fragment.HomeListHeaderFragment;
import com.imcore.xbionic.product.ProductMainActivity;

public class LoginEnterAfterHomeActivity extends FragmentActivity implements OnClickListener {
	private DrawerLayout drawerLayout;
	private ListView listView;
	private ActionBarDrawerToggle drawerToggle;//给drawerlayout设监听
	private View headerView;
	
	//private SearchView searchView;
	private ImageView openDrawer;
	public Button img_activities,img2_introduction,img4_expertstory,img3_product;
	
	private final static String NAVI_ITEM_TEXT = "text";
	String[] naviItemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login_enter_after);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_home_list_header_title);
		
	//	initSearchView();//搜索
		initDrawerLayout();//抽屉
		initWedgit();//控件
		//Fragment frag = new HomeListHeaderFragment(); 
	}
	
	public void initWedgit(){
		
		img_activities = (Button) findViewById(R.id.img_activities_login_enter_after);
		img2_introduction = (Button) findViewById(R.id.img2_introduction_login_enter_after);
		img3_product= (Button) findViewById(R.id.img3_product_login_enter_after);
		img4_expertstory = (Button) findViewById(R.id.img4_expertstory_login_enter_after);
		openDrawer = (ImageView)findViewById(R.id.img1_home_list_header_title);
		openDrawer.setOnClickListener(this);
		img_activities.setOnClickListener(this);
		img2_introduction.setOnClickListener(this);
		img3_product.setOnClickListener(this);
		img4_expertstory.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.img1_home_list_header_title:
			drawerLayout.openDrawer(Gravity.LEFT);
			break;
		case R.id.img_activities_login_enter_after:
			Intent intent = new Intent(LoginEnterAfterHomeActivity.this,ActivitiesMainActivity.class);
			startActivity(intent);
			break;
		case R.id.img2_introduction_login_enter_after:
			Intent intent2 = new Intent(LoginEnterAfterHomeActivity.this,IntroductionHomeActivity.class);
			startActivity(intent2);
			break;
		case R.id.img3_product_login_enter_after:
			Intent intent3 = new Intent(LoginEnterAfterHomeActivity.this,ProductMainActivity.class);
			startActivity(intent3);
			break;
		case R.id.img4_expertstory_login_enter_after:
			Intent intent4 = new Intent(LoginEnterAfterHomeActivity.this,ExpertStoryHomeActivity.class);
			startActivity(intent4);
			break;
		}
		
	}
	
//	@SuppressLint("NewApi")
//	public void initSearchView(){
//		searchView = (SearchView) findViewById(R.id.search_view);
//		searchView.setSubmitButtonEnabled(true);//文本框后提交按钮
//		
//	}

	//抽屉。。。。
	private void initDrawerLayout(){
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		naviItemText = getResources().getStringArray(R.array.navi_item);
		
		drawerLayout.setDrawerShadow(R.drawable.boult_right, GravityCompat.START);
		
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();		
		for(int i=0;i<naviItemText.length;i++){
			Map<String, Object> item = new HashMap<String, Object>();
			item.put(NAVI_ITEM_TEXT, naviItemText[i]);
			data.add(item);
		}

		
		String[] from = new String[]{NAVI_ITEM_TEXT};
		int[] to = new int[]{R.id.txt_drawer_list_item};
		listView = (ListView) findViewById(R.id.list_view);
		//添加listview头部视图
		headerView = getLayoutInflater().inflate(R.layout.activity_view_drawer_list_header, null);
		listView.addHeaderView(headerView);
		
		listView.setAdapter(new SimpleAdapter(this, data, R.layout.activity_view_drawer_list_item, from, to));
		listView.setOnItemClickListener(new listener());
		
		initActionBarToggle();
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	private void initActionBarToggle(){
		drawerToggle = new ActionBarDrawerToggle(LoginEnterAfterHomeActivity.this, drawerLayout, R.drawable.listbutton, R.string.drawer_open, R.string.drawer_close){
	
			@Override
			public void onDrawerOpened(View drawerView) {
				//setTitle("部落平方");
				
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
			   //setTitle("部落平方2");
				super.onDrawerClosed(drawerView);
			}
			
		};
		drawerLayout.setDrawerListener(drawerToggle);
	}
	
	private class listener implements OnItemClickListener{
		Fragment frag = null;
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			
			if(position >=0 && position<=naviItemText.length){
				switch(position){

				case 1:
					//frag = new HomeListHeaderFragment(); 
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
					
				}
			}
			Log.d("TAG", (frag == null)+"");
			//getFragmentManager().beginTransaction().replace(R.id.frame_layout, frag).commit();
			if(frag != null){
			getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, frag).commit();
			}
			//FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.frame_layout, frag).commit();
			drawerLayout.closeDrawer(Gravity.LEFT);
		}
		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_enter_after, menu);
		return true;
	}



}
