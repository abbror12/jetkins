package org.example.jetkins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @Test
    void add() throws IOException, InterruptedException {
        int a=4;
        int b=12;
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://localhost:8081/add?a=%d&b=%d".formatted(a, b)))
                .GET()
                .build();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = send.body();
        int answer = Integer.parseInt(body);
        Assertions.assertEquals(a+b, answer);
    }
}