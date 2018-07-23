package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.prm.orderfood.Entity.Food;
import com.prm.orderfood.Model.FoodModel;

import java.sql.SQLException;

public class AddFoodActivity extends AppCompatActivity {
    EditText et_food_name;
    EditText et_food_quantity;
    EditText et_food_price;
    EditText et_food_img;
    EditText et_food_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        Intent intent = getIntent();

        et_food_name = findViewById(R.id.et_employee_name);
        et_food_quantity = findViewById(R.id.et_food_quantity);
        et_food_price = findViewById(R.id.et_food_price);
        et_food_img = findViewById(R.id.et_food_img);
        et_food_des = findViewById(R.id.et_food_des);
    }

    public void addNewFood(View view) throws SQLException {
        try {
            String fName = et_food_name.getText().toString();
            int fQuantity = Integer.parseInt(et_food_quantity.getText().toString());
            Float fPrice = Float.parseFloat(et_food_price.getText().toString());
            String fImg = et_food_img.getText().toString();
            String fDes = et_food_des.getText().toString();
            Food food = new Food(fName, fPrice, fQuantity, fImg, fDes);
            FoodModel fm = new FoodModel();
            fm.addFood(food);
            Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
            startActivity(intent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancel(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }


}
