package com.prm.orderfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_profile).setOnClickListener(v -> {
            int role = Integer.parseInt(
                    ((EditText) findViewById(R.id.et_user_role)).getText().toString());
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("ROLE", role);
            startActivity(intent);
        });
    }
}
