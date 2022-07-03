package com.menu.tp3_exo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.action_search:
               Toast.makeText(this,"Recherche",Toast.LENGTH_SHORT).show();
               return true;
           case R.id.action_refresh:
               Toast.makeText(this,"Actualiser",Toast.LENGTH_SHORT).show();
               return true;
           default: return super.onOptionsItemSelected(item);
       }
    }
}
