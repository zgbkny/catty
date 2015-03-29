package com.catty.net;

public interface ServerListener {
	public void onError(String error);
	public void onAccept();
	public void onAccepted();
	public void onRead();
	public void onWrite();
	public void onClosed();
}
