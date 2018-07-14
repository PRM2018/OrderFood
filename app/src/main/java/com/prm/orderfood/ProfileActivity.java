package com.prm.orderfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private EditText etAddress;
    private EditText etPhone;
    private Spinner spRole;

    private final String[] roles = { "Admin", "Waiter", "Cooker" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        setup();
    }

    private void init() {
        etAddress = findViewById(R.id.et_user_address);
        etPhone = findViewById(R.id.et_user_phone);
        spRole = findViewById(R.id.sp_user_role);

        Log.d(TAG, etAddress.getText().toString());
        Log.d(TAG, etPhone.getText().toString());

        etAddress.setText(R.string.temp_address);
        etPhone.setText(R.string.temp_phone);
    }

    private void setup() {
        // Data for spinner
//        HashMap<Integer, String> spinnerMap = new HashMap<>();
//        for (int i = 0; i < 3; i++) {
//            spinnerMap.put(i + 1, roles[i]);
//        }
        SparseArray<String> spinnerArray = new SparseArray<>();
        for (int i = 0; i < 3; i++) {
            spinnerArray.put(i + 1, roles[i]);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spRole.setAdapter(adapter);

        // Setup view
        int role = getIntent().getIntExtra("ROLE", 1);
        spRole.setSelection(role - 1);
        switch (role) {
            case 1:
                disableView(etAddress, etPhone);
                enableView(spRole);
                break;
            default:
                enableView(etAddress, etPhone);
                disableView(spRole);
        }

        findViewById(R.id.btn_profile_save).setOnClickListener(v -> finish());
        findViewById(R.id.btn_profile_cancel).setOnClickListener(v -> finish());
    }

    private void enableView(View... views) {
        for (View view : views) {
            view.setEnabled(true);
            if(!(view instanceof Spinner)) {
                view.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }
        }
    }

    private void disableView(View... views) {
        for (View view : views) {
            view.setEnabled(false);
            if(!(view instanceof Spinner)) {
                view.setBackgroundColor(getResources().getColor(R.color.colorGray));
            }
        }
    }
}
