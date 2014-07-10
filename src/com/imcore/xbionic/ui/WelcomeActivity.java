package com.imcore.xbionic.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.imcore.xbionic.R;
import com.imcore.xbionic.fragment.VirtivalProgres;

public class WelcomeActivity extends Activity {
	// ProgressBar img_progress;
	VirtivalProgres vitic;
	int p;
	private SharedPreferences preferences;
	private Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		vitic = (VirtivalProgres) findViewById(R.id.img_progress);

	
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		preferences = getSharedPreferences("count", Context.MODE_PRIVATE);
		
		if (hasFocus) {
			new Handler().postDelayed(new Runnable() {
				int count = preferences.getInt("count", 0);
				@Override
				public void run() {
					if(count == 0) {
						
						Intent intent = new Intent(WelcomeActivity.this,
								WelcomeTwoActivity.class);
						startActivity(intent);
					
						
						editor = preferences.edit();
						editor.putInt("count", ++count);
						editor.commit();
						WelcomeActivity.this.finish();
					} else {
						Intent intent = new Intent(WelcomeActivity.this,
								EnterActivity.class);
						finish();
						startActivity(intent);
					}
					
					
					
				}
			}, 2500);
			
		}
		
	}
	
	@Override
	protected void onStart() {
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// vitic.setMax(3);
				int progress = vitic.getProgress();
				progress += 2;
				vitic.setProgress(progress);

			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 1, 1);
		super.onStart();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
