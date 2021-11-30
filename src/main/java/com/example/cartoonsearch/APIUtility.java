package com.example.cartoonsearch;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method will read the file called "jsonData" in the root
     * of the project and create an ApiResponse object
     */
    public static APIResponse getMoviesJsonFile()
    {
        //create a GSON object
        Gson gson = new Gson();
        APIResponse response = null;

        try(
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * This will call the OMDB api with the specified search term
     */
    public static APIResponse getCartoonsFromOMDB(String searchTerm) throws IOException, InterruptedException {
        searchTerm = searchTerm.trim().replace(" ", "%20");

        String uri = "https://api.jikan.moe/v3/search/anime?q="+searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this sends the result from the API to a file
//        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
//                                                                .BodyHandlers
//                                                                .ofFile(Paths.get("jsonData.json")));
//        return getMoviesJsonFile();

        //this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());



        String jsonString =response.body();

        Gson gson = new Gson();
        APIResponse apiResponse = null;

        try{
            apiResponse  = gson.fromJson(jsonString, APIResponse.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }


    /**
     * This will call the OMDB api with the specified search term
     */
    public static CartoonDetails getCartoonDetails(String malId) throws IOException, InterruptedException {
        malId = malId.trim().replace(" ", "%20");

        String uri = "https://api.jikan.moe/v3/search/anime?i="+malId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), CartoonDetails.class);
    }
}

