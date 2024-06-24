// MAIN Packages
package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// COMPONENTS
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class HireMe extends AppCompatActivity {

    private EditText nameInput, mailInput, noInput;
    private Button hireme_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_me);

        // Initialize EditText and Button
        nameInput = findViewById(R.id.nameInput);
        mailInput = findViewById(R.id.mailInput);
        noInput = findViewById(R.id.noInput);
        hireme_submit = findViewById(R.id.hireme_submit);

        // Set up the button HIREME_SUBMIT
        hireme_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    // SENDING EMAIL SETUP
    private void sendEmail() {
        // Get input values
        String name = nameInput.getText().toString().trim();
        String email = mailInput.getText().toString().trim();
        String phone = noInput.getText().toString().trim();

        // Validate input
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(HireMe.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Log the input values
        Log.d("HireMe", "Name: " + name);
        Log.d("HireMe", "Email: " + email);
        Log.d("HireMe", "Phone: " + phone);

        // Create email subject and body
        String subject = "New Contact Request";
        String body = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;

        // Create email intent using ACTION_SEND
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"muhammadabid.dev@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        // Verify there is an email client installed before starting the intent
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(HireMe.this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }
}
