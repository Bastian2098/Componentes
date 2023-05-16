package com.taller.cinemateca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.taller.cinemateca.models.User;
import com.taller.cinemateca.utils.MySQLConnection;

public class RegisterActivity extends AppCompatActivity {

    private EditText fieldName, fieldLastName, fieldEmail, fieldPass;
    private User user;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fieldName = findViewById(R.id.fieldName);
        fieldLastName = findViewById(R.id.fieldLastName);
        fieldEmail = findViewById(R.id.fieldEmailRegister);
        fieldPass = findViewById(R.id.fieldPassRegister);
        Button buttonRegister = findViewById(R.id.buttonRegister);
        MySQLConnection connection = new MySQLConnection();
        buttonRegister.setOnClickListener(view -> {
            intent = new Intent(RegisterActivity.this, MainActivity.class);
            user = new User(fieldName.getText().toString(), fieldLastName.getText().toString(), fieldEmail.getText().toString(), fieldPass.getText().toString());
            connection.executeInsert(user.register());
        });
    }

}