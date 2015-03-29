package com.catty.connector.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse {
	private ServletResponse response;
	public ResponseFacade(HttpResponse response) {
		this.response = (ServletResponse) response;
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		response.flushBuffer();
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return response.getBufferSize();
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return response.getCharacterEncoding();
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return response.getLocale();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return response.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return response.getWriter();
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return response.isCommitted();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		response.reset();
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		response.resetBuffer();
	}

	@Override
	public void setBufferSize(int size) {
		// TODO Auto-generated method stub
		response.setBufferSize(size);
	}


	@Override
	public void setContentLength(int length) {
		// TODO Auto-generated method stub
		response.setContentLength(length);
	}

	@Override
	public void setContentType(String type) {
		// TODO Auto-generated method stub
		response.setContentType(type);
	}

	@Override
	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub
		response.setLocale(loc);
	}
	

}
