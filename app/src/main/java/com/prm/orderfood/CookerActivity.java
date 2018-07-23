package com.prm.orderfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CookerActivity extends AppCompatActivity {

    private ListView lvTableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooker);

        lvTableList = findViewById(R.id.lv_table_list);
    }
}
