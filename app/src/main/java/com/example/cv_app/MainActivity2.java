package com.example.cv_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button dial;
    Button OpenEmail;
    Button back;
    TextView name;
    TextView age;
    TextView job;
    TextView phoneNum;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dial = findViewById(R.id.dial);
        back = findViewById(R.id.Back) ;
        OpenEmail = findViewById(R.id.openEmail);

        name = findViewById(R.id.PersonName);
        age = findViewById(R.id.PersonAge);
        job = findViewById(R.id.PersonJob);
        phoneNum = findViewById(R.id.PersonPhoneNumber);
        email = findViewById(R.id.PersonEmail);

        Bundle N = getIntent().getExtras();
        String Name = N.getString("Name");
        name.setText(Name);

        Bundle A = getIntent().getExtras();
        String Age = A.getString("Age");
        age.setText(Age);

        Bundle J = getIntent().getExtras();
        String Job = J.getString("Job");
        job.setText(Job);

        Bundle PN = getIntent().getExtras();
        String PhoneNum = PN.getString("PhoneNum");
        phoneNum.setText(PhoneNum);

        Bundle E = getIntent().getExtras();
        String Email = E.getString("Email");
        email.setText(Email);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(Back);
            }

        });
        OpenEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Open = new Intent(getPackageManager().getLaunchIntentForPackage("com.google.android.gm"));
            startActivity(Open);
            }
        });
    }
    public void onDialButton(View v) {
        String PersonNum = phoneNum.getText().toString();
        Intent dial = new Intent(Intent.ACTION_DIAL);
        dial.setData(Uri.parse("tel:" + PersonNum));
        if (ContextCompat.checkSelfPermission(MainActivity2.this,
            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_DENIED); {

                    startActivity(dial);
        }


    }

}