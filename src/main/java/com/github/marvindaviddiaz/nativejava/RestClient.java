package com.github.marvindaviddiaz.nativejava;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RestClient {

    private static final Logger logger = Logger.getLogger(RestClient.class.getName());

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public void test() throws IOException, InterruptedException {
        logger.info("Http calls");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        logger.log(Level.INFO, "Status Code: {0}", response.statusCode());
        logger.log(Level.INFO, "Body: {0}", response.body());

    }
}
