package org.tensorflow.lite.examples.classification;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String[] option;
    private Integer[] arrow;
    private Integer[] leftim;


    public CustomAdapter(Activity context,
                         String[] option, Integer[] arrow, Integer[] leftim) {
        super(context, R.layout.design, option);
        this.context = context;
        this.option = option;
        this.arrow = arrow;
        this.leftim = leftim;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.design, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.get);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.arrow);
        ImageView leftv = (ImageView) rowView.findViewById(R.id.leftimg);
        txtTitle.setText(option[position]);

        imageView.setImageResource(arrow[position]);
        leftv.setImageResource(leftim[position]);
        return rowView;
    }
}