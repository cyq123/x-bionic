package com.imcore.xbionic.fragment;



import com.imcore.xbionic.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class HomeListHeaderActivity extends FragmentActivity {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		View view = inflater.inflate(R.layout.activity_home_list_header, null);
		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.ac);
		return view;
	}

}
