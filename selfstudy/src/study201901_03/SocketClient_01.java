package study201901_03;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient_01 {
	public static void main(String args[]) throws Exception {
		//服务端IP地址和端口
		String host = "127.0.0.1";
		int port = 55533;

		//连接到服务器
		Socket socket = new Socket(host, port);
		OutputStream outputStream = socket.getOutputStream();

		//向服务器发送消息
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);
		String line;
		while (!"end".equals(line=sc.nextLine())) {//输入end字符串表示信息发送完毕
			String message = line;
			byte[] sendBytes = message.getBytes("UTF-8");
			outputStream.write(sendBytes.length >> 8);
			outputStream.write(sendBytes.length);
			outputStream.write(sendBytes);
			outputStream.flush();
			System.out.println("消息已发送！");
		}
		
		// 关闭数据流
		sc.close();
		outputStream.close();
		socket.close();
		System.out.println("客户端已关闭！");
	}
}
