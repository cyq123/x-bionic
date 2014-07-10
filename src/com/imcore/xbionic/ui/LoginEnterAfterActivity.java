package com.imcore.xbionic.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.imcore.xbionic.R;

public class LoginEnterAfterActivity extends ActionBarActivity {
	private DrawerLayout drawerLayout;
	private ListView listView;
	private ActionBarDrawerToggle drawerToggle;
	
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
		
		drawerLayout.setDrawerShadow(R.drawable.productmoreviewbackground, GravityCompat.START);
		
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();		
		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put(NAVI_ITEM_TEXT, naviItemText[0]);
		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put(NAVI_ITEM_TEXT, naviItemText[1]);
		Map<String, Object> item3 = new HashMap<String, Object>();
		item3.put(NAVI_ITEM_TEXT, naviItemText[2]);
		Map<String, Object> item4 = new HashMap<String, Object>();
		item4.put(NAVI_ITEM_TEXT, naviItemText[3]);
		Map<String, Object> item5 = new HashMap<String, Object>();
		item5.put(NAVI_ITEM_TEXT, naviItemText[4]);
		Map<String, Object> item6 = new HashMap<String, Object>();
		item6.put(NAVI_ITEM_TEXT, naviItemText[5]);
		Map<String, Object> item7 = new HashMap<String, Object>();
		item7.put(NAVI_ITEM_TEXT, naviItemText[6]);
		
		data.add(item1);
		data.add(item2);
		data.add(item3);
		data.add(item4);
		data.add(item5);
		data.add(item6);
		data.add(item7);
		
		String[] from = new String[]{NAVI_ITEM_TEXT};
		int[] to = new int[]{R.id.txt_drawer_list_item};
		listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(new SimpleAdapter(this, data, R.layout.activity_view_drawer_list_item, from, to));
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_enter_after, menu);
		return true;
	}

}
