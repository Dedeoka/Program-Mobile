package com.example.progmob_tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class TransactionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
    }

    public void onClickDashboard(View view){
        Intent intent = new Intent(TransactionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickBayar(View view){
        Toast.makeText(TransactionActivity.this,"Berhasil Dibayar", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}