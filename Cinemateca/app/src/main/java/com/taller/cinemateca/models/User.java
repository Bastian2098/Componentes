package com.taller.cinemateca.models;

public class User {

    private String email, pass, name, lastName;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public User(String email, String pass, String name, String lastName) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String logIn() {
        return "SELECT correo, clave FROM administrador, usuario WHERE correo = '" + email + "' AND clave = '" + pass + "'";
    }

    public String register() {
        return "INSERT INTO usuario (correo, clave, nombre, apellido) VALUES ('" + name + "', '" + lastName + "', '" + email + "', '" + pass + "')";
    }

}