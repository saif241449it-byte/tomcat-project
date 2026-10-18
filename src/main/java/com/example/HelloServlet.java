package com.example;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head><title>Hello Servlet</title></head>" +
                        "<body>" +
                        "<h1>Hello from Java Servlet!</h1>" +
                        "<p>Tomcat deployment is working successfully.</p>" +
                        "</body>" +
                        "</html>"
        );
    }
}
