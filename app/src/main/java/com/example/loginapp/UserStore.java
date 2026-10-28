package com.example.loginapp;

public class UserStore {
    public static String name = "Daniyal Khaliq";
    public static String username = "user";
    public static String email = "user@example.com";
    public static String password = "Password123";

    public static boolean login(String id, String pass) {
        boolean idOk = id.equalsIgnoreCase(email) || id.equalsIgnoreCase(username);
        return idOk && pass.equals(password);
    }
}