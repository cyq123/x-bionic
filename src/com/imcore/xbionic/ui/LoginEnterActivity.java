package com.imcore.xbionic.ui;

import com.imcore.xbionic.R;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class LoginEnterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login_enter);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_login_enter_customtitle);
		
	}
	

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_enter, menu);
		return true;
	}

}
