package com.imcore.xbionic.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.SearchView;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.imcore.xbionic.R;
import com.imcore.xbionic.fragment.HomeListHeaderFragment;

public class LoginEnterAfterActivity extends Activity {
	private DrawerLayout drawerLayout;
	private ListView listView;
	private ActionBarDrawerToggle drawerToggle;//给drawerlayout设监听
	private View headerView;
	
	private SearchView searchView;
	private ImageView openDrawer;
	private final static String NAVI_ITEM_TEXT = "text";
	String[] naviItemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login_enter_after);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_home_list_header_title);
		
		openDrawer = (ImageView)findViewById(R.id.img1_home_list_header_title);
		openDrawer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				drawerLayout.openDrawer(Gravity.LEFT);
			}
		});
		initSearchView();//搜索
		initDrawerLayout();//抽屉
 
		//Fragment frag = new HomeListHeaderFragment(); 
	}
	
	public void initSearchView(){
		searchView = (SearchView) findViewById(R.id.search_view);
		searchView.setSubmitButtonEnabled(true);//文本框后提交按钮
		
	}
	
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
		drawerToggle = new ActionBarDrawerToggle(LoginEnterAfterActivity.this, drawerLayout, R.drawable.listbutton, R.string.drawer_open, R.string.drawer_close){
	
			@Override
			public void onDrawerOpened(View drawerView) {
				setTitle("部落平方");
				
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
			   setTitle("部落平方2");
				super.onDrawerClosed(drawerView);
			}
			
		};
		drawerLayout.setDrawerListener(drawerToggle);
	}
	
	private class listener implements OnItemClickListener{
		android.app.Fragment frag = null;
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			
			if(position >=0 && position<=naviItemText.length){
				switch(position){
				case 0:
					frag = new HomeListHeaderFragment(); 
					break;
				case 1:
					frag = new HomeListHeaderFragment(); 
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
			getFragmentManager().beginTransaction().replace(R.id.frame_layout, frag).commit();
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
