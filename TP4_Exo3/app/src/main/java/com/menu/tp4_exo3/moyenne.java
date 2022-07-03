package com.menu.tp4_exo3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class moyenne extends AppCompatActivity {



    private EditText mValeur1, mValeur2, mValeur3;
    private Button mCalculer;
    private float mNumber1, mNumber2, mNumber3, mMoyenne;


    public static final String BUNDLE_EXTRA_MOYENNE = "BUNDLE_EXTRA_MOYENNE";


    private static final int REUSSITE_ACTIVITY_REQUEST_CODE = 40;
    private static final int RECALE_ACTIVITY_REQUEST_CODE = 41;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moyenne);
        init();
        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getDataValue()) {

                    mMoyenne = (mNumber1 + mNumber2 + mNumber3) / 3;

                    Intent intent;

                    if (mMoyenne >= 10) {
                        intent = new Intent(moyenne.this,reussite.class);
                        intent.putExtra(BUNDLE_EXTRA_MOYENNE, mMoyenne);
                        startActivityForResult(intent, REUSSITE_ACTIVITY_REQUEST_CODE);
                    } else {
                        intent = new Intent(moyenne.this, recale.class);
                        intent.putExtra(BUNDLE_EXTRA_MOYENNE, mMoyenne);
                        startActivityForResult(intent, RECALE_ACTIVITY_REQUEST_CODE);

                    }
                }
            }
        });
    }

    private void init() {
        mValeur1 = findViewById(R.id.valeur1);
        mValeur2 = findViewById(R.id.valeur2);
        mValeur3 = findViewById(R.id.valeur3);
        mCalculer = findViewById(R.id.btnCalculer);
    }


    private boolean getDataValue() {

        if (!mValeur1.getText().toString().isEmpty() && !mValeur2.getText().toString().isEmpty() && !mValeur3.getText().toString().isEmpty()) {

            mNumber1 = Float.parseFloat(mValeur1.getText().toString());
            mNumber2 = Float.parseFloat(mValeur2.getText().toString());
            mNumber3 = Float.parseFloat(mValeur3.getText().toString());
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
}
