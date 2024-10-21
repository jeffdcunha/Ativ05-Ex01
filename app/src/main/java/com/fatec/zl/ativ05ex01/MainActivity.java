package com.fatec.zl.ativ05ex01;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@author:Jefferson Dantas da Cunha
 *@RA: 1110482323044
 */

public class MainActivity extends AppCompatActivity {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Spinner spQtdFaces;
    private Button btnRodar;
    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rb1 = findViewById(R.id.rb1);
        rb1.setChecked(true);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        spQtdFaces = findViewById(R.id.spFaces);
        btnRodar = findViewById(R.id.btnRodar);
        tvRes = findViewById(R.id.tvRes);

        popularSpinner();
        btnRodar.setOnClickListener(op -> gerar());


    }

    private void gerar() {
        StringBuffer buffer = new StringBuffer();
        int qtdFaces = (int) spQtdFaces.getSelectedItem() + 1;
        int qtdDados;
        if(rb1.isChecked())
            qtdDados = 1;
        else if(rb2.isChecked())
            qtdDados = 2;
        else
            qtdDados = 3;

        int cont = 0;
        Random r = new Random();

        while (cont < qtdDados){
            int valor = r.nextInt(qtdFaces - 1) + 1;
            buffer.append(valor);
            if(cont < qtdDados - 1)
                buffer.append(" , ");
            cont++;
        }
        tvRes.setText(buffer.toString());
    }

    private void popularSpinner(){
        List<Integer> listaFaces = new ArrayList<>();
        listaFaces.add(4);
        listaFaces.add(6);
        listaFaces.add(8);
        listaFaces.add(10);
        listaFaces.add(12);
        listaFaces.add(20);
        listaFaces.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaFaces);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQtdFaces.setAdapter(adapter);
    }
}