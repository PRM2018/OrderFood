package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import com.prm.orderfood.Adapter.WaiterTableAdapter;
import com.prm.orderfood.DAO.EmployeeDAO;
import com.prm.orderfood.DAO.TableDAO;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Table;

public class WaiterActivity extends AppCompatActivity {
    private int empID;
    private Employee emp;
    private EmployeeDAO empDAO;
    private TableDAO tableDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        emp = new Employee();
        empDAO = new EmployeeDAO();
        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent();
        empID = intent.getIntExtra("empID", 1);
        emp = empDAO.getEmployeeProfile(empID);
        String name = emp.getEmpName().toString();
        int roleID = emp.getEmpRole();
        if(actionBar != null) {
            switch (roleID) {
                case 1:
                    actionBar.setTitle("Admin: " + name);
                    break;
                case 2:
                    setTableAdapter();
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
            intent.putExtra("empID", empID);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTableAdapter(){
        ListView listView = (ListView)findViewById(R.id.lv_table_list);
        tableDAO = new TableDAO();
        ArrayList<Table> arrTable = new ArrayList<>();
        arrTable = tableDAO.getAllTableInfo();
        WaiterTableAdapter tableAdapter = new WaiterTableAdapter(this,R.layout.item_table,arrTable);
        listView.setAdapter(tableAdapter);
    }
}
