package com.taller.cinemateca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taller.cinemateca.models.User;
import com.taller.cinemateca.utils.MySQLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements MySQLConnection.JSONResponseListener {

    private User user;
    private TextView labelInfoLogin;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText fieldEmail = findViewById(R.id.fieldEmailRegister);
        EditText fieldPassword = findViewById(R.id.fieldPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        labelInfoLogin = findViewById(R.id.labelInfoLogin);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);
        MySQLConnection connection = new MySQLConnection(this);
        buttonLogin.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, MenuActivity.class);
            user = new User(fieldEmail.getText().toString(), fieldPassword.getText().toString());
            connection.executeQuery(user.logIn());
        });
        buttonSignUp.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onResponse(JSONArray jsonArray) {
        if (jsonArray != null) {
            // La respuesta contiene datos
            // Puedes realizar el procesamiento necesario aquí
            // Por ejemplo, mostrar los datos en una lista o en campos de texto
            // Ejemplo: Mostrar los elementos del JSONArray en el Log
            try {
                JSONObject item = jsonArray.getJSONObject(0);
                String emailConsulted = item.getString("correo");
                String passConsulted = item.getString("clave");
                if (emailConsulted.equals(user.getEmail()) && passConsulted.equals(user.getPass())) {
                    labelInfoLogin.setText("INICIO SESION");
                    startActivity(intent);
                    Log.i("INFORMACION FUNCIONAL", "Inicia sesion");
                } else {
                    labelInfoLogin.setText("NO INICIO SESION");
                    Log.i("INFORMACION FUNCIONAL", "No inicia sesion");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // La respuesta está vacía o se produjo un error
            // Puedes mostrar un mensaje de error o tomar cualquier otra acción necesaria
            Log.e("ResponseError", "La respuesta está vacía o se produjo un error");
        }
    }

}