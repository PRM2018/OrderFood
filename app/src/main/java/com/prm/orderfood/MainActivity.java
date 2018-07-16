package com.prm.orderfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import Entity.Account;
import Model.AccountModel;

public class MainActivity extends AppCompatActivity {
    EditText txtAcc;
    EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check(View view) throws SQLException {
        txtAcc=(EditText)findViewById(R.id.txtAcc);
        txtPass=(EditText)findViewById(R.id.txtPass);

        String acc=txtAcc.getText().toString();
        String pass=txtPass.getText().toString();

        AccountModel am=new AccountModel();
        boolean checkExit=am.checkAccountAndPass(acc,pass);
        if(checkExit==true){
            int checkRole=am.checkRole(acc,pass);
            if(checkRole==1) {
                Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                startActivity(intent);
            }
            if(checkRole==2) {
                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                startActivity(intent);
            }
        }
        if(checkExit==false){
            Toast.makeText(this,"This Account didn't exist please check again",Toast.LENGTH_LONG).show();
        }

    }
}
