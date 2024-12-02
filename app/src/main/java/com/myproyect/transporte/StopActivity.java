package com.myproyect.transporte;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        ListView lvStops = findViewById(R.id.lvStops);

        String[] stops = new String[]{
                "Parada 1", "Parada 2", "Parada 3", "Parada 4", "Parada 5",
                "Parada 6", "Parada 7", "Parada 8", "Parada 9", "Parada 10"
        };

        List<String> stopsList = new ArrayList<>(List.of(stops));
        Random random = new Random();
        int outOfService1 = random.nextInt(stops.length);
        int outOfService2 = random.nextInt(stops.length);

        stopsList.set(outOfService1, stops[outOfService1] + " (Fuera de Servicio)");
        stopsList.set(outOfService2, stops[outOfService2] + " (Fuera de Servicio)");

        lvStops.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stopsList));

        lvStops.setOnItemClickListener((parent, view, position, id) -> {
            if (stopsList.get(position).contains("Fuera de Servicio")) {
                Toast.makeText(this, "⚠ Esta parada está fuera de servicio", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tiempo restante: " + random.nextInt(15) + " minutos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
