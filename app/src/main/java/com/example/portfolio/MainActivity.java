package com.example.portfolio;

//IMPORT
import android.os.Bundle;
import android.widget.TextView;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;


//MAIN
public class MainActivity extends AppCompatActivity {

    public TextView text_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FrontPage_Name - Style
        text_name = findViewById(R.id.text_name);
        String styledText = "<font color=\"#ffffff\">Muhammad</font> <font color=\"#008000\">Abid</font>";
        text_name.setText(Html.fromHtml(styledText, Html.FROM_HTML_MODE_LEGACY));



    }
}