package com.prm.orderfood.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.prm.orderfood.R;

public class TableDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);

        Intent intent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            int tableId = intent.getIntExtra("TableID", 1);
            String tableName = intent.getStringExtra("TableName");
            actionBar.setTitle(tableId + ". " + tableName);
        }
    }
}
