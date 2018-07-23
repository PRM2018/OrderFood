package com.prm.orderfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.prm.orderfood.EditEmployeeInfoActivity;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.R;

import java.util.List;

/**
 * Created by Tung Pham on 7/23/2018.
 */

public class ListEmployeeAdapter  extends ArrayAdapter<Employee>{
    private Context context;
    private int resource;
    private List<Employee> arrEmp;

    public ListEmployeeAdapter(@NonNull Context context, int resource, @NonNull List<Employee> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrEmp = arrEmp;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_employee,parent,false);
            viewHolder.empNo = (TextView)convertView.findViewById(R.id.tv_emp_no);
            viewHolder.empName = (TextView)convertView.findViewById(R.id.tv_emp_name);
            viewHolder.empRoleName = (TextView) convertView.findViewById(R.id.tv_emp_role);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Employee emp = (Employee)getItem(position);
        viewHolder.empNo.setText(String.valueOf(emp.geteId()));
        viewHolder.empName.setText(emp.geteName().toString());
        viewHolder.empRoleName.setText(emp.geteRole().toString());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditEmployeeInfoActivity.class);
                intent.putExtra("eId", emp.geteId());
                context.startActivity(intent);
            }
        });

        return convertView;

    }

    public class ViewHolder{
        TextView empNo, empName,empRoleName;
    }
}
