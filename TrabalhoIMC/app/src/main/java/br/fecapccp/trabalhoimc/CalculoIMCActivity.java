package br.fecapccp.trabalhoimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {

    private Button buttonCalc;
    private Button buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        buttonCalc = findViewById(R.id.btnSet);

        buttonCalc.setOnClickListener(view -> {

                EditText campoPeso = findViewById(R.id.editTextPeso);
                EditText campoaltura = findViewById(R.id.editTextAltura);
                String peso = campoPeso.getText().toString();
                String altura = campoaltura.getText().toString();

            if (peso.isEmpty() || altura.isEmpty()) {
                campoPeso.setText("");
                campoaltura.setText("");
                return;
            }

                float pesoC = Float.parseFloat(peso);
                float alturaC = Float.parseFloat(altura);

                float imc = 0;
                imc = pesoC/((alturaC)*(alturaC));


                if(imc<18.5){
                Intent intent = new Intent(this, AbaixoDoPesoActivity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
                }
            else if (imc>=18.5 && imc < 24.9 ){
                Intent intent = new Intent(this, PesoNormalActivity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
            }
            else if(imc >=25 && imc <= 29.9){
                Intent intent = new Intent(this, SobrepesoActivity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
            }
            else if(imc>=30 && imc <= 34.9){
                    Intent intent = new Intent(this, Obesidade1Activity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
            }
            else if (imc>=35 && imc<=39.9){
                    Intent intent = new Intent(this, Obesidade2Activity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
            }
            else if (imc>=40){
                    Intent intent = new Intent(this, Obesidade3Activity.class);
                    intent.putExtra("peso", pesoC);
                    intent.putExtra("altura", alturaC);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                    finish();
            }



        });
        buttonFechar = findViewById(R.id.btnFechar);

        buttonFechar.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void limpar (View view) {
        EditText campoPeso = findViewById(R.id.editTextPeso);
        EditText campoaltura = findViewById(R.id.editTextAltura);
        campoPeso.setText("");
        campoaltura.setText("");
    }


@Override
    protected void onDestroy(){
        super.onDestroy();
}

}