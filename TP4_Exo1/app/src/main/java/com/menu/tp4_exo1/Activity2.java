package com.menu.tp4_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {



    private RadioButton mPommeRadio, mPoireRadio;
    private TextView mNombrePomme, mNombrePoire;
    private Button mCalculer;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mPommeRadio = findViewById(R.id.radioPomme);
        mPoireRadio = findViewById(R.id.radioPoire);
        mCalculer = findViewById(R.id.btnCompter);
        mNombrePoire = findViewById(R.id.nombrePoire);
        mNombrePomme = findViewById(R.id.nombrePomme);



        mCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPommeRadio.isChecked()) {
                    int nombre = Integer.parseInt(mNombrePomme.getText().toString());
                    nombre++;
                    mNombrePomme.setText(String.valueOf(nombre));
                } else {
                    int nombre = Integer.parseInt( mNombrePoire.getText().toString());
                    nombre++;
                    mNombrePoire.setText(String.valueOf(nombre));
                }
            }
        });



        mCalculer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                registerForContextMenu(mCalculer);
                openContextMenu(mCalculer);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nb_Pomme:
                Toast.makeText(this, "le nombre de pommes " + mNombrePomme.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nb_Poire:
                Toast.makeText(this,"le nombre de poires " +  mNombrePoire.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nb_quiter:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
