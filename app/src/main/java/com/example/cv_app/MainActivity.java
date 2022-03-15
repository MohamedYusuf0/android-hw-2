package com.example.cv_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.PersonName);
        EditText age = findViewById(R.id.PersonAge);
        EditText job = findViewById(R.id.PersonJob);
        EditText phoneNum = findViewById(R.id.PersonPhoneNumber);
        EditText email = findViewById(R.id.PersonEmail);

        Button next = findViewById(R.id.button);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( name.getText().toString().equals("") || age.getText().toString().equals("") ||
                     job.getText().toString().equals("") || phoneNum.getText().toString().equals("") ||
                     email.getText().toString().equals("") ) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Info",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent Next = new Intent(MainActivity.this,MainActivity2.class);
                    String Name = name.getText().toString();
                    Next.putExtra("Name",Name);

                    String Age = age.getText().toString();
                    Next.putExtra("Age",Age);

                    String Job = job.getText().toString();
                    Next.putExtra("Job",Job);

                    String PhoneNum = phoneNum.getText().toString();
                    Next.putExtra("PhoneNum",PhoneNum);

                    String Email = email.getText().toString();
                    Next.putExtra("Email",Email);

                    startActivity(Next);
                }

                }
            });
        }

    }