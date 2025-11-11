package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {

	public static void main(String[] args) {

		try {
			DatagramSocket sock = new DatagramSocket();

			String data = "정치";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket pack = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localhost", 50001));

			sock.send(pack);

			while (true) {
				DatagramPacket receivePack = new DatagramPacket(new byte[1024], 1024);
				sock.receive(receivePack);

				String news = new String(receivePack.getData(), 0, receivePack.getLength());
				System.out.println(news);

				if (news.contains("뉴스10")) break;
			}
			sock.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
