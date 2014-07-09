package com.imcore.xbionic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imcore.xbionic.R;
import com.imcore.xbionic.ui.EnterActivity;
import com.imcore.xbionic.ui.WelcomeTwoActivity;

public class ThreeFragment extends Fragment{
	TextView txtOpen;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_three_fragment, null);
		txtOpen = (TextView) view.findViewById(R.id.txt_open);

		txtOpen.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(),EnterActivity.class);
				startActivity(intent);
			
			}
		});

		return view;
	}

}
