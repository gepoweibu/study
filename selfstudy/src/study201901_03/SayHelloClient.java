package study201901_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SayHelloClient {

	public static void main(String[] args) {
		String severName = args[0];
		int port = Integer.parseInt(args[1]);
		try {
			System.out.println("Connecting to " + severName + "on port " + port);
			Socket client = new Socket(severName, port);
			System.out.println("Just connect to " + client.getRemoteSocketAddress());
			OutputStream outToSever = client.getOutputStream();
			DataOutputStream dataOutStream = new DataOutputStream(outToSever);
			dataOutStream.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromSever = client.getInputStream();
			DataInputStream dataInStream = new DataInputStream(inFromSever);
			System.out.println("Sever says " + dataInStream.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
