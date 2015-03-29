package com.catty;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.catty.connector.http.HttpRequest;
import com.catty.connector.http.HttpResponse;
import com.catty.connector.http.ServletProcessor;
import com.catty.connector.http.StaticResourceProcessor;

public class HttpServer {
	public static void main(String []args) {
		HttpServer server = new HttpServer();
	    server.await();
	}
	
	/** WEB_ROOT is the directory where our HTML and other files reside.
	 *  For this package, WEB_ROOT is the "webroot" directory under the working
	 *  directory.
	 *  The working directory is the location in the file system
	 *  from where the java command was invoked.
	 */
	public static final String WEB_ROOT =
		  System.getProperty("user.dir") + File.separator  + "webroot";

	// shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	// the shutdown command received
	private boolean shutdown = false;
	
	public void await() {
	    ServerSocket serverSocket = null;
	    int port = 8080;
	    try {
	    	serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    	System.exit(1);
	    }

	    // Loop waiting for a request
	    while (!shutdown) {
	    	Socket socket = null;
	    	InputStream input = null;
	    	OutputStream output = null;
	    	try {
	    		socket = serverSocket.accept();
	    		input = socket.getInputStream();
	    		output = socket.getOutputStream();

	    		// create Request object and parse
	    		HttpRequest request = new HttpRequest(input);
	    		request.parse();

	    		// create Response object
	    		HttpResponse response = new HttpResponse(output);
	    		response.setRequest(request);

	    		// check if this is a request for a servlet or a static resource
	    		// a request for a servlet begins with "/servlet/"
	    		System.out.println(request.getUri());
	    		if (request.getUri().startsWith("/servlet/")) {
	    			ServletProcessor processor = new ServletProcessor();
	    			processor.process(request, response);
	    		} else {
	    			StaticResourceProcessor processor = new StaticResourceProcessor();
	    			processor.process(request, response);
	    		}

	    		// Close the socket
	    		socket.close();

	    		//check if the previous URI is a shutdown command
	    		shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		continue;
	    	}
	    }
	}
}
