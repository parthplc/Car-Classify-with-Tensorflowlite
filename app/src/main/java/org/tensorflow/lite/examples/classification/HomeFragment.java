package org.tensorflow.lite.examples.classification;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.tensorflow.lite.examples.classification.tflite.Classifier;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button camera;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        camera = (Button) view.findViewById(R.id.button);

        camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ClassifierActivity.class);
                HomeFragment.this.startActivity(intent);
            }
        });

        return view;


    }
    public void onResume(){
        super.onResume();
        ((MainActivity1) getActivity()).setActionBarTitle("Home");
    }



}
