package com.menu.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class operation extends AppCompatActivity {

    private Button B_addition, B_soustraction, B_division, B_multiplication;
    public static final String BUNDLE_EXTRA_RESULTAT = "BUNDLE_EXTRA_RESULTAT";
    public static final String RETURN_EXTRA_VALEUR1 = "RETURN_EXTRA_VALEUR1";
    public static final String RETURN_EXTRA_VALEUR2 = "RETURN_EXTRA_VALEUR2";
    private static final int CALCULE_ACTIVITY_REQUEST_CODE = 40;

    private void init() {
        B_addition = findViewById(R.id.addition);
        B_soustraction = findViewById(R.id.soustraction);
        B_division = findViewById(R.id.division);
        B_multiplication = findViewById(R.id.multiplication);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        init();
        Intent intent = getIntent();
        final float valeur1= intent.getFloatExtra(MainActivity.BUNDLE_EXTRA_VALEUR1,0);
        final float valeur2= intent.getFloatExtra(MainActivity.BUNDLE_EXTRA_VALEUR2,0);

        B_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int decision=1;
                Intent intent;
                intent = new Intent(operation.this, MainActivity.class);
                intent.putExtra(BUNDLE_EXTRA_RESULTAT, decision);
                intent.putExtra(RETURN_EXTRA_VALEUR1,valeur1);
                intent.putExtra(RETURN_EXTRA_VALEUR2,valeur2);
                startActivityForResult(intent, CALCULE_ACTIVITY_REQUEST_CODE);
            }
        });
        B_soustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int decision=2;
                Intent intent;
                intent = new Intent(operation.this, MainActivity.class);
                intent.putExtra(BUNDLE_EXTRA_RESULTAT, decision);
                intent.putExtra(RETURN_EXTRA_VALEUR1,valeur1);
                intent.putExtra(RETURN_EXTRA_VALEUR2,valeur2);
                startActivityForResult(intent, CALCULE_ACTIVITY_REQUEST_CODE);
            }
        });
        B_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int decision=3;
                Intent intent;
                intent = new Intent(operation.this, MainActivity.class);
                intent.putExtra(BUNDLE_EXTRA_RESULTAT, decision);
                intent.putExtra(RETURN_EXTRA_VALEUR1,valeur1);
                intent.putExtra(RETURN_EXTRA_VALEUR2,valeur2);
                startActivityForResult(intent, CALCULE_ACTIVITY_REQUEST_CODE);
            }
        });
        B_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int decision=4;
                Intent intent;
                intent = new Intent(operation.this, MainActivity.class);
                intent.putExtra(BUNDLE_EXTRA_RESULTAT, decision);
                intent.putExtra(RETURN_EXTRA_VALEUR1,valeur1);
                intent.putExtra(RETURN_EXTRA_VALEUR2,valeur2);
                startActivityForResult(intent, CALCULE_ACTIVITY_REQUEST_CODE);

            }
        });
    }
}
