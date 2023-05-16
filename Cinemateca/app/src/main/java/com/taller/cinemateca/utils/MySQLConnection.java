package com.taller.cinemateca.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MySQLConnection {

    private static final String BASE_URL = "http://192.168.0.8/Connection/connection.php";
    private static final String QUERY_PARAM = "query";

    private JSONResponseListener responseListener;

    public MySQLConnection(JSONResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    public MySQLConnection() { }

    public void executeQuery(String query) {
        String urlWithParams = BASE_URL + "?" + QUERY_PARAM + "=" + query;
        new QueryTask().execute(urlWithParams);
    }

    private class QueryTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(String... urls) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Leer la respuesta del servidor
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Procesar la respuesta del servidor
                String result = response.toString();
                return new JSONArray(result);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(JSONArray result) {
            if (result != null) {
                responseListener.onResponse(result);
            } else {
                Log.e("QueryError", "Error al ejecutar la consulta");
            }
        }
    }

    public interface JSONResponseListener {
        void onResponse(JSONArray jsonArray);
    }

    public void executeInsert(String query) {
        new InsertTask().execute(query);
    }

    private class InsertTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String query = params[0];
            String urlWithParams = BASE_URL + "?" + QUERY_PARAM + "=" + query;

            try {
                URL url = new URL(urlWithParams);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Leer la respuesta del servidor
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Procesar la respuesta del servidor
                String result = response.toString();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null && result.equals("{\"success\":true}")) {
                // La inserción se realizó correctamente
                Log.i("InsertStatus", "Inserción exitosa");
            } else {
                // Ocurrió un error durante la inserción
                Log.e("InsertError", "Error en la inserción");
            }
        }
    }

}