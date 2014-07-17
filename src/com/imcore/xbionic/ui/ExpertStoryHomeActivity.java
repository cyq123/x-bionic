package com.imcore.xbionic.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.imcore.xbionic.R;
import com.imcore.xbionic.R.id;
import com.imcore.xbionic.R.layout;
import com.imcore.xbionic.R.menu;
import com.imcore.xbionic.http.DataRequest;
import com.imcore.xbionic.http.RequestQueueSingleton;
import com.imcore.xbionic.util.JsonUtil;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ExpertStoryHomeActivity extends Activity {
	ListView listView;
	List<List<String>> list;
	String title1 = "title";
	String updateDate1 = "updateDate";
	String phoneUrl1 = "phoneUrl";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_expert_story_home);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.activity_expert_story_home_customtitle);

		list = new ArrayList<List<String>>();
		listView = (ListView) findViewById(R.id.listView_expert_story_home);
		getTeamsList();
		// ListVAdapter adapter = new ListVAdapter();

	}

	public void getTeamsList() {
		String url = "http://bulo2bulo.com:8080/mobile/api/testteam/list.do?offset=0&fetchSize=10&userId=2351";
		 RequestQueue queue = Volley.newRequestQueue(this);
		DataRequest jar = new DataRequest(Request.Method.GET, url,
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						tonResponse(response);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.i("error", error.toString());

					}
				});
		 queue.add(jar);
//		RequestQueueSingleton.getInstance(getApplicationContext())
//				.addToRequestQueue(jar);
	}

	public void tonResponse(String response) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		try {
			Log.i("data", response);
//			JSONObject jObject = new JSONObject(response);
			JSONArray ja = new JSONArray(response);
//			ja = jObject.getJSONArray("data");

			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);
				String title = jo.getString("title");
				String updateDate = jo.getString("updateDate");
				String phoneUrl = jo.getString("phoneUrl");
				int id = jo.getInt("id");

				Log.i("title'''''", title);//-----------log--
				map = new HashMap<String, Object>();
				map.put(title1, title);
				map.put(updateDate1, updateDate);
				map.put(phoneUrl1, phoneUrl);
				map.put("id", id);
				data.add(map);
				map = null;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String[] from = new String[] { title1, updateDate1};
		int[] to = new int[] { R.id.txt1_expert_story_home_listview,
				R.id.txt2_expert_story_home_listview};
		Log.d("TAG", data.size()+"!!");
		listView.setAdapter(new SimpleAdapter(this, data,
				R.layout.activity_expert_story_home_listview, from, to));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expert_story_home, menu);
		return true;
	}

}
