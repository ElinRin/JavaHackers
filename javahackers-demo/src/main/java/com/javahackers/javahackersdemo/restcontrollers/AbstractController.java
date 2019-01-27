package com.javahackers.javahackersdemo.restcontrollers;

import com.google.gson.JsonParser;

public class AbstractController {
    protected JsonParser jsonParser = new JsonParser();

    protected String getIdByToken(String token) {
        if (token.equals("2")) {
            return "2";
        } else {
            return null;
        }
    }
}
