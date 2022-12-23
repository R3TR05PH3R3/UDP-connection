import java.io.FileInputStream;
import java.net.*;

class Sender {
    static public void main(String[] args)throws Exception {
        DatagramSocket Sock;
        byte[] buf = new byte[1024];
        FileInputStream file = new FileInputStream("D://testFile.txt");
        try {
            Sock= new DatagramSocket(6666);
            int i = 0;
            InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
            while(file.read(buf) != -1) {
                buf[i] = (byte) file.read();
                i++;
            }
            file.close();
            DatagramPacket packet = new DatagramPacket(buf,buf.length,inetAddress, 6667);
            Sock.send(packet);
            System.out.println("Sent:"+ new String(buf));
            Sock.close();
        } catch(Exception e) { }
    }
}