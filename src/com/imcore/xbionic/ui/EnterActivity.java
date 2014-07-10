package com.imcore.xbionic.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.imcore.xbionic.R;

public class EnterActivity extends Activity implements OnClickListener {
	ImageButton btn1_qq_login_enter, btn2_sina_login_enter, btn3_login_enter,
			btn4_register_enter;
	ImageButton helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		widgetView();
	}

	public void widgetView() {
		helper = (ImageButton) findViewById(R.id.txt1_helper_enter);
		btn1_qq_login_enter = (ImageButton) findViewById(R.id.btn1_qq_login_enter);
		btn2_sina_login_enter = (ImageButton) findViewById(R.id.btn2_sina_login_enter);
		btn3_login_enter = (ImageButton) findViewById(R.id.btn3_login_enter);
		btn4_register_enter = (ImageButton) findViewById(R.id.btn4_register_enter);
		btn1_qq_login_enter.setOnClickListener(this);
		btn2_sina_login_enter.setOnClickListener(this);
		btn3_login_enter.setOnClickListener(this);
		btn4_register_enter.setOnClickListener(this);
		helper.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn1_qq_login_enter) {
			Intent intent = new Intent(EnterActivity.this,
					QQLoginEnterActivity.class);
			startActivity(intent);
		}
		if (v.getId() == R.id.btn2_sina_login_enter) {
			Intent intent = new Intent(EnterActivity.this,
					SinaLoginEnterActivity.class);
			startActivity(intent);
		}
		if (v.getId() == R.id.btn3_login_enter) {
			Intent intent = new Intent(EnterActivity.this,
					LoginEnterActivity.class);
			startActivity(intent);
		}
		if (v.getId() == R.id.btn4_register_enter) {
			Intent intent = new Intent(EnterActivity.this,
					RegisterEnterActivity.class);
			startActivity(intent);
		}
		if (v.getId() == R.id.txt1_helper_enter) {
			Intent intent = new Intent(EnterActivity.this,
					WelcomeTwoActivity.class);
			startActivity(intent);
		}

	}

	AlertDialog ad;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		android.content.DialogInterface.OnClickListener listener = null;
		android.content.DialogInterface.OnClickListener nolistener = null;
		ad = new AlertDialog.Builder(this).setPositiveButton("确定", listener)
				.setNegativeButton("取消", nolistener).setTitle("系统提示")
				.setMessage("确定要退出吗？").show();

		listener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				finish();
				

			}
		};

		nolistener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				ad.cancel();

			}
		};

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter, menu);
		return true;
	}

}
