package com.imcore.xbionic.ui;

import com.imcore.xbionic.LoginEnterActivity;
import com.imcore.xbionic.R;
import com.imcore.xbionic.R.layout;
import com.imcore.xbionic.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
	
public class EnterActivity extends Activity implements OnClickListener{
	ImageButton btn1_qq_login_enter,btn2_sina_login_enter,btn3_login_enter,btn4_register_enter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		widgetView();
	}
	
	public void widgetView(){
		btn1_qq_login_enter = (ImageButton) findViewById(R.id.btn1_qq_login_enter);
		btn2_sina_login_enter = (ImageButton) findViewById(R.id.btn2_sina_login_enter);
		btn3_login_enter = (ImageButton) findViewById(R.id.btn3_login_enter);
		btn4_register_enter = (ImageButton) findViewById(R.id.btn4_register_enter);
		btn1_qq_login_enter.setOnClickListener(this);
		btn2_sina_login_enter.setOnClickListener(this);
		btn3_login_enter.setOnClickListener(this);
		btn4_register_enter.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
	if(v.getId() == R.id.btn1_qq_login_enter){
		
	}if(v.getId() == R.id.btn2_sina_login_enter){
		
	}if(v.getId() == R.id.btn3_login_enter){
		Intent intent = new Intent(EnterActivity.this,LoginEnterActivity.class);
		startActivity(intent);
	}if(v.getId() == R.id.btn4_register_enter){
		
	}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter, menu);
		return true;
	}



}