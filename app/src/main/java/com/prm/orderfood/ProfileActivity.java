package com.prm.orderfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

import DAO.EmployeeDAO;
import Entity.Employee;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private EditText etAddress;
    private EditText etPhone;
    private TextView etUserID;
    private TextView etEmpName;
    private Spinner spRole;
    private EmployeeDAO empDAO;
    private int empRole;

    private final String[] roles = { "Admin", "Waiter", "Cooker" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        setup();
    }

    private void init() {
        int empID = getIntent().getIntExtra("empID", 1);
        Employee emp = new Employee();
        emp = empDAO.getEmployeeProfile(empID);

        etAddress = findViewById(R.id.et_user_address);
        etPhone = findViewById(R.id.et_user_phone);
        spRole = findViewById(R.id.sp_user_role);
        etUserID  = findViewById(R.id.tv_user_id);
        etEmpName = findViewById(R.id.tv_user_name);


        Log.d(TAG, etAddress.getText().toString());
        Log.d(TAG, etPhone.getText().toString());

        etAddress.setText(emp.getEmpAddress().toString());
        etPhone.setText(emp.getEmpPhone().toString());
        etUserID.setText(emp.getEmpID());
        etEmpName.setText(emp.getEmpName().toString());
        empRole = emp.getEmpRole();
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
        //int empID = getIntent().getIntExtra("empID", 1);
        spRole.setSelection(empRole - 1);
        switch (empRole) {
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
