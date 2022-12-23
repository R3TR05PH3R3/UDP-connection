import java.io.IOException;
import java.net.*;
import java.io.*;

class Receiver {
    static public void main(String[] args)throws IOException {
        DatagramSocket Sock;
        byte[] buf = new byte[1024];
        String temp;
        byte c[];
        File file2 = new File("D://newTestFile_TEST.txt");
        FileOutputStream F = new FileOutputStream(file2);
        try {
            Sock= new DatagramSocket(6667);
            while(true){
                DatagramPacket pac = new DatagramPacket(buf,buf.length);
                Sock.receive(pac);
                System.out.println("Received:" + new String(pac.getData()).trim()+ " From port:"+ pac.getPort()+ " LocalPort:"+Sock.getLocalPort());
                F.write(buf);
                F.flush();
                F.close();
            }
            //Sock.close();
        } catch(Exception e) { }
    }
}