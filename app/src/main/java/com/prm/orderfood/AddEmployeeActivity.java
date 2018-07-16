package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Employee;
import Entity.Role;
import Model.AccountModel;

public class AddEmployeeActivity extends AppCompatActivity {
    Spinner roleSpinner;
    String role="";
    int roleId=1;
    AccountModel am;
    EditText txtName;
    EditText txtPhone;
    EditText txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        Intent intent=getIntent();
        roleSpinner=(Spinner)findViewById(R.id.roleSpinner);
        am=new AccountModel();
        try {
            final List<Role> listRole=am.getRoleList();

            ArrayAdapter<Role> adapter=new ArrayAdapter<Role>(this, android.R.layout.simple_spinner_item, listRole);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            roleSpinner.setAdapter(adapter);
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

    public void saveEmployee(View view) throws SQLException {
        String name="";
        String address="";
        String phone="";

//        //Check Account exist
//        txtAcc=(EditText)findViewById(R.id.txtAcc);
//        account=txtAcc.getText().toString();
//        am=new AccountModel();
//        boolean checkAccountExist=am.checkAccountExisted(account);
//        if(checkAccountExist==true){
//            Toast.makeText(this,"Account exsited",Toast.LENGTH_LONG).show();
//            return;
//        }
//        txtPass=(EditText)findViewById(R.id.txtPass);

        txtName=(EditText)findViewById(R.id.txtName);
        txtAddress=(EditText)findViewById(R.id.txtAddress);
        txtPhone=(EditText)findViewById(R.id.txtPhone);

        name=txtName.getText().toString();
        address=txtAddress.getText().toString();
        phone=txtPhone.getText().toString();

        Employee e=new Employee(name,address,phone,roleId);
        AccountModel am=new AccountModel();
        am.addEmployee(e);
        Toast.makeText(this,"Done !!!!!!!!",Toast.LENGTH_LONG).show();
    }
}
