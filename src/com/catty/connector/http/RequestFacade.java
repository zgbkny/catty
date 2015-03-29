package com.catty.connector.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestFacade implements ServletRequest{
	
	private ServletRequest request = null;
	
	public RequestFacade(HttpRequest request) {
		this.request = (ServletRequest) request;
	}


	@Override
	public Object getAttribute(String attribute) {
		// TODO Auto-generated method stub
		return request.getAttribute(attribute);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return request.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return request.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return request.getContentLength();
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return request.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return request.getInputStream();
	}



	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return request.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return request.getLocales();
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return request.getParameter(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return request.getParameterMap();
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return request.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String parameter) {
		// TODO Auto-generated method stub
		return request.getParameterValues(parameter);
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return request.getProtocol();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return request.getReader();
	}

	@Override
	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return request.getRealPath(path);
	}

	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return request.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return request.getRemoteHost();
	}


	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return request.getRequestDispatcher(path);
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return request.getScheme();
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return request.getServerName();
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return request.getServerPort();
	}



	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return request.isSecure();
	}

	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String key, Object value) {
		// TODO Auto-generated method stub
		request.setAttribute(key, value);
	}

	@Override
	public void setCharacterEncoding(String encoding)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
	}


}
