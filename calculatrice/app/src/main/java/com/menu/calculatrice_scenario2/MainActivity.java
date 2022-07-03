package com.menu.calculatrice_scenario2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mValeur1, mValeur2;
    private Button mCalculer;
    private float mNumber1, mNumber2;
    private TextView mResultat;
    public static final String BUNDLE_EXTRA_VALEUR1 = "BUNDLE_EXTRA_VALEUR1";
    public static final String BUNDLE_EXTRA_VALEUR2 = "BUNDLE_EXTRA_VALEUR2";

    private void init() {
        mValeur1 = findViewById(R.id.valeur1);
        mValeur2 = findViewById(R.id.valeur2);
        mCalculer = findViewById(R.id.btnCalculer);

    }

    private boolean getValue() {

        if (!mValeur1.getText().toString().isEmpty() && !mValeur2.getText().toString().isEmpty()) {

            mNumber1 = Float.valueOf(mValeur1.getText().toString());
            mNumber2 = Float.valueOf(mValeur2.getText().toString());

            return true;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Erreur !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setMessage("Un champ de saisi est vide")
                    .create()
                    .show();
            return false;
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getValue()) {
                    Intent intent ;
                    intent = new Intent(MainActivity.this, operation.class);
                    intent.putExtra(BUNDLE_EXTRA_VALEUR1, mNumber1);
                    intent.putExtra(BUNDLE_EXTRA_VALEUR2, mNumber2);
                    startActivity(intent);
                }
            }
        });
        mResultat = findViewById(R.id.resultat);
        Intent intent = getIntent();

        if (intent != null) {
            mResultat.setText(String.valueOf(intent.getFloatExtra(operation.BUNDLE_EXTRA_RESULTAT, 0)));
        }


    }
}
