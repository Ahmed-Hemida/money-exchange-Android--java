package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final double DOLLAR_TO_POUND_RATE = 30.0;

    private EditText poundEditText;
    private EditText dollarEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poundEditText = findViewById(R.id.editTextText2);
        dollarEditText = findViewById(R.id.editTextText);
        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poundEditText.setText(String.valueOf(""));
                dollarEditText.setText(String.valueOf(""));

            }
        });
        Button convertButton = findViewById(R.id.convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    public void convertCurrency() {
        try {
            String poundStr = poundEditText.getText().toString();
            String dollarStr = dollarEditText.getText().toString();
if(!poundStr.isEmpty()&&!dollarStr.isEmpty()){
    Toast.makeText(this, "please fill only one field", Toast.LENGTH_SHORT).show();

}
            if (!poundStr.isEmpty()) {
                double poundAmount = Double.parseDouble(poundStr);
                double convertedDollar = poundAmount / DOLLAR_TO_POUND_RATE;
                dollarEditText.setText(String.valueOf(convertedDollar));
            } else if (!dollarStr.isEmpty()) {
                double dollarAmount = Double.parseDouble(dollarStr);
                double convertedPound = dollarAmount * DOLLAR_TO_POUND_RATE;
                poundEditText.setText(String.valueOf(convertedPound));
            } else {
                Toast.makeText(this, "invalid data try again", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }
    }
}