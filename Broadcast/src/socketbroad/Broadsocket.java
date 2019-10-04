package socketbroad;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Broadsocket {
	  private static DatagramSocket socket = null;
	  
	    public static void main(String[] args) throws IOException {
	        broadcast(InetAddress.getByName("255.255.255.255"));
	    }
	 
	    public static void broadcast(InetAddress address) throws IOException {
	        socket = new DatagramSocket();
	        socket.setBroadcast(true);
	 
	        InputStream is = null;
	        byte[] buffer = null;
	        is = new FileInputStream("C:/TEMP/FB_IMG_1507929534185.jpg");
	        buffer = new byte[is.available()];
	        is.read(buffer);
	        is.close();
	 
	        DatagramPacket packet 
	          = new DatagramPacket(buffer, buffer.length, address, 4445);
	        socket.send(packet);
	        socket.close();
	    }
	}