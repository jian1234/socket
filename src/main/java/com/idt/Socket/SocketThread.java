package com.idt.Socket;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketThread {

	private Socket socket;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// 根据输入输出流和客户端连接
		try {
			InputStream inputStream = socket.getInputStream();
			// 得到一个输入流，接收客户端传递的信息
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);// 提高效率，将自己字节流转为字符流
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);// 加入缓冲区
			String temp = null;
			String info = "";

			while ((temp = bufferedReader.readLine()) != null) {
				info += temp;
				System.out.println("已接收到客户端连接");
				System.out.println("服务端接收到客户端信息：" + info.length());
/*	                FileOutputStream fos = new FileOutputStream("sxt.txt");
	                fos.write(temp.getBytes());
	                fos.close();*/
			}
	            /*char[] chs = new char[1024];
	            int len = bufferedReader.read(chs, 0, 1024);
	            char[] chs1 = new char[len];
	            for (int i = 0; i < chs1.length; i++) {
	            	chs1[i] = chs[i];
				}*/

			OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
			PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
			printWriter.print("I got it");
			printWriter.flush();
			socket.shutdownOutput();// 关闭输出流

			// 关闭相对应的资源
			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

		

	
}
