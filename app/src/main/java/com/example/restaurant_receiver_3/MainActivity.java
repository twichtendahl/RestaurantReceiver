package com.example.restaurant_receiver_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.datamodel.Payment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Payment payment;
    TextView confirmationCode;
    TextView creditCardConfirm;
    TextView cscConfirm;
    TextView expiryConfirm;
    TextView test1;
    TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access views
        confirmationCode = findViewById(R.id.confirmationCode);
        creditCardConfirm = findViewById(R.id.creditConfirm);
        cscConfirm = findViewById(R.id.cscConfirm);
        expiryConfirm = findViewById(R.id.expiryConfirm);
        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);

        Bundle bundle = getIntent().getExtras();
        String paymentAsString = getString(R.string.send_failed);
        if (bundle != null) {
            paymentAsString = bundle.getString("payment_string_key");
            String orderDetail = paymentAsString.substring(0, paymentAsString.indexOf('*'));
            String paymentDetail = paymentAsString.substring(paymentAsString.indexOf('*') + 1);

            ArrayList<String> details = new ArrayList<>();
            for(int i = 0; i < paymentDetail.length(); i++) {
                String word = "";
                char c = paymentDetail.charAt(i);
                if(c != ' ') {
                    word += c;
                } else {
                    details.add(word);
                }
            }

            confirmationCode.setText(details.get(7));
            creditCardConfirm.setText(details.get(2));
            cscConfirm.setText(details.get(3));
            expiryConfirm.setText(String.format("%s/%s", details.get(4), details.get(5)));

            test1.setText(orderDetail);
            test2.setText(paymentDetail);
        }
        // Populate with data from PaymentActivity
        // confirmationCode.setText(paymentAsString);
    }
}
