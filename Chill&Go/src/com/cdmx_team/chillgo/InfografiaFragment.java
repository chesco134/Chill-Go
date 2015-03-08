package com.cdmx_team.chillgo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfografiaFragment extends Fragment {

	ActionBarActivity activity;
	FragmentManager fManager;
	String tituloInfografia;
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		this.activity = (ActionBarActivity) activity;
		fManager = this.activity.getSupportFragmentManager();
	}
	
	public InfografiaFragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.infografia, parent,false);
		Bundle arguments = getArguments();
		tituloInfografia = arguments.getString("titulo_infografia");
		((TextView)rootView.findViewById(R.id.titulo_infografia)).setText(tituloInfografia);
		((TextView)rootView.findViewById(R.id.legalidad)).setText(arguments.getString("legalidad"));
		((TextView)rootView.findViewById(R.id.articulos)).setText(arguments.getString("articulos"));
		((TextView)rootView.findViewById(R.id.enlace)).setText(arguments.getString("enlace"));
		((TextView)rootView.findViewById(R.id.multa_o_corralon)).setText(arguments.getString("multa_o_corralon"));
		((TextView)rootView.findViewById(R.id.informacion)).setText(arguments.getString("informacion"));
		((TextView)rootView.findViewById(R.id.que_procede)).setText(R.string.que_procede);
		((TextView)rootView.findViewById(R.id.que_procede)).setTypeface(Typeface.createFromAsset(activity.getAssets(), "RobotoCondensed-Bold.ttf"));
		((TextView)rootView.findViewById(R.id.que_procede)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				QueProcedeFragment queProcedeFragment = new QueProcedeFragment();
				Bundle arguments = new Bundle();
		    	arguments.putString("titulo_infografia", tituloInfografia);
		    	arguments.putString("consejo_1","No has cometido ningún delito, piensa con la cabeza fría, los policías no pueden hacerles nada, ni bajarlos del coche o perdirles papeles.");
		    	arguments.putString("consejo_2","En la Constitución Política de los Estados Unidos Mexicanos, artículo 16, se hace referencia a los actos de molestia y señala que: \"Nadie puede ser molestado en su persona, familia, domicilio, papeleos o posesiones, sino en virtud de mandamiento escrito de la autoridad competente, que funde y motive la causa legal del procedimiento.\"");
            	queProcedeFragment.setArguments(arguments);
		    	fManager.beginTransaction().replace(R.id.container,queProcedeFragment).addToBackStack("infografia").commit();
			}
		});
		return rootView;
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		activity.getSupportActionBar().setTitle(R.string.pregunta);
	}
}
