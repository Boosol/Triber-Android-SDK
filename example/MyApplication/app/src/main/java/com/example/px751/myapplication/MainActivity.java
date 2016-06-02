package com.example.px751.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.pixhe.tribersdk.TriberSdk;
import fr.pixhe.tribersdk.TriberSdkConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TriberSdkConfig config = new TriberSdkConfig();
        config.themeTextColor = Color.RED;
        config.themeTitleColor = Color.BLACK;

        TriberSdk sdk = TriberSdk.getInstance();

        sdk.init(this, "APIKEY", config);

        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        sdk.launch(this, R.id.my_fragment_container);

    }
}
