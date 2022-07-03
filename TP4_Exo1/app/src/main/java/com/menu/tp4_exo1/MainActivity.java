package com.menu.tp4_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mPasserelle = (Button) findViewById(R.id.button);
        mPasserelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Le premier paramètre est le nom de l'activité actuelle
                 *Le second est le nom de l'activité de destination
                 **/
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                // On lance l'intent
                startActivity(intent);
            }
        });
    }
}
