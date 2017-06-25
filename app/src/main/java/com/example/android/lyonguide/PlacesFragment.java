package com.example.android.lyonguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    //Global variable declaration
    private Intent i = new Intent(Intent.ACTION_VIEW);

    public PlacesFragment() {
        // Required empty public constructor
    }

    //Overriding the OnCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_structure, container, false);

        //Creating the list of places
        final ArrayList<Area> areas = new ArrayList<>();
        areas.add(new Area("Vieux Lyon", "It is the city's oldest district, and is protected under the Malraux law to protect France's cultural sites.", R.drawable.vieux_lyon, "https://fr.wikipedia.org/wiki/Vieux_Lyon"));
        areas.add(new Area("Place Bellecour", "It is a large square in the centre of Lyon", R.drawable.place_bellecour, "https://fr.wikipedia.org/wiki/Place_Bellecour"));
        areas.add(new Area("Hôtel de Ville", "It is the city hall of the City of Lyon and one of the largest historic buildings in the city.", R.drawable.hdv_lyon, "https://fr.wikipedia.org/wiki/H%C3%B4tel_de_ville_de_Lyon"));
        areas.add(new Area("Aquarium de Lyon", "It is a public aquarium in Lyon.", R.drawable.lyon_aquarium, "https://fr.wikipedia.org/wiki/Aquarium_de_Lyon"));

        //Attaching an adapter to the list
        AreaAdapter adapter = new AreaAdapter(getActivity(), R.color.colorCategory, areas);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Setting onItenClickListener so that the user can navigate to the appropriate link
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Area area = areas.get(position);
                i.setData(Uri.parse(area.getWebLink()));
                startActivity(i);
            }
        });

        return rootView;
    }

}
