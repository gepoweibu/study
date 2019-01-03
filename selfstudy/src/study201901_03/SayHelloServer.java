package study201901_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SayHelloServer extends Thread {
	private ServerSocket serverSocket;//服务器套接字
	public SayHelloServer(int port) throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(100000);//设置超时时间10s
		
	}
	public void run(){
		while(true){
			try{
				System.out.println("Waiting for client on port "+serverSocket.getLocalPort());
				Socket server=serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				DataInputStream dataInputStream=new DataInputStream(server.getInputStream());
				System.out.println(dataInputStream.readUTF());
				DataOutputStream dataOutputStream=new DataOutputStream(server.getOutputStream());
				dataOutputStream.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()+System.lineSeparator()+"Goodbye!");
				server.close();
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
