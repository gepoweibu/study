package study201901_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class SayHelloServer extends Thread {
	private ServerSocket serverSocket;//服务器套接字
	public SayHelloServer(int port) throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(100*1000);//设置超时时间100s
		
	}
	public void run(){
		while(true){
			try{
				System.out.println("等待客户端连接的本地端口："+serverSocket.getLocalPort());
				Socket server=serverSocket.accept();
				System.out.println("建立连接完成，客户端地址："+server.getRemoteSocketAddress());
				DataInputStream dataInputStream=new DataInputStream(server.getInputStream());
				System.out.println("客户端说："+dataInputStream.readUTF());
				server.shutdownInput();
				DataOutputStream dataOutputStream=new DataOutputStream(server.getOutputStream());
				System.out.print("请输入要说的话：");
				Scanner sc=new Scanner(System.in);
				dataOutputStream.writeUTF(sc.nextLine());
				sc.close();
				server.close();
				System.out.println("服务器连接已关闭！");
			}catch(SocketException s){
				s.printStackTrace();
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String[] args){
		int port=Integer.parseInt(args[0]);
		try {
			Thread t=new SayHelloServer(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
