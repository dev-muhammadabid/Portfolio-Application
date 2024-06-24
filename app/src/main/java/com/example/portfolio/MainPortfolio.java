//Main PACKAGE
package com.example.portfolio;

//All IMPORTS
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

// COMPONENTS
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainPortfolio extends AppCompatActivity {
    private TextView text_name;
    private RecyclerView techListRecyclerView;
    private RecyclerView eduListRecyclerView;
    private RecyclerView certifiListRecyclerView;
    private RecyclerView.Adapter techListAdapter;
    private RecyclerView.Adapter eduListAdapter;
    private RecyclerView.Adapter certifiListAdapter;
    private List<TechItem> techList;
    private List<EduItem> eduList;
    private List<CertifiItem> certifiList;
    private RecyclerView.LayoutManager techListLayoutManager;
    private RecyclerView.LayoutManager eduListLayoutManager;
    private RecyclerView.LayoutManager certifiListLayoutManager;
    private Button hireMeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_portfolio);

        // Main_Activity_Name - Style
        text_name = findViewById(R.id.text_name);
        String styledText = "<font color=\"#ffffff\">Muhammad</font> <font color=\"#008000\">Abid</font>";
        text_name.setText(Html.fromHtml(styledText, Html.FROM_HTML_MODE_LEGACY));

        // RecyclerView setup
        techListRecyclerView = findViewById(R.id.tech_list);
        eduListRecyclerView = findViewById(R.id.edu_list);
        certifiListRecyclerView = findViewById(R.id.certifi_list);
        techListRecyclerView.setHasFixedSize(true);
        eduListRecyclerView.setHasFixedSize(true);
        certifiListRecyclerView.setHasFixedSize(true);

        // Use a linear layout manager
        techListLayoutManager = new LinearLayoutManager(this);
        eduListLayoutManager = new LinearLayoutManager(this);
        certifiListLayoutManager = new LinearLayoutManager(this);
        techListRecyclerView.setLayoutManager(techListLayoutManager);
        eduListRecyclerView.setLayoutManager(eduListLayoutManager);
        certifiListRecyclerView.setLayoutManager(certifiListLayoutManager);

        // Initialize lists
        techList = new ArrayList<>();
        eduList = new ArrayList<>();
        certifiList = new ArrayList<>();

        // Tech Stack items here
        techList.add(new TechItem(R.drawable.android, "Android", "https://source.android.com/docs"));
        techList.add(new TechItem(R.drawable.java, "JAVA", "https://overapi.com/java"));
        techList.add(new TechItem(R.drawable.js, "JavaScript", "https://overapi.com/javascript"));
        techList.add(new TechItem(R.drawable.xml, "XML", "https://overapi.com/xml"));
        techList.add(new TechItem(R.drawable.mysql, "MySQL", "https://overapi.com/sql"));
        techList.add(new TechItem(R.drawable.git, "Git", "https://overapi.com/git"));
        techList.add(new TechItem(R.drawable.github, "Github", "https://docs.github.com/en"));
        techList.add(new TechItem(R.drawable.linux, "Linux", "https://overapi.com/linux"));
        techList.add(new TechItem(R.drawable.agile, "Agile", "https://www.atlassian.com/agile"));

        // Edu Stack items here
        eduList.add(new EduItem(R.drawable.edulogo, "Master's", "MCA | 2023 - 2025", "https://muhammadabid.me/Images/AD.png"));
        eduList.add(new EduItem(R.drawable.edulogo, "Bachelor's", "BCA | 2020 - 2023", "https://muhammadabid.me/Images/BCA_Degree.jpg"));

        // Certifi Stack items here
        certifiList.add(new CertifiItem(R.drawable.cisco, "Cisco", "Mobile App Development", "https://thingqbator.nasscomfoundation.org/certificate/CQkn2KjWljJzgi55"));
        certifiList.add(new CertifiItem(R.drawable.accenture, "Accenture", "Mobile", "https://google.com/"));
        certifiList.add(new CertifiItem(R.drawable.accenture, "Accenture", "User Experience", "https://google.com/"));
        certifiList.add(new CertifiItem(R.drawable.meta, "Meta", "Introduction to Back-End", "https://google.com/"));
        certifiList.add(new CertifiItem(R.drawable.infosys, "Infosys", "Agile Development", "https://google.com/"));

        // Set adapters
        techListAdapter = new TechListAdapter(techList, this);
        eduListAdapter = new EduListAdapter(eduList, this);
        certifiListAdapter = new CertifiListAdapter(certifiList, this);
        techListRecyclerView.setAdapter(techListAdapter);
        eduListRecyclerView.setAdapter(eduListAdapter);
        certifiListRecyclerView.setAdapter(certifiListAdapter);

        //HireMe_Button - Navigation
        hireMeBtn = findViewById(R.id.hireMeBtn);
        hireMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPortfolio.this, HireMe.class);
                startActivity(intent);
            }
        });
    }
}
