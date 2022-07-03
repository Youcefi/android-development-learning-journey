package com.example.tp3_exo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText mValeur1, mValeur2;
    private Button B_addition, B_soustraction, B_division, B_multiplication;
    private TextView mResultat;
    private float nombre1, nombre2;


    private void init() {
         mValeur1 = findViewById(R.id.valeur1);
        mValeur2 = findViewById(R.id.valeur2);
        B_addition = findViewById(R.id.addition);
        B_soustraction = findViewById(R.id.soustraction);
        B_division = findViewById(R.id.division);
        B_multiplication = findViewById(R.id.multiplication);
        mResultat = findViewById(R.id.resultat);
    }

    private boolean getDataValue() {

        if (!mValeur1.getText().toString().isEmpty() && !mValeur2.getText().toString().isEmpty()) {

            nombre1 = Float.parseFloat(mValeur1.getText().toString());
            nombre2 = Float.parseFloat(mValeur2.getText().toString());

            return true;
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Erreur !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setMessage("Le champ de saisi est vide")
                    .create()
                    .show();
            return false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
            B_addition.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getDataValue()) {
                        float somme = nombre1 + nombre2;
                        mResultat.setText(String.valueOf(somme));
                    }
                }
            });
            B_soustraction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getDataValue()) {
                        float sous = nombre1 - nombre2;
                        mResultat.setText(String.valueOf(sous));
                    }
                }
            });
            B_division.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getDataValue()) {
                        float div = nombre1 / nombre2;
                        mResultat.setText(String.valueOf(div));
                    }
                }
            });
            B_multiplication.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getDataValue()) {
                        float mult = nombre1 * nombre2;
                        mResultat.setText(String.valueOf(mult));
                    }
                }
            });
        }
    }
//}