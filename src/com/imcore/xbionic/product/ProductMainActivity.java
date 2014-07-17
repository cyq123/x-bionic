package com.imcore.xbionic.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;
import com.imcore.xbionic.R;
import com.imcore.xbionic.http.DataRequest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class ProductMainActivity extends Activity {
	ExpandableListView expandableListView;
	ImageView img_gridview;
	GridView gridView;
	TextView txt_gridview,img1_product_main,img2_product_main;
	
	List<Map<String, Object>> childDatas;
	List<String> groupData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_product_main);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_product_main_customtitle);
		 img_gridview = (ImageView) findViewById(R.id.img_gridview_list_product_main);
		 txt_gridview = (TextView) findViewById(R.id.txt_gridview_list_product_main);
		 img1_product_main= (TextView) findViewById(R.id.img1_product_main);
		 img2_product_main= (TextView) findViewById(R.id.img2_product_main);
		 
		expandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);
		
		getGroupInfo();
		
	}
	
	private void getGroupInfo(){
		String url = "http://bulo2bulo.com:8080/mobile/api/category/list.do";
		RequestQueue queue = Volley.newRequestQueue(this);
		DataRequest request = new DataRequest(Request.Method.GET, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				groupData = new ArrayList<String>();
				try {
					JSONArray ja = new JSONArray(response);
					for(int i = 0;i<ja.length();i++){
						JSONObject jo = ja.getJSONObject(i);
						String code = jo.getString("code");
						groupData.add(code);
					}
					Log.i("group---", groupData.size()+"");//--------
					for(String m:groupData){
						Log.i("data-------", m+"");
						
						getChild(m);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		});
		queue.add(request);
	}
	
	private void getChild(String m){
		String url = "http://bulo2bulo.com:8080/mobile/api/category/list.do?navId="+m;
		RequestQueue que = Volley.newRequestQueue(this);
		DataRequest reques = new DataRequest(Request.Method.GET, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				childDatas = new ArrayList<Map<String, Object>>();
				//List<String> childData = new ArrayList<String>();
				Map<String, Object> map = null;
				try {
					JSONArray ja2 = new JSONArray(response);
					for(int j=0;j<ja2.length();j++){
						JSONObject jso = ja2.getJSONObject(j);
						String name = jso.getString("name");
						String imageUrl = jso.getString("imageUrl");
						map = new HashMap<String, Object>();
						map.put("name", name);
						map.put("imageUrl", imageUrl);
						childDatas.add(map);
						map = null;
					}
					
					
					
					Log.i("child----", childDatas.size()+"");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				expandableListView.setAdapter(new expandableAdapter());
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		});
		que.add(reques);
	}

	private class expandableAdapter extends BaseExpandableListAdapter{

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childDatas.get(groupPosition).get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
				ViewGroup parent) {
			View view = convertView;
			if(view == null){
				view = getLayoutInflater().inflate(R.layout.activity_product_main_gridview, null);
			}
			
			gridView = (GridView) view.findViewById(R.id.gridview_product_main);
			gridView.setAdapter(new gridViewAdapter(groupPosition));
			return view;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
				ViewGroup parent) {
			int[] groupImage = new int[]{R.drawable.upbackground,R.drawable.downbackground};
			View view = convertView;
			ViewHolder vh;
			if(view == null){
				vh = new ViewHolder();
				view = getLayoutInflater().inflate(R.layout.activity_product_main_expandablelistview_list, null);
				vh.img = (ImageView) view.findViewById(R.id.img1_product_main);
				view.setTag(vh);
			}else{
				vh = (ViewHolder) view.getTag();
			}
			vh.img.setImageResource(groupImage[groupPosition]);
			return view;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return false;
		}
		
		class ViewHolder{
			ImageView img;
		}
	}
	
	public class gridViewAdapter extends BaseAdapter{
		private int groupPosition;
		public gridViewAdapter(int groupPosition){
			this.groupPosition=groupPosition;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return childDatas.get(groupPosition).size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return childDatas.get(groupPosition).get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			View view = convertView;
			ViewHolder vh;
			if(view == null){
				vh = new ViewHolder();
				view = getLayoutInflater().inflate(R.layout.activity_product_main_gridview_list, null);
				vh.img_grid = (ImageView) view.findViewById(R.id.img_gridview_list_product_main);
				vh.txt_grid = (TextView) view.findViewById(R.id.txt_gridview_list_product_main);
				view.setTag(vh);
			}else{
				vh = (ViewHolder) view.getTag();
			}
			
			for(int i=0;i<childDatas.size();i++){
				String imgUrl = null;
				String name = null;
				Map<String, Object> data = childDatas.get(i);
				for(int j= 0;j<data.size();j++){
					imgUrl = (String) data.get("imageUrl");
					name = (String) data.get("name");
				}
				Log.i("imgUrl", imgUrl);
			setImage(vh.img_grid,"http://bulo2bulo.com:8080/"+imgUrl+"_L.png");
			vh.txt_grid.setText(name);
			}
			return view;
		}
		//http://bulo2bulo.com:8080/mobile/upload/Category/X-BIONIC/Outdoor_L.png
		class ViewHolder{
			ImageView img_grid;
			TextView txt_grid;
		}
		
	}
	
	private void setImage(ImageView imgv,String url){
		RequestQueue queue = Volley.newRequestQueue(this);
		ImageLoader mloader = new ImageLoader(queue, new ImageCache() {
			int maxSize = 10*1024*1024;
			private LruCache<String, Bitmap> lru = new LruCache<String, Bitmap>(maxSize){
				
			};
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				lru.put(url,bitmap);
				
			}
			
			@Override
			public Bitmap getBitmap(String url) {
				// TODO Auto-generated method stub
				return lru.get(url);
			}
		});
		
		ImageListener listener = mloader.getImageListener(imgv, R.drawable.upbackground, R.drawable.downbackground);
		mloader.get(url, listener,400,400);
	}
	//  http://bulo2bulo.com/mobile/upload/Category/X-BIONIC/Golf_L.png
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_main, menu);
		return true;
	}

}
