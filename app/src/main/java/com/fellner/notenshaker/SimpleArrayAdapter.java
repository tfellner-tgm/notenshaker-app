package com.fellner.notenshaker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fellner.fellner.notenshaker.R;

import java.util.ArrayList;

/**
 * Created by Fellner on 18.12.14.
 */
public class SimpleArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    static ArrayList<String> values;
    private final int resource;

    public SimpleArrayAdapter(Context context, int resource, ArrayList<String> values) {
        super(context,resource,values);
        this.context = context;
        this.values = values;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        TextView textView = (TextView)rowView.findViewById(R.id.listview_item_text);
        textView.setText(values.get(position));
        textView.setTextColor(Color.WHITE);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.listview_item_image);
        if(!textView.getText().toString().contains("Average")){
            int diceID = getContext().getResources().getIdentifier("dice" + Integer.parseInt((String) textView.getText()), "drawable", getContext().getPackageName());
            imageView.setImageResource(diceID);
        }
        return rowView;
    }
}
