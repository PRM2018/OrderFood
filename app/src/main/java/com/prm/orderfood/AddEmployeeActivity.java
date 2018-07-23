package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.List;

import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Role;
import com.prm.orderfood.Model.AccountModel;
import com.prm.orderfood.Model.EmployeeModel;

public class AddEmployeeActivity extends AppCompatActivity {
    Spinner roleSpinner;
    String role="";
    int roleId=1;
    AccountModel am;
    EditText et_employee_name;
    EditText et_employee_phone;
    EditText et_employee_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        Intent intent=getIntent();
        roleSpinner=(Spinner)findViewById(R.id.roleSpinner);
        am=new AccountModel();
        try {

            // Spinner role
            final List<Role> listRole=am.getRoleList();
            ArrayAdapter<Role> adapter=new ArrayAdapter<Role>(this, android.R.layout.simple_spinner_item, listRole);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            roleSpinner.setAdapter(adapter);
            roleSpinner.setSelection(0);
            roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    role=listRole.get(position).getRole();
                    roleId=listRole.get(position).getRoleId();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(View view) throws SQLException {
        String employeeName="";
        String employeeAddress="";
        String employeePhone="";

        et_employee_name=(EditText)findViewById(R.id.et_employee_name);
        et_employee_address=(EditText)findViewById(R.id.et_employee_address);
        et_employee_phone=(EditText)findViewById(R.id.et_employee_phone);

        employeeName=et_employee_name.getText().toString();
        employeeAddress=et_employee_address.getText().toString();
        employeePhone=et_employee_phone.getText().toString();

        Employee e=new Employee(employeeName,employeeAddress,employeePhone,roleId);
        EmployeeModel em=new EmployeeModel();
        em.addEmployee(e);
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }

    public void cancel(View view){
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }
}
