package com.menu.tp4_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class recale extends AppCompatActivity {

    private TextView mMoyenne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recale);

        mMoyenne = findViewById(R.id.moyenneRecale);

        Intent intent = getIntent();

        if (intent != null)
            mMoyenne.setText(String.valueOf(intent.getFloatExtra(moyenne.BUNDLE_EXTRA_MOYENNE, 0)));

    }

}
