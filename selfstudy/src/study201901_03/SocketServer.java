package study201901_03;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws Exception {
		// 监听指定的端口
		int port = 55533;
		ServerSocket server = new ServerSocket(port);

		// server将一直等待连接的到来
		System.out.println("server将一直等待连接的到来");
		Socket socket = server.accept();
		// 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
		InputStream inputStream = socket.getInputStream();
		byte[] bytes;
		//循环一直接收来自客户端的消息并打印到控制台
		while (true) {
			// 首先读取两个字节表示的长度
			int first = inputStream.read();
			System.out.println("读取的第一个字节:"+first+"左移一个字节："+Integer.toBinaryString(first));
			// 如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
			if (first == -1) {
				System.out.println("---输入流数据已读完---");
				break;
			}
			int second = inputStream.read();
			System.out.println("读取的第二个字节："+second+"二进制值："+Integer.toBinaryString(second));
			int length = (first << 8) + second;
			System.out.println("计算后的的消息长度:"+length+"二进制值："+Integer.toBinaryString(length));
			// 然后构造一个指定长的byte数组
			bytes = new byte[length];
			// 然后读取指定长度的消息即可
			inputStream.read(bytes);
			System.out.println("get message from client: " + new String(bytes, "UTF-8"));
		}
		inputStream.close();
		socket.close();
		server.close();
	}
}
