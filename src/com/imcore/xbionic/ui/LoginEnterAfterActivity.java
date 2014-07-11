package com.imcore.xbionic.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.imcore.xbionic.R;

public class LoginEnterAfterActivity extends Activity {
	private DrawerLayout drawerLayout;
	private ListView listView;
	private ActionBarDrawerToggle drawerToggle;
	private View headerView;
	
	private final static String NAVI_ITEM_TEXT = "text";
	String[] naviItemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_enter_after);
		
		initDrawerLayout();
		
	}
	
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
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.listbutton, R.string.drawer_open, R.string.drawer_close){
	
			@Override
			public void onDrawerOpened(View drawerView) {
				//getSupportActionBar().setTitle("部落平方");
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
			//getSupportActionBar().setTitle("部落平方");
				super.onDrawerClosed(drawerView);
			}
			
		};
		drawerLayout.setDrawerListener(drawerToggle);
	}
	
	private class listener implements OnItemClickListener{
		//final int positionHeader = listView.getItemAtPosition(headerView);
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			if(position >=0 && position<=naviItemText.length){
				switch(position){
				case 0:
					MainActivity m = new MainActivity();
					break;
				case 1:
					Intent intent = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent);
					break;
				case 2:
					Intent intent1 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent1);
					break;
				case 3:
					Intent intent2 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent2);
					break;
				case 4:
					Intent intent3 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent3);
					break;
				case 5:
					Intent intent4 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent4);
					break;
				case 6:
					Intent intent5 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent5);
					break;
				case 7:
					Intent intent6 = new Intent(LoginEnterAfterActivity.this,MainActivity.class);
					startActivity(intent6);
					break;
					
				}
			}
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_enter_after, menu);
		return true;
	}

}
