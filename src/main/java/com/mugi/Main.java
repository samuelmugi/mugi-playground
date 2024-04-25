package com.mugi;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
var credentials="DDHuzl46RADx3uEveInZhn4CgaX9dLQDykaYU4XZqYxA51TA:AQCZe8s2AIkJ2ewl5LIRch40AxuW6vwlzjd064VLGKlVK2eSjszdxAd5fGNgU7dN";
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
         OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .method("GET", null)
                .addHeader("Authorization", "Basic "+encodedCredentials)
                .build();
        try {
            Response response = client.newCall(request).execute();
      System.out.println("Response:---"+response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}