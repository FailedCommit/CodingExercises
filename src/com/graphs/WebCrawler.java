package com.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
  
  public void crawl(String root) {
    List<String> discoveredWebsites = new ArrayList<>();
    Queue<String> q = new LinkedList<>();
    q.add(root);
    
    while(!q.isEmpty()) {
      String url = q.poll();
      
      String rawHTML = readURL(url);
      String regex = "(http|https)://(\\w+\\.)*(\\w+)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(rawHTML);
      
      while(matcher.find()) {
        String actualURL = matcher.group();
        if(!discoveredWebsites.contains(actualURL)) {
          discoveredWebsites.add(actualURL);
          System.out.println("Found: " + actualURL);
          q.add(actualURL);
        }
      }
    }
  }

  private String readURL(String url) {
    String rawHTML = "";
    try(BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
      String inputLine = "";
      while((inputLine = br.readLine()) != null) {
        rawHTML += inputLine;
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return rawHTML;
  }

  public static void main(String[] args) {
    WebCrawler crawler = new WebCrawler();
    crawler.crawl("http://www.bbc.com/");
  }
}
