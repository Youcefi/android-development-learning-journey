package com.menu.tp5_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Youcefi Nour Elhouda & Daoudi Nadia
 * Groupe 2
 */


     public class MainActivity extends AppCompatActivity {

        static ListView mList;
        static MonAdapter sAdapter;
         public static final String BUNDLE_EXTRA_VALEUR1 = "BUNDLE_EXTRA_VALEUR1";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mList = findViewById(R.id.maList);

            ArrayList<Personne> personneArrayList = new ArrayList<>();

            initList(personneArrayList);

            sAdapter = new MonAdapter(this, R.layout.detail_personne, personneArrayList);

            mList.setAdapter(sAdapter);



        }



        private void initList(ArrayList<Personne> list) {

            Personne personne1 = new Personne("Mohamed", "Enseignant");
            Personne personne2 = new Personne("Omar", "Etudiant");
            Personne personne3 = new Personne("Karim", "Comptable");
            Personne personne4 = new Personne("Reda", "DRH");
            Personne personne5 = new Personne("Djawed", "Commercial");


            list.add(personne1);
            list.add(personne2);
            list.add(personne3);
            list.add(personne4);
            list.add(personne5);


        }
         public void ClicBas(View v) {
             //Traitement

             Toast.makeText(MainActivity.this, " Vous avez cliqué sur l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();
         }


         public void ClicHaut(View v) {
             //Traitement
             Intent intent= new Intent(MainActivity.this,MonAdapter.class);
             startActivity(intent);
             Toast.makeText(MainActivity.this, " Vous avez cliqué sur l'élément " + v.getTag(), Toast.LENGTH_SHORT).show();
         }


     }