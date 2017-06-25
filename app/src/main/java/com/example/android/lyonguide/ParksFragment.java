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
public class ParksFragment extends Fragment {

    //Global variable declaration
    private Intent i = new Intent(Intent.ACTION_VIEW);

    public ParksFragment() {
        // Required empty public constructor
    }

    //Overriding the OnCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_structure, container, false);

        //Creating the list of parks
        final ArrayList<Area> areas = new ArrayList<>();
        areas.add(new Area("Parc de la Tête d'Or", "The park is 290 acres big. It has a zoo, boating, velodrome, boules court, mini-golf, horse riding, and a miniature train.", R.drawable.parc_tete_dor, "https://fr.wikipedia.org/wiki/Parc_de_la_T%C3%AAte_d%27or"));
        areas.add(new Area("Parc de la Cerisaie", "The park is 11 acres big. It is partially situated on a slope, leading from the plateau of the Croix-Rousse down towards the river Saône.", R.drawable.parc_de_la_cerisaie, "https://fr.wikipedia.org/wiki/Parc_de_la_Cerisaie"));
        areas.add(new Area("Parc de Lacroix-Laval", "The park is 280 acres of partially wooded land and the INTEFP is located inside the park.", R.drawable.parc_de_lacroix_laval, "https://fr.wikipedia.org/wiki/Parc_de_Lacroix-Laval"));
        areas.add(new Area("Parc de Parilly", "The park is 440 acres big. It includes numerous sport facilities, including a running track, a hippodrome, and basketball courts.", R.drawable.parc_de_parilly, "https://fr.wikipedia.org/wiki/Parc_de_Parilly"));
        areas.add(new Area("Parc de la Feyssine", "The park is wooded over 50% of its surface, and has trails for walking, mountain biking and running", R.drawable.parc_feyssine, "https://fr.wikipedia.org/wiki/Parc_de_la_Feyssine"));
        areas.add(new Area("Parc de Gerland", "The park is 200 acres big. It  includes several playgrounds, a skatepark and a botanical garden.", R.drawable.parc_gerland, "https://fr.wikipedia.org/wiki/Parc_de_Gerland"));
        areas.add(new Area("Parc Saint-Clair", "The park has an area of 9.9 acres, is bordered by the Rhône and the Boulevard périphérique de Lyon.", R.drawable.parc_saint_clair, "https://fr.wikipedia.org/wiki/Parc_Saint-Clair"));
        areas.add(new Area("Parc Sergent Blandan", "The park is 42 acres big. It has three distinct areas: a multi-purpose square, a ecological area, and a central garden.", R.drawable.parc_sergent_blandan, "https://fr.wikipedia.org/wiki/Parc_Sergent_Blandan"));
        areas.add(new Area("Grand Parc de Miribel-Jonage", "The park covers almost 2,200 hectares on the outskirts of Lyon. It includes wildlife protection zones for fauna and flora. ", R.drawable.parc_meribel, "https://fr.wikipedia.org/wiki/Grand_parc_de_Miribel-Jonage"));

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
