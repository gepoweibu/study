package study201901_03;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String args[]) throws Exception {
		// 要连接的服务端IP地址和端口
		String host = "127.0.0.1";
		int port = 55533;
		// 与服务端建立连接
		Socket socket = new Socket(host, port);
		// 建立连接后获得输出流
		OutputStream outputStream = socket.getOutputStream();
		StringBuilder sb=new StringBuilder("Hello,");
		for (int i = 0; i < 500; i++) {
			sb.append("你好");
		}
		String message = sb.toString();
		// 首先需要计算得知消息的长度
		byte[] sendBytes = message.getBytes("UTF-8");
		// 然后将消息的长度优先发送出去
		outputStream.write(sendBytes.length >> 8);
		System.out.println("第一条消息长度右移一个字节："+(sendBytes.length >> 8)+"二进制值："+Integer.toBinaryString(sendBytes.length >> 8));
		outputStream.write(sendBytes.length);
		System.out.println("第一条消息长度："+(sendBytes.length )+"二进制值："+Integer.toBinaryString(sendBytes.length));
		// 然后将消息再次发送出去
		outputStream.write(sendBytes);
		System.out.println("第一条消息："+sendBytes);
		outputStream.flush();
		// ==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
		message = "第二条消息================*********8**********88*";
		sendBytes = message.getBytes("UTF-8");
		outputStream.write(sendBytes.length >> 8);//长度的第一个字节数据
		outputStream.write(sendBytes.length);//长度的第二个字节数据
		//out.write(int b) 取b的低8位放到输出流，高24被忽略。
		//假设length==(16位0)10011001 01110111-->右移8位-->00000000(16位0)10011001-->忽略高24位，低8位写进输出流-->10011001(输出流的第一个字节数据)
		//第二步：(16位0)10011001 01110111-->忽略高24位，低8位写进输出流-->01110111(输出流的第二个字节数据)
		//服务端读取输入流两个字节的数据计算消息的长度：in.read()读取一个字节的数据以int(32)类型返回(其实有用数据在低8位，高24位都为0)
		//第一次in.read()读取输入流中的第一个字节-->(24位0)10011001
		//第二次in.read()读取输入流中的第二个字节-->(24位0)01110111
		//还原两个字节中的数据-->第一个字节左移8位-->(16位0)10011001 00000000
		//-->加上第二个字节-----------------+->          (24位0)01110111
		//----计算结果----------------------->(16位0)10011001 01110111==length
		//更简洁的解释查看文件---selfstudy/src/study201901_03/IOMsgLenth.txt
		outputStream.write(sendBytes);
		outputStream.flush();
		// ==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
		message = "第三条消息================************8888888*******";
		sendBytes = message.getBytes("UTF-8");
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		outputStream.write(sendBytes);
		outputStream.close();
		socket.close();
	}
}
