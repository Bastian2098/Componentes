package com.taller.cinemateca.models;

public class User {

    private String email, pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String logIn() {
        return "SELECT correo, clave FROM administrador WHERE correo = '" + email + "' AND clave = '" + pass + "'";
    }
}