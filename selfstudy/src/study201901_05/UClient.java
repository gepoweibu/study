package study201901_05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UClient {
	public static  DatagramSocket ds = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			ds = new DatagramSocket();
			String msg=null;
			//开启一个线程读取服务端反馈的信息
			Thread t=new Thread(new Runnable() {
				public void run() {
					try {
						byte[] buf = new byte[100];
						DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
						while (true) {
							ds.receive(dp);
							String msg = new String(dp.getData(), 0, dp.getLength(), "utf-8");
							System.out.println(msg);
						}

					} catch (SocketException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						ds.close();
					}
				}
			});
			t.start();
			System.out.println("try input something:");
			//主线程扫描控制台的输入
			while (!"end".equals(msg=sc.nextLine())) {
				byte[] buf = msg.getBytes("utf-8");
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 8088);
				ds.send(dp);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			ds.close();
		}
	}

}
