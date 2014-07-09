package com.imcore.xbionic.ui;

import com.imcore.xbionic.R;

import com.imcore.xbionic.fragment.FirstFragment;
import com.imcore.xbionic.fragment.ThreeFragment;
import com.imcore.xbionic.fragment.TwoFragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ImageView;

public class WelcomeTwoActivity extends ActionBarActivity {
	ImageView img_include1, img_include2, img_include3;
	ViewPager viewPager;

	ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_two);
		getSupportActionBar().hide();

		viewPager = (ViewPager) findViewById(R.id.viewPager_WelcomeTwo);
		img_include1 = (ImageView) findViewById(R.id.img_include1);
		img_include2 = (ImageView) findViewById(R.id.img_include2);
		img_include3 = (ImageView) findViewById(R.id.img_include3);
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(listener);

	}

	class ViewPagerAdapter extends FragmentStatePagerAdapter {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {

			Fragment frag = null;
			switch (position) {
			case 0:
				frag = new FirstFragment();
				break;
			case 1:
				frag = new TwoFragment();

				break;
			case 2:
				frag = new ThreeFragment();

				break;
			}
			return frag;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	}

	private OnPageChangeListener listener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {

			if (position == 0) {
				img_include1.setVisibility(0);
				img_include2.setVisibility(4);
				img_include3.setVisibility(4);
			}
			if (position == 1) {
				img_include1.setVisibility(4);
				img_include2.setVisibility(0);
				img_include3.setVisibility(4);
			}
			if (position == 2) {
				img_include1.setVisibility(4);
				img_include2.setVisibility(4);
				img_include3.setVisibility(0);
			}

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_two, menu);
		return true;
	}

}
