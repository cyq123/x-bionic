package com.imcore.xbionic.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.imcore.xbionic.R;

public class SinaLoginEnterActivity extends Activity{
	private ImageView back;
	private TextView txt;
	private String str = "        使用SSO登录前，请检查手机上是否已经安装新浪微博博客客户端，目前"
              + "仅3.00及以上微博客户端版本支持SSO；如果为安装，将自动转为Oauth2.0进行认证";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_sina_login_enter);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_sina_login_enter_customtitle);
	
		txt = (TextView) findViewById(R.id.txt_sina_loginEnter);
		txt.setText(str);
		back = (ImageView) findViewById(R.id.img_sina_login_enter_title);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
