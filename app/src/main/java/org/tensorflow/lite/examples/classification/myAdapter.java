package org.tensorflow.lite.examples.classification;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends ArrayAdapter<String> {

    String[] text;
    int[] icons;
    Context mContext;

    public myAdapter(Context context,String[] menuItems,int[] icons){
        super(context,R.layout.fragment_search);
        this.text = menuItems;
        this.icons = icons;
        this.mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row, parent, false);
            mViewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            mViewHolder.menu_text = (TextView) convertView.findViewById(R.id.item);
            convertView.setTag(mViewHolder);

        }else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.image.setImageResource(icons[position]);
        mViewHolder.menu_text.setText(text[position]);

        return convertView;

    }

    static  class ViewHolder{
        ImageView image;
        TextView  menu_text;
    }


}
