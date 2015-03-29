package com.catty.connector.http;

import java.io.OutputStream;
import java.net.Socket;


public class HttpProcessor {

	private HttpConnector connector = null;
	private HttpRequest request;
	private HttpRequestLine requestLine = new HttpRequestLine();
	private HttpResponse response;

	protected String method = null;
	protected String queryString = null;

	/**
	 * The string manager for this package.
	 */
	//protected StringManager sm = StringManager
	//		.getManager("ex03.pyrmont.connector.http");

	public HttpProcessor(HttpConnector connector) {
		this.connector = connector;
	}

	public void process(Socket socket) {
		SocketInputStream input = null;
		OutputStream output = null;
		try {
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();
			
			request = new HttpRequest(input);
			
			response = new HttpResponse(output);
			response.setRequest(request);
			
			response.setHeader("Server", "Catty");
			
			parseRequest(input, output);
			parseHeaders(input);
			
			if (request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor processor = new ServletProcessor();
				processor.process(request, response);
			} else {
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}
			socket.close();
		} catch (Exception e) {
			
		}
	}

	private void parseHeaders(SocketInputStream input) {
		// TODO Auto-generated method stub
		
	}

	private void parseRequest(SocketInputStream input, OutputStream output) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
