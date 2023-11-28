package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView milkPrice, vat, actual, sugarPrice, vatSugar, actualSugar, grandTotal,flourPrice, vatFlour, actualFlour,breadPrice, vatBread, actualBread, discountAmount, netPayAmount;
    Button milk, sugar,flour, bread;

    double initialPrice = 2320;
    double initialSugarPrice=1250;
    double initialFlourPrice = 3130;
    double initialBreadPrice = 6130;
    int count = 0;
    int sugarCount=0;
    int flourCount=0;
    int breadCount=0;
    double discountToBeAwarded = 0.0;
    double grandTotalAmount;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        milkPrice = findViewById(R.id.milkPrice);
        vat = findViewById(R.id.vat);
        actual = findViewById(R.id.actual);
        milk= findViewById(R.id.milk);

        sugarPrice = findViewById(R.id.sugarPrice);
        vatSugar = findViewById(R.id.vatSugar);
        actualSugar = findViewById(R.id.actualSugar);
        sugar = findViewById(R.id.sugar);

        flourPrice = findViewById(R.id.flourPrice);
        vatFlour = findViewById(R.id.vatFlour);
        actualFlour = findViewById(R.id.actualFlour);
        flour = findViewById(R.id.flour);

        breadPrice = findViewById(R.id.breadPrice);
        vatBread = findViewById(R.id.vatBread);
        actualBread = findViewById(R.id.actualBread);
        bread = findViewById(R.id.bread);

        grandTotal= findViewById(R.id.grandTotal);
        discountAmount= findViewById(R.id.discountAmount);
        netPayAmount= findViewById(R.id.netPayAmount);

        //initialize price for milk
        updateUI();
        updateSugarUI();
        updateFlourUI();
        updateBreadUI();
        updateGrandTotal();
        updateDiscount();

        milk.setOnClickListener((v)->{
            if(count < 4) {
                count++;
                updateUI();
                updateGrandTotal();
                updateDiscount();
            } else{
                Toast.makeText(NewActivity.this, "You can't buy more than 4 items :(", Toast.LENGTH_LONG).show();
            }
        });

        sugar.setOnClickListener(v->{
            if(sugarCount<4){
                sugarCount++;
                updateSugarUI();
                updateGrandTotal();
                updateDiscount();
            }else{
                Toast.makeText(this, "You cannot buy more than 4 items!", Toast.LENGTH_SHORT).show();
            }
        });

        flour.setOnClickListener((v) -> {
            if (flourCount < 4) {
                flourCount++;
                updateFlourUI();
                updateGrandTotal();
                updateDiscount();
            } else {
                Toast.makeText(NewActivity.this, "You can't buy more than 4 flour items :(", Toast.LENGTH_LONG).show();
            }
        });

        bread.setOnClickListener((v) -> {
            if (breadCount < 4) {
                breadCount++;
                updateBreadUI();
                updateGrandTotal();
                updateDiscount();
            } else {
                Toast.makeText(NewActivity.this, "You can't buy more than 4 bread items :(", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void updateUI(){
        double showedPrice = initialPrice * count;
        milkPrice.setText(String.valueOf(showedPrice));

        double taxAdded = (initialPrice * count) * 16/100;

        vat.setText(String.valueOf(taxAdded));

        double actualPrice = (initialPrice * count) + taxAdded;
        actual.setText(String.valueOf(actualPrice));
    }

    private void updateSugarUI() {
        double showedSugarPrice = initialSugarPrice * sugarCount;
        sugarPrice.setText(String.valueOf(showedSugarPrice));

        double taxDeductedSugar = (initialSugarPrice * sugarCount) * 16 / 100;
        vatSugar.setText(String.valueOf(taxDeductedSugar));

        double actualSugarPrice = (initialSugarPrice * sugarCount) + taxDeductedSugar;
        actualSugar.setText(String.valueOf(actualSugarPrice));

    }

    private void updateFlourUI() {
        double showedFlourPrice = initialFlourPrice * flourCount;
        flourPrice.setText(String.valueOf(showedFlourPrice));

        double taxDeductedFlour = (initialFlourPrice * flourCount) * 16 / 100;
        vatFlour.setText(String.valueOf(taxDeductedFlour));

        double actualFlourPrice = (initialFlourPrice * flourCount) + taxDeductedFlour;
        actualFlour.setText(String.valueOf(actualFlourPrice));
    }

    private void updateBreadUI() {

        double showedBreadPrice = initialBreadPrice * breadCount;
        breadPrice.setText(String.valueOf(showedBreadPrice));

        double taxDeductedBread = (initialBreadPrice * breadCount) * 16 / 100;
        vatBread.setText(String.valueOf(taxDeductedBread));

        double actualBreadPrice = (initialBreadPrice * breadCount) + taxDeductedBread;
        actualBread.setText(String.valueOf(actualBreadPrice));
    }

private void updateGrandTotal(){
     grandTotalAmount = 1.16*((initialPrice * count) + (initialSugarPrice * sugarCount) + (initialFlourPrice * flourCount) + (initialBreadPrice * breadCount));
     String grandTotalString = String.format("%.2f", grandTotalAmount);
        grandTotal.setText(grandTotalString);


        }

        private void updateDiscount(){
            if(grandTotalAmount >10000){
                discountToBeAwarded = 0.15* grandTotalAmount;
                discountAmount.setText(String.format("%.2f", discountToBeAwarded));
                double netPay= grandTotalAmount - discountToBeAwarded;
                String netPayString = String.format("%.2f", netPay);
                netPayAmount.setText(netPayString);

            }else{
                Toast.makeText(this, "No discount", Toast.LENGTH_SHORT).show();
                netPayAmount.setText(String.format("%.2f", grandTotalAmount));

            }
        }

}
