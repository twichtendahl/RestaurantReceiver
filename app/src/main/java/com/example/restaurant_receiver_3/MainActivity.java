package com.example.restaurant_receiver_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.datamodel.Payment;

public class MainActivity extends AppCompatActivity {

    Payment payment;
    TextView confirmationCode;
    TextView creditCardConfirm;
    TextView cscConfirm;
    TextView expiryConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access views
        confirmationCode = findViewById(R.id.confirmationCode);
        creditCardConfirm = findViewById(R.id.creditConfirm);
        cscConfirm = findViewById(R.id.cscConfirm);
        expiryConfirm = findViewById(R.id.expiryConfirm);

        Bundle bundle = getIntent().getExtras();
        String paymentAsString = getString(R.string.send_failed);
        if (bundle != null) {
            paymentAsString = bundle.getString("payment_string_key");
        }
        // Populate with data from PaymentActivity
        confirmationCode.setText(paymentAsString);
    }
}
