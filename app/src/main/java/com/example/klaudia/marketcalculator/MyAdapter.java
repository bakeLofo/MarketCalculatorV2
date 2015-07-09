package com.example.klaudia.marketcalculator;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.klaudia.marketcalculator.Model.Market;

import java.util.List;


public class MyAdapter extends ArrayAdapter<Market> {
    private final Activity context;
    private final List<Market> names;

    static class ViewHolder {
        public TextView text;
        public ImageButton button;
        public ImageView image;
    }

    public MyAdapter(Activity context, List<Market> names) {
        super(context, R.layout.single_item,names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.single_item, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.market);

            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.icon);
            viewHolder.button= (ImageButton) rowView.findViewById(R.id.star);
            rowView.setTag(viewHolder);
        }


        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();

            holder.image.setImageResource(R.drawable.logo);
            holder.button.setImageResource(R.drawable.empty);
            holder.text.setText(names.get(position).getTitle());

        //Log.d("MyAdapter","position"+names.get(0).getTitle());




        return rowView;
    }
}
