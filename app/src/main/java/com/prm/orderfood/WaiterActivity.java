package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WaiterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);

        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent();
        int role = intent.getIntExtra("ROLE", 1);
        String name = intent.getStringExtra("EMP_NAME");
        if(actionBar != null) {
            switch (role) {
                case 1:
                    actionBar.setTitle("Admin: " + name);
                    break;
                case 2:
                    actionBar.setTitle("Waiter: " + name);
                    break;
                case 3:
                    actionBar.setTitle("Cooker: " + name);
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            // Push data into intent to ProfileActivity
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
