package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {

    TextView totalTV;
    TextView subtotalTV;
    double numbers = 0.0;
    Button submitB; // 1 create button
    EditText orderET;
    EditText inspectionET;
    EditText paintET;
    EditText partsET;
    EditText laborET;


    //2 create listener
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random gen = new Random();
            double number = gen.nextDouble();

            String v1 = "$ " + number;
            subtotalTV.setText(v1);

            String orderTypeValue = orderET.getText().toString();
            String inspectionTypeValue = inspectionET.getText().toString();
            String paintTypeValue = paintET.getText().toString();
            String partsTypeValue = partsET.getText().toString();
            String laborTypeValue = laborET.getText().toString();

            Double orderDouble = Double.parseDouble(orderTypeValue);
            Double inspectionDouble = Double.parseDouble(inspectionTypeValue);
            Double paintDouble = Double.parseDouble(paintTypeValue);
            Double partsDouble = Double.parseDouble(partsTypeValue);
            Double laborDouble = Double.parseDouble(laborTypeValue);
            double subtotal = orderDouble + inspectionDouble + paintDouble + partsDouble + laborDouble;

            String subtotalValue = "$ " + subtotal;
            subtotalTV.setText(subtotalValue);


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        totalTV = findViewById(R.id.totalLabel);
        subtotalTV = findViewById(R.id.subtotalLabel);
        orderET = findViewById(R.id.typeText);
        inspectionET = findViewById(R.id.inspectionText);
        paintET = findViewById(R.id.paintText);
        partsET = findViewById(R.id.partsText);
        laborET = findViewById(R.id.laborText);


        submitB = findViewById(R.id.submitButton);
        submitB.setOnClickListener(buttonListener); // set on button

    }
}