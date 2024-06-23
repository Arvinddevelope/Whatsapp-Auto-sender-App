package com.arvind.whatsappauto_senderapp;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextPhoneNumber, editTextMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize views
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.btnSend);

        // Send button click listener
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        if (phoneNumber.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please enter phone number and message", Toast.LENGTH_SHORT).show();
            return;
        }

        // Use Intent to open WhatsApp and send message
        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            sendIntent.putExtra("jid", phoneNumber + "@s.whatsapp.net"); //phone number without "+" prefix

            startActivity(sendIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
