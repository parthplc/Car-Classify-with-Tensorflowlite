package org.tensorflow.lite.examples.classification;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */

public class SettingsFragment extends Fragment {


    Integer[] icons ={R.drawable.ic_share_black_24dp,R.drawable.about_us};
    Integer[] img ={R.drawable.ic_chevron_right_black_24dp,R.drawable.ic_chevron_right_black_24dp};
    String[] menuItems = {"About us","Share Us"};



     public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ListView listView = view.findViewById(R.id.optionlist);


        CustomAdapter adapter = new CustomAdapter(getActivity(),menuItems,img,icons);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("tere",String.valueOf(position));
        switch(position){
            case 0:
                Intent intent = new Intent(view.getContext(),About_us.class);
                SettingsFragment.this.startActivity(intent);
            break;
            case 1:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody="Your Body Here";
                String shareSubject = "Your Subject Here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

                startActivity(Intent.createChooser(sharingIntent,"Sharing Using"));
            break;

        }

    }
});
        return view;
    }
    public void onResume(){
        super.onResume();
        ((MainActivity1) getActivity()).setActionBarTitle("Settings");
    }

}
