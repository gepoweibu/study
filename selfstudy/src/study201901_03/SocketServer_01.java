package study201901_03;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer_01 {
	public static void main(String[] args) throws Exception {
		// 监听指定的端口
		int port = 55533;
		ServerSocket server = new ServerSocket(port);
		
		//获取客户端连接
		Socket socket = server.accept();
		InputStream inputStream = socket.getInputStream();
		
		//接收客户端信息
		byte[] bytes;
		while (true) {
			int first = inputStream.read();
			if (first == -1) {
				System.out.println("客户停止了信息的发送！");
				break;
			}
			int second = inputStream.read();
			int length = (first << 8) + second;
			bytes = new byte[length];
			inputStream.read(bytes);
			System.out.println("客户: " + new String(bytes, "UTF-8"));
			
		}
		
		//关闭数据流
		inputStream.close();
		socket.close();
		server.close();
		System.out.println("服务器端已关闭！");
	}
}
