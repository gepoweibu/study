package study201901_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ServerSocket server;
	private ExecutorService threadPoll;
	public static ArrayList<PrintWriter> pwList;

	public Server(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadPoll = Executors.newFixedThreadPool(50);
		pwList = new ArrayList<PrintWriter>();
	}
	//使用server对象锁住从pwList集合中存、取、遍历的方法，使三者互斥以保证多线程安全。
	public synchronized void removePw(PrintWriter pw){
		pwList.remove(pw);
		System.out.println("当前用户数: "+pwList.size());
	}
	public synchronized void addPw(PrintWriter pw){
		pwList.add(pw);
		System.out.println("当前用户数: "+pwList.size());
	}
	public synchronized void sendMsg(String str,String msg,PrintWriter nopw){
		for (PrintWriter pwr : pwList) {
			if(!nopw.equals(pwr))
			pwr.println(str + msg);
		}
	}

	public static void main(String[] args) {
		Server server = new Server(8088);
		server.start();
	}

	public void start() {
		Socket socket = null;
		try {
			while (true) {
				System.out.println("等待客户端连接...");
				socket = server.accept();
				System.out.println("客户:" + socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() + " 已连接");
				threadPoll.execute(new ClientISHandler(socket));
			}
		} catch (IOException e) {

		}
	}

	class ClientISHandler implements Runnable {
		private Socket socket;

		public ClientISHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			PrintWriter pw =null;
			String nickName=null; 
			try {
				InputStream ins = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(ins, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter outw = new OutputStreamWriter(out, "utf-8");
				pw=new PrintWriter(outw, true);
				addPw(pw);
				nickName= br.readLine();
				sendMsg(nickName,"上线了",pw);
				sendMsg("当前用户：",Integer.toString(pwList.size()),pw);
				String msg = null;
				while ((msg = br.readLine()) != null) {
					sendMsg(nickName+"说：",msg,pw);
				}
			} catch (IOException e) {
				sendMsg(nickName,"下线了",pw);
				removePw(pw);
				sendMsg("当前用户：",Integer.toString(pwList.size()),pw);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭服务器异常！");
				}
			}

		}

	}

}
