package socketmulti;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Multisocket extends Thread{
    protected MulticastSocket socket = null;

 
    public void run() {
    	InputStream is = null;
        byte[] buffer = null;
        try {
			is = new FileInputStream("C:/TEMP/FB_IMG_1507929534185.jpg");
			buffer = new byte[is.available()];
	        is.read(buffer);
	        is.close();
	        socket = new MulticastSocket(4446);
	        InetAddress group = InetAddress.getByName("230.0.0.0");
	        socket.joinGroup(group);
	        while (true) {
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	            socket.receive(packet);
	            String received = new String(
	              packet.getData(), 0, packet.getLength());
	            if ("end".equals(received)) {
	                break;
	            }
	        }
	        socket.leaveGroup(group);
	        socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

