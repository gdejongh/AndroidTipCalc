package com.example.finallyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView salesInput;
    private TextView percentInput;
    private TextView amountInput;
    private TextView displayView;
    private Switch owesHouseSwitch;
    private boolean youOweHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        salesInput = findViewById(R.id.salesInput);
        percentInput = findViewById(R.id.percentInput);
        amountInput = findViewById(R.id.amountOwedInput);
        displayView = findViewById(R.id.displayView);
        owesHouseSwitch = findViewById(R.id.owesHouse);

        youOweHouse = true;
    }

    public void doSomething(View view){
        try {
            Calculator c = new Calculator();

            String salesString = salesInput.getEditableText().toString().trim();
            String percentString = percentInput.getEditableText().toString().trim();
            String amountString = amountInput.getEditableText().toString().trim();

            double sales = Double.parseDouble(salesString);
            double percent = Double.parseDouble(percentString);
            double amount = Double.parseDouble(amountString);

            StringBuffer sb = new StringBuffer("");

            double tipOut = c.calculateTipOut(percent, sales);
            double finalAmount = c.calculateFinal(youOweHouse, tipOut, amount);

            sb.append("Tip out:\t" + tipOut + "\n\nAmount Owed:\t" + finalAmount);


            displayView.setText(sb.toString());

        } catch (Exception e) {

            displayView.setText("Shit\ndon't\nwork");

        }
    }

    public void useSwitch(View view){
        TextView houseOwesView = findViewById(R.id.HouseOwesView);
        if(youOweHouse){
            youOweHouse = false;
            houseOwesView.setText("House owes you:");
        } else {
            youOweHouse = true;
            houseOwesView.setText("You Owe House:");
        }
    }
}
