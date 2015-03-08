package com.cdmx_team.chillgo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridTagsAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater inflater;

	public GridTagsAdapter(Context c) {
		mContext = c;
		inflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView imageView;
		if (convertView == null) { // if it's not recycled, inflate one.
			imageView = (TextView)inflater.inflate(R.layout.tag, parent, false);
		} else {
			imageView = (TextView) convertView;
		}
		imageView.setText(mThumbIds[position]);
		imageView.setTypeface(Typeface.createFromAsset(inflater.getContext().getAssets(), "Roboto-Bold.ttf"));
		//imageView.setBackgroundResource(R.drawable.tag_container);
		return imageView;
	}

	// references to our images
	private String[] mThumbIds = { "Pasarse un semáforo en Rojo",
			"Tener relaciones sexuales",
			"Exceder el límite de velocidad", "Usar el celular",
			"No usar cinturón de seguridad", "Arrancones", "No traer placas", "No circula", "Beber Chela" };

}
