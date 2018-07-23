package com.prm.orderfood.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.prm.orderfood.AddEmployeeActivity;
import com.prm.orderfood.AddFoodActivity;
import com.prm.orderfood.EditFoodInfoActivity;
import com.prm.orderfood.Entity.Food;
import com.prm.orderfood.Model.FoodModel;
import com.prm.orderfood.R;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageFood  extends android.support.v4.app.Fragment  {
    ListView lv_food;
    Button bt_to_addFood;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.manage_food, container, false);
        lv_food=view.findViewById(R.id.lv_food);
        ArrayList<Food>listFood=new ArrayList<>();
        FoodModel fm=new FoodModel();
        try {
            listFood=fm.listAllFood();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Show list food
        ArrayAdapter<Food> arrayAdapter=new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,listFood);
        lv_food.setAdapter(arrayAdapter);
        final ArrayList<Food> finalListFood = listFood;
        lv_food.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // When click each food
                Intent intent=new Intent(view.getContext(),EditFoodInfoActivity.class);
                int fId=finalListFood.get(position).getfId();
                intent.putExtra("fId",fId);
                startActivity(intent);
            }
        });

        //Go to add food activity
        bt_to_addFood=view.findViewById(R.id.bt_to_addFood);
        bt_to_addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), AddFoodActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
