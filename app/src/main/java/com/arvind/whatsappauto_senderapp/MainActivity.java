package com.arvind.whatsappauto_senderapp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 2000; // Splash screen timeout in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example: Delayed execution to simulate a loading process
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start your app's main activity
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Close the splash activity to prevent going back to it
            }
        }, SPLASH_TIME_OUT);
    }
}
