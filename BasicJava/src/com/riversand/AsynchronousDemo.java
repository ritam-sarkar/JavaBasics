package com.riversand;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class AsynchronousDemo {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        AsynchronousDemo caller = new AsynchronousDemo();

        // All run on ForkJoinPool.commonPool() - SINGLE THREAD POOL
        CompletableFuture<String> jsonPlaceholder = caller.callJsonPlaceholder();
        CompletableFuture<String> catFact = caller.callCatFact();

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(jsonPlaceholder, catFact);
        completableFuture = completableFuture.thenRun(() -> {
            try {
                System.out.println("=== JSON Placeholder ===");
                System.out.println(jsonPlaceholder.get());

                System.out.println("\n=== Cat Fact ===");
                System.out.println(catFact.get());

                System.out.println("\n✅ All APIs completed on SINGLE THREAD!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        runOtheCodes();
        completableFuture.join();
        System.out.println("end main");

    }

    private static void runOtheCodes() {
        int i = 0;
        while (i < 20){
            i++;
        }
        System.out.println("Other main codes are executing");
    }

    public CompletableFuture<String> callJsonPlaceholder() {
        // Uses ForkJoinPool.commonPool() - single thread by default
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("JSON on: " + Thread.currentThread());
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                        .GET().build();

                return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        });  // ← NO custom executor = ForkJoinPool.commonPool()
    }

    public CompletableFuture<String> callCatFact() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("CatFact on: " + Thread.currentThread());
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://catfact.ninja/fact"))
                        .GET().build();

                return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        });
    }
}
