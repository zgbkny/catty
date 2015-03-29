package com.catty.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TcpServer implements Runnable {
	private Selector 				selector = null;
	private ServerSocketChannel		sschannel = null;
	private InetSocketAddress		address = null;
	protected Notifier 				notifier;
	
	
	public TcpServer(int port) throws IOException{
		
		notifier = Notifier.getNotifier();
		
		selector = Selector.open();
		sschannel = ServerSocketChannel.open();
		sschannel.configureBlocking(false);
		address = new InetSocketAddress(port);
		ServerSocket ss = sschannel.socket();
		ss.bind(address);
		sschannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int num = 0;
		while (true) {
			try {
				num = selector.select();
				if (num > 0) {
					Set selectedKeys = selector.selectedKeys();
					Iterator it = selectedKeys.iterator();
					while (it.hasNext()) {
						SelectionKey key = (SelectionKey)it.next();
						it.remove();
						// 处理Accept事件
						if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							notifier.fireOnAccept();
							
							SocketChannel sc = ssc.accept();
							sc.configureBlocking(false);
							
							// 触发接受连接事件
                           Request request = new Request(sc);
                           notifier.fireOnAccepted(request);

                           // 注册读操作,以进行下一步的读操作
                           sc.register(selector,  SelectionKey.OP_READ, request);
							
						}
						// 处理read事件
						if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
							
						}
						// 处理write事件
						if ((key.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
							
						}
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
