package com.example.nuhavarier.shopping_app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nuhavarier.shopping_app.R;

public class LoginPage extends AppCompatActivity {
    RelativeLayout skip;
    String email1,password1;
    EditText email;
    EditText password;
    RelativeLayout signup;
    Button login;

    String whereFrom = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        getSupportActionBar().hide();

        if (getIntent().hasExtra("is_from")) {
            whereFrom = getIntent().getStringExtra("is_from");
        }

        initSF();

        Log.d("TTTTT",email1+"  "+password1);

        skip=findViewById(R.id.skip);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("my_preference", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("is_user_logged_in",false);
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whereFrom.equals("MainActivity")) {
                    Intent intent=new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent=new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("TTTTT",email.getText().toString()+" <> "+password.getText().toString());
                if(email1.equals(email.getText().toString())){
                    if (password1.equals(password.getText().toString())){
                        SharedPreferences sharedPreferences=getSharedPreferences("my_preference", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("is_user_logged_in",true);
                        if (whereFrom.equals("MainActivity")) {
                            setResult(Activity.RESULT_OK);
                            finish();
                        } else {
                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Incorrect password",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect mail id",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initSF();
    }

    private void initSF(){
        SharedPreferences sharedPreferences=getSharedPreferences("my_preference", Context.MODE_PRIVATE);
        email1=sharedPreferences.getString("email","");
        password1=sharedPreferences.getString("password","");
    }
}
