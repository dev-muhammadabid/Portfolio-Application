package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// COMPONENTS
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class HireMe extends AppCompatActivity {
    private TextView hireme_name, hireme_mail, hireme_no;
    private EditText nameInput, mailInput, noInput;
    private Button hireme_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hire_me);

        //HireMe_Button - Navigation
        hireme_submit = findViewById(R.id.hireme_submit);
        hireme_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HireMe.this, "Submitting.....", Toast.LENGTH_SHORT).show();
            }
        });
    }
}