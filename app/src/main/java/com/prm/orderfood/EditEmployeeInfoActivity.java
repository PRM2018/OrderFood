package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Role;
import com.prm.orderfood.Model.AccountModel;
import com.prm.orderfood.Model.EmployeeModel;

import java.sql.SQLException;
import java.util.List;

public class EditEmployeeInfoActivity extends AppCompatActivity {
    int eId = 0;
    int roleId = 0;
    EditText et_employee_name;
    EditText et_employee_address;
    EditText et_employee_phone;
    Spinner sp_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_info);

        try {
            Intent intent = getIntent();
            eId = intent.getIntExtra("eId", 0);

            Employee employee = new Employee();
            EmployeeModel em = new EmployeeModel();

            employee = em.employeeById(eId);


            String eName = employee.geteName();
            String ePhone = employee.getePhone();
            String eAddress = employee.geteAddress();
            roleId = employee.getRoleId();

            et_employee_name = findViewById(R.id.et_employee_name);
            et_employee_address = findViewById(R.id.et_employee_address);
            et_employee_phone = findViewById(R.id.et_employee_phone);
            et_employee_phone.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL); // Bắt nhập số


            et_employee_name.setText(eName);
            et_employee_phone.setText(ePhone);
            et_employee_address.setText(eAddress);

            // Spinner
            sp_role = findViewById(R.id.sp_role);
            AccountModel am = new AccountModel();
            final List<Role> listRole = am.getRoleList();
            ArrayAdapter<Role> adapter = new ArrayAdapter<Role>(this, android.R.layout.simple_spinner_item, listRole);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            sp_role.setAdapter(adapter);
            sp_role.setSelection(roleId - 1); // When start page
            sp_role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    roleId = listRole.get(position).getRoleId(); // When change in spinner
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void cancel(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }

    public void DeleteEmployee(View view) throws SQLException {
        try {
            EmployeeModel fm = new EmployeeModel();
            fm.deleteEmployee(eId);
            Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
            startActivity(intent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EditEmployee(View view) throws SQLException {

        String eName = et_employee_name.getText().toString();
        String ePhone = et_employee_phone.getText().toString();
        String eAddress = et_employee_address.getText().toString();

        Employee employee = new Employee(eId, eName, eAddress, ePhone, roleId);
        EmployeeModel em = new EmployeeModel();
        em.editEmployee(employee);
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }
}
