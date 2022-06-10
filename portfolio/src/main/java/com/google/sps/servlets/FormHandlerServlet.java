package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("firstname");
    String lastname = request.getParameter("lastaname");
    String email = request.getParameter("email");
    String message = request.getParameter("subject");

    // Print the value so you can see it in the server logs.
    System.out.println("Name of the person: " + name);
    System.out.println("Last name of the person: " + lastname);
    System.out.println("Email of the person: " + email);
    System.out.println("Message from the person: " + message);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Thanks for contacting me. I will get back to you soon.");
  }
}
