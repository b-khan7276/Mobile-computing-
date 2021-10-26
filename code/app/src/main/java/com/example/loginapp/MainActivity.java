package com.example.loginapp;
import android.content.Intent;
import java.io.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private  int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        assigning variables to the xml layout
        Name = (EditText)findViewById(R.id.etName);
        Password =(EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login =(Button)findViewById(R.id.btnLogin);
        Info.setText("Number of attempts remaining: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName =="Admin") && (userPassword =="1234")){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);


        }else{
            counter--;
            Info.setText("No of attempts remaining: " + String.valueOf(counter));


            if(counter==0){
                Login.setEnabled(false);
            }

        }
    }
}