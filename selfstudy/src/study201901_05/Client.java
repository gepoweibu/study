package study201901_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	private Socket socket;
	private ExecutorService threadPool;

	public Client(String address, int port) {
		try {
			this.socket = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接服务器异常！");
		}
		threadPool = Executors.newFixedThreadPool(2);
	}

	public static void main(String[] args) {
		Client client = new Client("localhost", 8088);
		client.start();
	}

	public void start() {
		threadPool.execute(new ServerOSHandler(socket));
		threadPool.execute(new ServerISHandler(socket));
	}

	class ServerISHandler implements Runnable {
		private Socket socket;

		public ServerISHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				InputStream ins = socket.getInputStream();
				InputStreamReader insr = new InputStreamReader(ins, "utf-8");
				BufferedReader br = new BufferedReader(insr);
				String msg = null;
				while ((msg = br.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (IOException e) {
				System.out.println("服务器已断开连接！");
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	class ServerOSHandler implements Runnable {
		private Socket socket;

		public ServerOSHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter outw = new OutputStreamWriter(out, "utf-8");
				PrintWriter pw = new PrintWriter(outw, true);
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入你的昵称：");
				String msg = null;
				while (true) {
					msg = sc.nextLine();
					if (msg.trim().length() > 0) {
						pw.println(msg);
						break;
					}
				}
				while ((msg = sc.nextLine()) != null) {
					pw.println(msg);// pw设置了自动行属性，少写pw.flush()
				}
				sc.close();
			} catch (IOException e) {
				System.out.println("服务器连接已断开");
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭客户端异常！");
				}
			}

		}

	}
}
