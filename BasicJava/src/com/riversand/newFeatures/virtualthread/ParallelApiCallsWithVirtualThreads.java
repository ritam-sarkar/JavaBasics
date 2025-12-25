package com.riversand.newFeatures.virtualthread;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ParallelApiCallsWithVirtualThreads {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        // Example free APIs (replace with any GET endpoints you like)
        List<String> urls = List.of(
                "https://api.github.com",                   // public GitHub API
                "https://api.spacexdata.com/v4/launches/latest",
                "https://catfact.ninja/fact"
        );

        Map<String, String> responses = callApisInParallel(urls);

        responses.forEach((url, body) -> {
            System.out.println("=== " + url + " ===");
            System.out.println(body.substring(0, Math.min(200, body.length())) + "...");
            System.out.println();
        });
    }

    public static Map<String, String> callApisInParallel(List<String> urls) throws Exception {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // submit one task per URL
            Map<String, Future<String>> futures = urls.stream()
                    .collect(Collectors.toMap(
                            url -> url,
                            url -> executor.submit(() -> fetch(url))
                    ));

            // wait for all and collect results
            Map<String, String> result = new ConcurrentHashMap<>();
            for (var entry : futures.entrySet()) {
                String url = entry.getKey();
                Future<String> future = entry.getValue();
                try {
                    String body = future.get(10, TimeUnit.SECONDS); // timeout per call
                    result.put(url, body);
                } catch (TimeoutException e) {
                    future.cancel(true);
                    result.put(url, "Timed out");
                }
            }
            return result;
        }
    }

    private static String fetch(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
