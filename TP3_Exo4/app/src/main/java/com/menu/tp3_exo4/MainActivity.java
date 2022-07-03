package com.menu.tp3_exo4;

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
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        return MenuChoise(item);
    }
    private void createMenu(Menu menu){
        menu.add(0,0,0,"Cupcake");
        menu.add(0,1,1,"Eclair");
        menu.add(0,2,2,"Honeycomb");
        menu.add(0,3,3,"Ice Cream Sandwich");
        menu.add(0,4,4,"Jelly Bean");
        menu.add(0,5,5,"Kitkat");
        menu.add(0,6,6,"Lollipop");
        menu.add(0,7,7,"Marshmallow");
        menu.add(0,8,8,"Nougat");

    }
    private boolean MenuChoise(MenuItem item){
        switch (item.getItemId()){
            case 0:
                Toast.makeText(this,"Version 1.5",Toast.LENGTH_LONG).show();
                return true;
            case 1 :
                Toast.makeText(this,"Version 2.0",Toast.LENGTH_LONG).show();
                return true;
            case 2 :
                Toast.makeText(this,"Version 3.0",Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(this,"Version 4.0",Toast.LENGTH_LONG).show();
                return true;
            case 4 :
                Toast.makeText(this,"Version 4.1",Toast.LENGTH_LONG).show();
                return true;
            case 5 :
                Toast.makeText(this,"Version 4.4",Toast.LENGTH_LONG).show();
                return true;
            case 6 :
                Toast.makeText(this,"Version 5.0",Toast.LENGTH_LONG).show();
                return true;
            case 7 :
                Toast.makeText(this,"Version 6.0",Toast.LENGTH_LONG).show();
                return true;
            case 8 :
                Toast.makeText(this,"Version 7.0",Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
