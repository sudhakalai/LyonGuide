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
public class ChurchesFragment extends Fragment {

    //Global variable declaration
    private Intent i = new Intent(Intent.ACTION_VIEW);

    public ChurchesFragment() {
        // Required empty public constructor
    }

    //Overriding the OnCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_structure, container, false);

        //Creating the list of churches
        final ArrayList<Area> areas = new ArrayList<>();
        areas.add(new Area("Notre-Dame de Fourvière", "Fourvière is dedicated to the Virgin Mary, to whom is attributed the salvation of the city of Lyon from the bubonic plague.", R.drawable.fourviere, "https://fr.wikipedia.org/wiki/Basilique_Notre-Dame_de_Fourvi%C3%A8re"));
        areas.add(new Area("Église Saint-Paul", "It is a Romanesque and Gothic building", R.drawable.st_paul, "https://fr.wikipedia.org/wiki/%C3%89glise_Saint-Paul_de_Lyon"));
        areas.add(new Area("Église Saint-Georges", "It is a Roman Catholic church located on the Place François-Bertras, in the Vieux Lyon", R.drawable.saint_georges, "https://fr.wikipedia.org/wiki/%C3%89glise_Saint-Georges_de_Lyon"));
        areas.add(new Area("Cathédrale Saint-Jean", "It is a Roman Catholic church located on Place Saint-Jean", R.drawable.saint_jean, "https://fr.wikipedia.org/wiki/Primatiale_Saint-Jean_de_Lyon"));

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
