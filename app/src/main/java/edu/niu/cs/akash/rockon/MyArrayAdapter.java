package edu.niu.cs.akash.rockon;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Akash on 3/3/2016.
 */
public class MyArrayAdapter extends ArrayAdapter {
    public MyArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public TextView getView(int position, View convertView, ViewGroup parent) {
        TextView v = (TextView) super.getView(position, convertView, parent);
        //Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
        //v.setTypeface(type);
        return v;
    }

    public TextView getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView v = (TextView) super.getView(position, convertView, parent);
        //Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
        //v.setTypeface(type);
        return v;
    }
}
