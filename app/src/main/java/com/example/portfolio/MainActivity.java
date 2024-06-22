package com.example.portfolio;

//IMPORT
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;

//COMPONENTS
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

//MAIN
public class MainActivity extends AppCompatActivity {
    private TextView text_name;
    private Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Main_Activity_Name - Style
        text_name = findViewById(R.id.text_name);
        String styledText = "<font color=\"#ffffff\">Muhammad</font> <font color=\"#008000\">Abid</font>";
        text_name.setText(Html.fromHtml(styledText, Html.FROM_HTML_MODE_LEGACY));

        //Main_Activity_Button - Navigation
        getStartedBtn = findViewById(R.id.getStartedBtn);
        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainPortfolio.class);
                startActivity(intent);
            }
        });

    }
}