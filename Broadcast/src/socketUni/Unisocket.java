package socketUni;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpUnicastServer implements Runnable {
    /**
    * The port where the client is listening.
    */
    private final int clientPort;
    public UdpUnicastServer(int clientPort) {
        this.clientPort = clientPort;
    }
    @Override
    public void run() {
        try (DatagramSocket serverSocket = new DatagramSocket(50000)) {
        for (int i = 0; i < 3; i++) {
        	
        	InputStream is = null;
	        byte[] buffer = null;
	        is = new FileInputStream("C:/TEMP/FB_IMG_1507929534185.jpg");
	        buffer = new byte[is.available()];
	        is.read(buffer);
	        is.close();
	 
            DatagramPacket datagramPacket = new DatagramPacket(
                buffer,
                buffer.length,
                InetAddress.getLocalHost(),
                clientPort);
            serverSocket.send(datagramPacket);
        } 
    } catch (SocketException e) {
        e.printStackTrace();
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
}