package com.microsoft.bing.rest;

// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

/*
 * Gson: https://github.com/google/gson
 * Maven info:
 *     groupId: com.google.code.gson
 *     artifactId: gson
 *     version: 2.8.1
 *
 * Once you have compiled or downloaded gson-2.8.1.jar, assuming you have placed it in the
 * same folder as this file (BingImageSearch.java), you can compile and run this program with the following steps:
 * 1. create three directories, named "bin", "src", and "lib"
 * 2. place this .java file in "src"
 * 3. download the latest gson .jar file online, and place it in the "lib" folder
 * 4. replace the subscriptionKey value with your valid Bing subscription key
 * 5. run the following commands, replacing "lib/gson-2.8.5.jar" with your .jar file:
 * javac -d bin -sourcepath src -cp lib/gson-2.8.5.jar src/BingImageSearchv7.java
 * java -cp bin;lib/gson-2.8.5.jar BingImageSearchv7
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

public class BingImageSearchv7 {

// ***********************************************
// *** Update or verify the following values. ***
// **********************************************

    // Add your Bing Search V7 subscription key to your environment variables.
    static String subscriptionKey = System.getenv("BING_SEARCH_V7_SUBSCRIPTION_KEY");

    // Add your Bing Search V7 endpoint to your environment variables.
    static String host = System.getenv("BING_SEARCH_V7_ENDPOINT");
    static String path = "/v7.0/images/search";

    static String searchTerm = "tropical ocean";

    public static SearchResults SearchImages (String searchQuery) throws Exception {
        // construct URL of search request (endpoint + query string)
        URL url = new URL(host + path + "?q=" +  URLEncoder.encode(searchQuery, "UTF-8"));
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);

        // receive JSON body
        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        // construct result object for return
        SearchResults results = new SearchResults(new HashMap<String, String>(), response);

        // extract Bing-related HTTP headers
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (String header : headers.keySet()) {
            if (header == null) continue;      // may have null key
            if (header.startsWith("BingAPIs-") || header.startsWith("X-MSEdge-")) {
                results.relevantHeaders.put(header, headers.get(header).get(0));
            }
        }

        stream.close();
        return results;
    }

    // pretty-printer for JSON; uses GSON parser to parse and re-serialize
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    public static void main (String[] args) {
        if (subscriptionKey.length() != 32) {
            System.out.println("Invalid Bing Search API subscription key!");
            System.out.println("Please paste yours into the source code.");
            System.exit(1);
        }

        try {
            System.out.println("Searching the Web for: " + searchTerm);

            SearchResults result = SearchImages(searchTerm);
            //uncomment this section to see the HTTP headers
            /*
            System.out.println("\nRelevant HTTP Headers:\n");
            for (String header : result.relevantHeaders.keySet())
            System.out.println(header + ": " + result.relevantHeaders.get(header));
            */

            System.out.println("\nJSON Response:\n");
            //parse the jseon
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(result.jsonResponse).getAsJsonObject();
            //get the first image result from the JSON object, along with the total 
            //number of images returned by the Bing Image Search API. 
            String total = json.get("totalEstimatedMatches").getAsString();
            JsonArray results = json.getAsJsonArray("value");
            JsonObject first_result = (JsonObject)results.get(0);
            String resultURL = first_result.get("thumbnailUrl").getAsString();

            System.out.println("\nThe total number of images found: "+ total +"\n");
            System.out.println("\nThe thumbnail URL to the first image search URL: "+ resultURL +"\n");

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(1);
        }
    }
}