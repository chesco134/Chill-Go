package com.cdmx_team.chillgo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QueProcedeFragment extends Fragment {

	ActionBarActivity activity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = (ActionBarActivity) activity;
		try {
			this.activity.getSupportActionBar().setTitle(R.string.que_procede);
		} catch (NullPointerException e) {
			Toast.makeText(activity, "Sí fue aquí el error n.n",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.que_procede, root, false);
		Bundle arguments = getArguments();
		((TextView) rootView.findViewById(R.id.titulo_infografia))
				.setText(arguments.getString("titulo_infografia"));
		((TextView) rootView.findViewById(R.id.consejo_1)).setText(arguments
				.getString("consejo_1"));
		((TextView) rootView.findViewById(R.id.consejo_2)).setText(arguments
				.getString("consejo_2"));
		((TextView) rootView.findViewById(R.id.captura_tus_datos))
				.setTypeface(Typeface.createFromAsset(activity.getAssets(),
						"RobotoCondensed-Bold.ttf"));
		return rootView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		activity.getSupportActionBar().setTitle(R.string.que_procede);
	}
}
