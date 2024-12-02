package com.myproyect.transporte;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMetro = findViewById(R.id.btnMetro);
        Button btnBus = findViewById(R.id.btnBus);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnAlert = findViewById(R.id.btnAlert);
        EditText etSearch = findViewById(R.id.etSearch);

        HashMap<String, String> stopToTransport = new HashMap<>();
        stopToTransport.put("Parada 1", "Metro Línea 3");
        stopToTransport.put("Parada 2", "Bus 70");
        stopToTransport.put("Parada 3", "Metro Línea 5");
        stopToTransport.put("Parada 4", "Bus 21");

        btnMetro.setOnClickListener(v -> openTransportActivity("metro"));
        btnBus.setOnClickListener(v -> openTransportActivity("bus"));

        btnSearch.setOnClickListener(v -> {
            String query = etSearch.getText().toString().trim();
            if (stopToTransport.containsKey(query)) {
                Toast.makeText(this, "Disponible: " + stopToTransport.get(query), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No hay transporte disponible", Toast.LENGTH_SHORT).show();
            }
        });

        btnAlert.setOnClickListener(v -> {
            Toast.makeText(this, "⚠ Paradas fuera de servicio: Parada 3, Parada 7", Toast.LENGTH_LONG).show();
        });
    }

    private void openTransportActivity(String type) {
        Intent intent = new Intent(this, TransportActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
