package com.example.tp3exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepicker);
        final TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(false);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;

                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();

                Toast.makeText(MainActivity.this, "Heure sélectionnée:" + hour + ":" + minute, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
