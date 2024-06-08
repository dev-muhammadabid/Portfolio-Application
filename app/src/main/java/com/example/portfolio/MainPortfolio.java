package com.example.portfolio;

import android.os.Bundle;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;

//COMPONENTS
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainPortfolio extends AppCompatActivity {

    public TextView text_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_portfolio);

        //Main_Activity_Name - Style
        text_name = findViewById(R.id.text_name);
        String styledText = "<font color=\"#ffffff\">Muhammad</font> <font color=\"#008000\">Abid</font>";
        text_name.setText(Html.fromHtml(styledText, Html.FROM_HTML_MODE_LEGACY));

    }
}