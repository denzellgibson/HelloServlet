package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 5797336179647213715L;

	private Logger log = Logger.getLogger(HelloServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		log.trace("Handling a GET request!");
		PrintWriter pw = resp.getWriter();
		// PrintWriter: An object that I get from the HttpServletResponse object that allows
		// me to write directly to the body of the http response.
		pw.write("<html><head><title>Hello World!</title></head><body>");
		pw.write("<a href=\"index.html\">request a color</a></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		log.trace("handling a POST request.");
		String color = null;
		
		color = req.getParameter("color");
		log.trace("Requested color: "+color);
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html><head><title>Hello World!</title></head><body>");
		pw.write("<div style=\"background-color:"+color+"\">Requested color was: "+color+"</div>");
		pw.write("<a href=\"index.html\">request a color</a></body></html>");
	}
	
	@Override
	public void init() {
		//this method is actually called by the REAL init method.
		//The REAL init method is too important and they don't want you to override it.
		log.trace("HelloServlet init()");
		
		
	}
}
