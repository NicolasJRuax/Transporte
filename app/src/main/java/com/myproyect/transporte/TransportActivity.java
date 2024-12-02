package com.myproyect.transporte;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class TransportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        ListView lvLines = findViewById(R.id.lvLines);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        List<String> options = type.equals("metro")
                ? Arrays.asList("Línea 3", "Línea 5", "Línea 7")
                : Arrays.asList("Bus 70", "Bus 146", "Bus 21");

        lvLines.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options));

        lvLines.setOnItemClickListener((parent, view, position, id) -> {
            Intent stopIntent = new Intent(this, StopActivity.class);
            stopIntent.putExtra("line", options.get(position));
            startActivity(stopIntent);
        });
    }
}
