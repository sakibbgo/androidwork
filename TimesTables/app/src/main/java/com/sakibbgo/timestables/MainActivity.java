package com.sakibbgo.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber)
    {
        ArrayList<String> timesTablesContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++)
        {
            timesTablesContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTablesContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timeTablesSeekBar);
        timesTablesListView = findViewById(R.id.timeTablesListView);

        int max = 20;
        int startingPosition = 1;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTablesNumber;

                if (progress < min){
                    timesTablesNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }
                else {
                    timesTablesNumber = progress;
                }
                Log.i("SeekBar", Integer.toString(timesTablesNumber));
                generateTimesTable(timesTablesNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
