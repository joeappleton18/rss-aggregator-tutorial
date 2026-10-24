package com.rss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> urls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("feeds.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                urls.add(line);
            }
            br.close();

        } catch (Exception e) {
            System.err.println("Failed to read feeds.txt: " + e.getMessage());
        }

        FeedReader feedReader = new FeedReader(urls);
        System.out.println(feedReader);
    }
}
