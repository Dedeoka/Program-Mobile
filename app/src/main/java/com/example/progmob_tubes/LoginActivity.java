package com.example.progmob_tubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class   LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        Intent intent = getIntent();
        String nama = getIntent().getStringExtra("name");
        String mail = getIntent().getStringExtra("email");
        String pass = getIntent().getStringExtra("pass");
        email.setText(mail);
        password.setText(pass);
        login = (Button) findViewById(R.id.cirLoginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();

                if(email.getText().toString().length()==0){
                    email.setError("Email Tidak Boleh Kosong");
                }else if (!validateEmailAddress(email.getText().toString().trim())) {
                    email.setError("Email Tidak Valid");
                }else if (password.getText().toString().length()==0){
                    password.setError("Password Tidak Boleh Kosong");
                }else{
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateEmailAddress (String email){

        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }else {
            return false;
        }
    }

    public void onLoginClick(View view)
    {
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

    public void onClickgoogle(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com"));
        startActivity(intent);
    }

    public void onClickfb(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
        startActivity(intent);
    }

}




//        Btnlog.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {

//        }
//        });
//
//        reg = (TextView)findViewById(R.id.buatakun);
//        reg.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//        }
//        });