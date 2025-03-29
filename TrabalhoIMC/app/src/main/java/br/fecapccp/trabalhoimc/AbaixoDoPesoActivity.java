package br.fecapccp.trabalhoimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class AbaixoDoPesoActivity extends AppCompatActivity {

    private TextView resultadoIMC;
    private TextView altura1;
    private TextView peso1;

    private Button buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        altura1 = findViewById(R.id.altura1);
        peso1 = findViewById(R.id.peso);
        resultadoIMC = findViewById(R.id.imc1);

        buttonFechar = findViewById(R.id.buttonFechar);

        Bundle bundle = getIntent().getExtras();

        float altura = bundle.getFloat("altura", 0);
        float peso = bundle.getFloat("peso", 0);
        float imc = bundle.getFloat("imc", 0);

        altura1.setText("Altura: " + altura + " m");
        peso1.setText("Peso: " + peso + " kg");
        resultadoIMC.setText("IMC: " + String.format("%.2f", imc));




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonFechar.setOnClickListener(view ->{
        finish();
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


}