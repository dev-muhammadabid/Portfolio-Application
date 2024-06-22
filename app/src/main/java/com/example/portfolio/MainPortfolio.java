package com.example.portfolio;

import android.os.Bundle;
import android.text.Html;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

// COMPONENTS
import android.widget.TextView;

public class MainPortfolio extends AppCompatActivity {
    private TextView text_name;
    private RecyclerView techListRecyclerView;
    private RecyclerView eduListRecyclerView;
    private RecyclerView.Adapter techListAdapter;
    private RecyclerView.Adapter eduListAdapter;
    private List<TechItem> techList;
    private List<EduItem> eduList;
    private RecyclerView.LayoutManager techListLayoutManager;
    private RecyclerView.LayoutManager eduListLayoutManager;

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
        techListRecyclerView.setHasFixedSize(true);
        eduListRecyclerView.setHasFixedSize(true);

        // Use a linear layout manager
        techListLayoutManager = new LinearLayoutManager(this);
        eduListLayoutManager = new LinearLayoutManager(this);
        techListRecyclerView.setLayoutManager(techListLayoutManager);
        eduListRecyclerView.setLayoutManager(eduListLayoutManager);

        // Initialize lists
        techList = new ArrayList<>();
        eduList = new ArrayList<>();

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
        eduList.add(new EduItem(R.drawable.edulogo, "Bachelor's", "BCA | 2020 - 2023", "https://example.com/edu2"));
        eduList.add(new EduItem(R.drawable.edulogo, "Master's", "MCA | 2023 - 2025", "https://example.com/edu1"));
        // Add more edu items as needed

        // Set adapters
        techListAdapter = new TechListAdapter(techList, this);
        eduListAdapter = new EduListAdapter(eduList, this);
        techListRecyclerView.setAdapter(techListAdapter);
        eduListRecyclerView.setAdapter(eduListAdapter);
    }
}
