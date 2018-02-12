package com.example.prashant.timestableonseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    int s;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableGenerator(1);


        SeekBar seekBar = (SeekBar) findViewById(R.id.mySeekBar);
        seekBar.setMax(1000);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;

                if(i<min){
                    seekBar.setProgress(1);
                }else{

                    s=i;

                    Log.i("Number" ,Integer.toString(s));
                    tableGenerator(s);
                }




            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
    public void tableGenerator(int i) {

        ArrayList<String> arrayList = new ArrayList<String>();
        for (int a = 1; a < 500; a++) {
            arrayList.add(Integer.toString(i * a));
        }

        listView = (ListView) findViewById(R.id.myListView);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);


}
}
