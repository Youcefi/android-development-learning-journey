package com.menu.calculatrice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mValeur1, mValeur2;
    private Button mCalculer;
    private TextView mResultat;
    private float nombre1, nombre2;
    public static final String BUNDLE_EXTRA_VALEUR1 = "BUNDLE_EXTRA_VALEUR1";
    public static final String BUNDLE_EXTRA_VALEUR2 = "BUNDLE_EXTRA_VALEUR2";

    private void init() {
        mValeur1 = findViewById(R.id.valeur1);
        mValeur2 = findViewById(R.id.valeur2);
        mResultat = findViewById(R.id.resultat);
        mCalculer = findViewById(R.id.btnCalculer);
    }

    private boolean getValue() {

        if (!mValeur1.getText().toString().isEmpty() && !mValeur2.getText().toString().isEmpty()) {

            nombre1 = Float.parseFloat(mValeur1.getText().toString());
            nombre2 = Float.parseFloat(mValeur2.getText().toString());

            return true;
        } else {
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
        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (getValue()) {
                    Intent intent;
                    intent = new Intent(MainActivity.this, operation.class);
                    intent.putExtra(BUNDLE_EXTRA_VALEUR1, nombre1);
                    intent.putExtra(BUNDLE_EXTRA_VALEUR2, nombre2);
                    startActivity(intent);


                }
            }
        });

        Intent intent = getIntent();

        if (intent != null) {

            int decision = intent.getIntExtra(operation.BUNDLE_EXTRA_RESULTAT, 0);
            final float Nbr1 = intent.getFloatExtra(operation.RETURN_EXTRA_VALEUR1, 0);
            final float Nbr2 = intent.getFloatExtra(operation.RETURN_EXTRA_VALEUR2, 0);

            switch (decision) {
                case 1:
                    Toast.makeText(this, "L'operation addition" , Toast.LENGTH_SHORT).show();
                    float somme = Nbr1 + Nbr2;
                    mResultat.setText(String.valueOf(somme));
                    break;
                case 2:
                    Toast.makeText(this, "L'operation soustraction" , Toast.LENGTH_SHORT).show();
                    float sous = Nbr1 - Nbr2;
                    mResultat.setText(String.valueOf(sous));
                    break;
                case 3:
                    Toast.makeText(this, "L'operation division" , Toast.LENGTH_SHORT).show();
                    float div = Nbr1 / Nbr2;
                    mResultat.setText(String.valueOf(div));
                    break;
                case 4:
                    Toast.makeText(this, "L'operation multiplication" , Toast.LENGTH_SHORT).show();
                    float mult = Nbr1 * Nbr2;
                    mResultat.setText(String.valueOf(mult));
                    break;
            }
        }
    }
}
