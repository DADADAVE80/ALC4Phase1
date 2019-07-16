package com.example.alc4phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button variable
        Button button;

        //Method for initializing About ALC button
        button = (Button) findViewById(R.id.about_alc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutALC();
            }
        });

        //Method for initializing My Profile button
        button = (Button) findViewById(R.id.my_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyProfile();
            }
        });
    }

    public void openAboutALC(){
        Intent intent = new Intent(this, AboutALCActivity.class);
        startActivity(intent);
    }

    public void openMyProfile(){
        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }
}