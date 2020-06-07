package com.example.nuhavarier.shopping_app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nuhavarier.shopping_app.R;

public class SignUp extends AppCompatActivity {
    String email1="";
    String password1="";
    Button signup;
    EditText name;
    EditText phone;
    EditText password;
    EditText cpassword;
    EditText email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.sign_up);
        signup=findViewById(R.id.signup);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);

                if(name.getText().toString().equals("")||phone.getText().toString().equals("")||email.getText().toString().equals("")||password.getText().toString().equals("")||cpassword.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "Please fill in all the details", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(phone.getText().toString().length()==10) {
                        if (password.getText().toString().equals(cpassword.getText().toString())) {
                            saveSharedPreference();
                            startActivity(intent);
                            finish();

                        } else
                            Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }


                    else{
                        Toast.makeText(getApplicationContext(), "Enter valid phone number", Toast.LENGTH_SHORT).show();
                    }
                    }
                    }
        });
    }
    public void saveSharedPreference(){
        SharedPreferences sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name.getText().toString().trim());
        editor.putString("phone",phone.getText().toString().trim());
        editor.putString("email",email.getText().toString().trim());
        editor.putString("password",password.getText().toString().trim());
        editor.putBoolean("is_user_logged_in",true);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
    }

    public void deleteSharedPreference(){
        SharedPreferences sp = getSharedPreferences("my_preference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(sp.contains("name"))
            editor.remove("name");
        if(sp.contains("num"))
            editor.remove("num");
        editor.commit();

    }

}
