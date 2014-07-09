package com.imcore.xbionic.fragment;

import com.imcore.xbionic.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class FirstFragment extends Fragment{
	ImageView img_first;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_first_fragment, null);
		img_first = (ImageView) view.findViewById(R.id.img_first_fragment);
		
		//img_first_fragment.setVisibility(0);
		return view;
	}
}
