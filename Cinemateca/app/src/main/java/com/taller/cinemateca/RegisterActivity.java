package com.taller.cinemateca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.taller.cinemateca.models.User;
import com.taller.cinemateca.utils.MySQLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }

    /*@Override
    public void onResponse(JSONArray jsonArray) {
        if (jsonArray != null && jsonArray.length() != 0) {
            // La respuesta contiene datos
            // Puedes realizar el procesamiento necesario aquí
            // Por ejemplo, mostrar los datos en una lista o en campos de texto
            // Ejemplo: Mostrar los elementos del JSONArray en el Log
            try {
                JSONObject item = jsonArray.getJSONObject(0);
                String token = item.getString("idusuario");
                Toast.makeText(getApplicationContext(), token, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // La respuesta está vacía o se produjo un error
            // Puedes mostrar un mensaje de error o tomar cualquier otra acción necesaria
            Log.e("ResponseError", "La respuesta está vacía o se produjo un error");
        }
    }*/

}