package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    //create a new arrayList
    ArrayList<String> quotes = new ArrayList<>();
    
    //add few quotes to the arrayList
    quotes.add("\"Education is the most powerful weapon that you can use to change the world\" ~ Nelson Mandela");
    quotes.add("\"Everything negative is an opportunity for me to rise\" ~ Kobi Bryan");
    quotes.add("\"With enough time, focus, and persistence, I can master the fundamentals and succeed\" ~ Unknown");
    
    //convert arrayList to json
    String json = convertToJsonUsingGson(quotes);

    //send json as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  /**
   * 
   * @param quotes is the name of the array that needs to be converted to a json object
   * @return the json string
   */
  private String convertToJsonUsingGson(ArrayList<String> quotes) {
    Gson gson = new Gson();
    String json = gson.toJson(quotes);
    return json;
  }
}


