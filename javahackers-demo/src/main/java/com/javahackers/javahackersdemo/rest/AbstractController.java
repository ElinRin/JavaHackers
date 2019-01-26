package com.javahackers.javahackersdemo.rest;

public class AbstractController {
    protected String getIdByToken(String token) {
        if (token.equals("2")) {
            return "2";
        } else {
            return null;
        }
    }
}
