package com.cdmx_team.chillgo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	private static SituationBuilderFragment situationBuilderFragment;
	private static PlaceholderFragment placeHolderFragment;
	private static InfografiaFragment infografiaFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			situationBuilderFragment = new SituationBuilderFragment();
			placeHolderFragment = new PlaceholderFragment();
			infografiaFragment = new InfografiaFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, placeHolderFragment, "placeholder")
					.addToBackStack("placeholder")
					.commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public class PlaceholderFragment extends Fragment {

		Activity context;

		public PlaceholderFragment() {
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			context = activity;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			((Button) rootView.findViewById(R.id.conductor))
					.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View view) {
							getSupportFragmentManager()
									.beginTransaction()
									.replace(R.id.container,
											situationBuilderFragment)
									.addToBackStack("situationBuilder").commit();
							getSupportActionBar().setTitle(R.string.pregunta);
						}
					});
			return rootView;
		}
		
		@Override
		public void onResume(){
			super.onResume();
			getSupportActionBar().setTitle(R.string.app_name);
		}
	}
}
