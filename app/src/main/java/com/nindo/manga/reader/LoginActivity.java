package com.nindo.manga.reader;

/**
 * Created by NindoDev on 9/26/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    FloatingActionButton fabBtn;
    RelativeLayout rootLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initInstances();
    }

    private void initInstances() {
        rootLayout = (RelativeLayout) findViewById(R.id.loginRootLayout);
        fabBtn = (FloatingActionButton) findViewById(R.id.loginFabBtn);
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });

    }


}
