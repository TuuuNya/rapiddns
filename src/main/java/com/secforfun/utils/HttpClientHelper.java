package com.secforfun.utils;

import com.secforfun.exception.RapiddnsException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientHelper {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String sendGetRequest(String url) {
        HttpRequest request;

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RapiddnsException("Invalid URL: " + url, e);
        }

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RapiddnsException("Failed to send GET request to " + url, e);
        }

        if (response.statusCode() != 200) {
            throw new RapiddnsException("HTTP request failed with status code " + response.statusCode());
        }

        return response.body();
    }
}