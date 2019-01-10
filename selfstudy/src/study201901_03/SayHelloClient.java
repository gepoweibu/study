package study201901_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SayHelloClient {

	public static void main(String[] args) {
		String severName = args[0];
		int port = Integer.parseInt(args[1]);
		try {
			System.out.println("正在连接主机：" + severName + " 端口： " + port);
			Socket client = new Socket(severName, port);
			System.out.println("连接到远程主机地址：" + client.getRemoteSocketAddress());
			OutputStream outToSever = client.getOutputStream();
			DataOutputStream dataOutStream = new DataOutputStream(outToSever);
			System.out.print("请输入要说的话：");
			Scanner sc=new Scanner(System.in);
			dataOutStream.writeUTF(sc.nextLine());
			client.shutdownOutput();
			InputStream inFromSever = client.getInputStream();
			DataInputStream dataInStream = new DataInputStream(inFromSever);
			System.out.println("服务器说：" + dataInStream.readUTF());
			sc.close();
			client.close();
			System.out.println("客户端连接已关闭！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
