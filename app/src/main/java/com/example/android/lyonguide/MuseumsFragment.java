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
public class MuseumsFragment extends Fragment {

    //Global variable declaration
    private Intent i = new Intent(Intent.ACTION_VIEW);

    public MuseumsFragment() {
        // Required empty public constructor
    }

    //Overriding the OnCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_structure, container, false);

        //Creating the list of museums
        final ArrayList<Area> areas = new ArrayList<>();
        areas.add(new Area("Musée des beaux-arts", "The museum's collections range from ancient Egypt antiquities to the Modern art period.", R.drawable.museum_beaux_art, "https://fr.wikipedia.org/wiki/Mus%C3%A9e_des_beaux-arts_de_Lyon"));
        areas.add(new Area("Musée des Confluences", "The museum is a science centre and anthropology museum ", R.drawable.museum_confluences, "https://fr.wikipedia.org/wiki/Mus%C3%A9e_des_Confluences"));
        areas.add(new Area("Musée d'art contemporain", "The museum is devoted to the contemporary art,", R.drawable.museum_contemporay, "https://fr.wikipedia.org/wiki/Mus%C3%A9e_d%27art_contemporain_de_Lyon"));
        areas.add(new Area("Musée Gadagne", "The museum is composed of the Musée d'histoire de Lyon and the Musée des marionnettes du monde ", R.drawable.museum_gadagne, "https://fr.wikipedia.org/wiki/Mus%C3%A9es_Gadagne"));
        areas.add(new Area("Musée de l'Imprimerie", "The museums's main missions is to enrich, preserve, document and value the book and graphic heritage.", R.drawable.museum_imprimerie, "https://fr.wikipedia.org/wiki/Mus%C3%A9e_de_l%27Imprimerie_(Lyon)"));
        areas.add(new Area("Musée des Tissus", "The museum has one of the world's largest collections of textiles and fabrics.", R.drawable.museum_tissue, "https://fr.wikipedia.org/wiki/Mus%C3%A9e_des_Tissus_et_des_Arts_d%C3%A9coratifs"));
        areas.add(new Area("Gallo-Roman Museum", "This is a museum on the Gallo-Roman civilisation in Lyon ", R.drawable.gallo_roman, "https://en.wikipedia.org/wiki/Gallo-Roman_Museum_of_Lyon-Fourvi%C3%A8re"));

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
