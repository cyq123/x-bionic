package com.imcore.xbionic.ui;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.imcore.xbionic.R;
import com.imcore.xbionic.http.Constant;
import com.imcore.xbionic.http.DataRequest;
import com.imcore.xbionic.http.RequestQueueSingleton;
import com.imcore.xbionic.util.JsonUtil;

public class LoginEnterActivity extends Activity {
	private ImageView back;
	private ImageButton enter;
	private EditText etName,etPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login_enter);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_login_enter_customtitle);
		
		enter = (ImageButton) findViewById(R.id.imgbtn1_loginEnter);
		back = (ImageView) findViewById(R.id.img_login_enter_title);
		etName = (EditText) findViewById(R.id.et_userName_loginEnter);
		etPassword = (EditText) findViewById(R.id.et_passWord_loginEnter);
		onclick();

	}
	
	private void onclick(){
		enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				doLogin();
				
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	@SuppressWarnings("unused")
	private void doLogin() {
		final String userName = etName.getText().toString().trim();
		final String password = etPassword.getText().toString().trim();

		String url = Constant.HOST + "/passport/login.do";
		DataRequest request = new DataRequest(Request.Method.POST, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						// 解析用户信息的json，保存userid和token
						onResponseForLogin(response);
									

					
					}}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(LoginEnterActivity.this, "hahahhahah:" + error,
								Toast.LENGTH_SHORT).show();

					}
				}) {
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				// 在此方法中设置要提交的请求参数
				Map<String,String> params = new HashMap<String, String>();
				params.put("phoneNumber", userName);
				params.put("password", password);
				
				
				return params;
			}
		};
		
		RequestQueueSingleton.getInstance(this).addToRequestQueue(request);
	}
	
	private void onResponseForLogin(String response){
		
		
		
		Intent intent = new Intent(LoginEnterActivity.this,MainActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_enter, menu);
		return true;
	}

}
