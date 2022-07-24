package com.example.progmob_tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, pass, repass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        changeStatusBarColor();

        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPassword);
        repass = (EditText) findViewById(R.id.editTextrePassword);
        register = (Button) findViewById(R.id.cirRegisterButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = name.getText().toString();
                String mail = email.getText().toString();
                String passwordInput = pass.getText().toString();
                String passwordMatch = repass.getText().toString();

                if(name.getText().toString().length()==0){
                    name.setError("Nama Tidak Boleh Kosong");
                }else if(email.getText().toString().length()==0){
                    email.setError("Email Tidak Boleh Kosong");
                }else if (!validateEmailAddress(email.getText().toString().trim())) {
                    email.setError("Email Tidak Valid");
                }else if (pass.getText().toString().length()==0){
                    pass.setError("Password Tidak Boleh Kosong");
                }else if (!passwordInput.equals(passwordMatch)){
                    repass.setError("Password Tidak Sama");
                }else if (repass.getText().toString().length()==0){
                    repass.setError("Password Tidak Boleh Kosong");
                }else{
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", nama);
                    intent.putExtra("email", mail);
                    intent.putExtra("pass", passwordInput);
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

    public void changeStatusBarColor()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view)
    {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
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


