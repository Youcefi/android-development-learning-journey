package com.menu.tp5_exo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Youcefi Nour Elhouda & Daoudi Nadia
 * Groupe 2
 */

public class MonAdapter extends ArrayAdapter<Personne> {


    private Context context;
    private int idLayout;
    private List<Personne> maListe;
    public static final String BUNDLE_EXTRA_VALEUR = "BUNDLE_EXTRA_VALEUR";

    public MonAdapter(Context context, int resource, List<Personne> objects) {
        super(context, resource, objects);
        this.context = context;
        this.idLayout = resource;
        this.maListe = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert vi != null;
            v = vi.inflate(idLayout, parent, false);
        }

        Personne p = maListe.get(position);

        TextView nom = v.findViewById(R.id.tvNom);
        nom.setText(p.getNom());

        TextView fonction = v.findViewById(R.id.tvFonction);
        fonction.setText(p.getFonction());

        ImageButton haut = v.findViewById(R.id.btnHaut);
        haut.setTag(position);

        ImageButton bas = v.findViewById(R.id.btnBas);
        bas.setTag(position);


        haut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = (Integer) v.getTag();
                if (a > 0) {
                    Personne personne = maListe.get(a);
                    maListe.remove(a);
                    maListe.add(a - 1, personne);
                    MainActivity.sAdapter.notifyDataSetChanged();
                    MainActivity.mList.setAdapter(MainActivity.sAdapter);
                    Toast.makeText(context, " Vous avez cliqué sur l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();

                }

            }
        });


        bas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = (Integer) v.getTag();
                if (a + 1 < maListe.size()) {
                    Personne personne = maListe.get(a);
                    maListe.remove(a);
                    maListe.add(a + 1, personne);
                    MainActivity.sAdapter.notifyDataSetChanged();
                    MainActivity.mList.setAdapter(MainActivity.sAdapter);
                    Toast.makeText(context, " Vous avez cliqué sur l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }
}