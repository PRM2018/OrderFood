package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.prm.orderfood.Entity.Food;
import com.prm.orderfood.Model.FoodModel;

import java.sql.SQLException;

public class EditFoodInfoActivity extends AppCompatActivity {
    EditText et_name;
    EditText et_price;
    EditText et_quantity;
    EditText et_img;
    EditText et_description;
    int fId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        try {
            Intent intent = getIntent();
            fId = intent.getIntExtra("fId", 0);

            FoodModel fm = new FoodModel();
            Food food = fm.foodById(fId);
;
            et_name = findViewById(R.id.et_food_name);
            et_price = findViewById(R.id.et_food_price);
            et_quantity = findViewById(R.id.et_food_quantity);
            et_img = findViewById(R.id.et_food_img);
            et_description = findViewById(R.id.et_food_des);

            et_name.setText(food.getfName());
            et_price.setText("" + food.getfPrice());
            et_price.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            et_quantity.setText("" + food.getfQuantity());
            et_quantity.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
            et_description.setText(food.getfDes());
            et_img.setText(food.getfImg());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EditFood(View view) throws SQLException {
        String fName = et_name.getText().toString();
        Float fPrice = Float.parseFloat(et_price.getText().toString());
        int fQuantity = Integer.parseInt(et_quantity.getText().toString());
        String fImg = et_img.getText().toString();
        String fDes = et_description.getText().toString();

        Food foodEdit = new Food(fId, fName, fPrice, fQuantity, fImg, fDes);
        FoodModel fm = new FoodModel();
        fm.editFood(foodEdit);
        Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
        startActivity(intent);
    }

    public void DeleteFood(View view) throws SQLException {
        FoodModel fm = new FoodModel();
        try {
            fm.deleteFood(fId);
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
