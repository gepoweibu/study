package study201901_05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(8088);
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
			while (true) {
				ds.receive(dp);
				String msg = new String(dp.getData(), 0, dp.getLength(), "utf-8");
				System.out.println(dp.getAddress().toString().substring(1)+" "+dp.getPort()+":"+msg);
				msg="返回处理结果:"+msg;
				dp.setData(msg.getBytes("utf-8"));
				dp.setAddress(dp.getAddress());
				dp.setPort(dp.getPort());
				ds.send(dp);
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
		
	}
}