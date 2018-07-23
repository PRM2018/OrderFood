package com.prm.orderfood.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.prm.orderfood.Adapter.ListEmployeeAdapter;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Model.EmployeeModel;
import com.prm.orderfood.R;

import java.util.ArrayList;

public class ManageEmployee extends android.support.v4.app.Fragment {
    ListView lv_employee;
    Button bt_to_addEmployee;
    Button btnDelete;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.manage_employee, container, false);
        lv_employee = view.findViewById(R.id.lv_employee);
        ArrayList<Employee> listEmployee = new ArrayList<>();
        EmployeeModel em = new EmployeeModel();
//        try {
//            listEmployee=em.listAllEmployee();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //Show list Employee
//        ArrayAdapter<Employee> arrayAdapter=new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,listEmployee);
//        lv_employee.setAdapter(arrayAdapter);
//        final ArrayList<Employee> finalListEmployee = listEmployee;
//        lv_employee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // Set when click each Employee
//                Intent intent=new Intent(view.getContext(),EditEmployeeInfoActivity.class);
//                int eId= finalListEmployee.get(position).geteId();
//                intent.putExtra("eId",eId);
//                startActivity(intent);
//            }
//        });
//        // Go to add employee activity
//        bt_to_addEmployee=view.findViewById(R.id.bt_to_addEmployee);
//        bt_to_addEmployee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(view.getContext(), AddEmployeeActivity.class);
//                startActivity(intent);
//            }
//        });
        listEmployee = em.getAllEmpForAdmin();
        ListEmployeeAdapter empAdapter = new ListEmployeeAdapter(getContext(), R.layout.item_list_employee, listEmployee);
        lv_employee.setAdapter(empAdapter);
        return view;
    }


}
