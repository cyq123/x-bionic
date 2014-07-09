package com.imcore.xbionic.ui;

import java.util.Timer;
import java.util.TimerTask;

import com.imcore.xbionic.R;
import com.imcore.xbionic.fragment.VirtivalProgres;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SlidingDrawer.OnDrawerScrollListener;

public class WelcomeActivity extends Activity {
	// ProgressBar img_progress;
	VirtivalProgres vitic;
	int p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		vitic = (VirtivalProgres) findViewById(R.id.img_progress);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(WelcomeActivity.this,
						WelcomeTwoActivity.class);
				startActivity(intent);
				WelcomeActivity.this.finish();
			}

		}, 2500);
		// Animation ani = AnimationUtils.loadAnimation(this, R.anim.translat);
		// img_progress.startAnimation(ani);
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
