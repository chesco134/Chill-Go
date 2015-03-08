package com.cdmx_team.chillgo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class SituationBuilderFragment extends Fragment {

	private FragmentActivity context;
	FragmentManager fManager;

	public SituationBuilderFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = (FragmentActivity) activity;
		fManager = context.getSupportFragmentManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup root,Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.selector_caso,root,false);
	    GridView gridview = (GridView) rootView.findViewById(R.id.grid_tags);
	    gridview.setAdapter(new GridTagsAdapter(context));
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            if(position == 1){
	            	String titulo_infraccion = ((TextView)v).getText().toString();
	            	InfografiaFragment infografia = new InfografiaFragment();
	            	Bundle arguments = new Bundle();
	            	arguments.putString("titulo_infografia", titulo_infraccion);
	            	arguments.putString("legalidad","Legal");
	            	arguments.putString("articulos","Artículos 24, 25, 26 y 27 de la Ley de Cultura Cívica del DF.");
	            	arguments.putString("enlace", "http://mexico.justicia.com/estados/df/leyes/ley-de-cultura-civica-del-distrito-federal/");
	            	arguments.putString("multa_o_corralon", "Multa o Corralón: No aplica.");
	            	arguments.putString("informacion","Es legal, a menos que un \"vecino\" se sienta ofendido y denuncie. El término \"faltas a la moral\" no existe en éste código de conducta, por lo que no están previstos como infracción.");
	            	infografia.setArguments(arguments);
	            	fManager.beginTransaction().replace(R.id.container,infografia).addToBackStack("infografia").commit();
	            }else{
	            	Toast.makeText(context, "Sección en construcción n.n", Toast.LENGTH_SHORT).show();
	            }
	        }
	    });
	    return rootView;
	}
}
