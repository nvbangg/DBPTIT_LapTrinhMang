import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.Student;

public class UDP_OBJECT1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        int port = 2209;

        byte[] req = ";B23DCCN067;UN9ZNrMb".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[2048];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(dp.getData(), 8, dp.getLength() - 8));
        Student student = (Student) ois.readObject();

        String[] words = student.name.trim().toLowerCase().split(" ");

        String name = "";
        for (String w: words){
            name += w.substring(0,1).toUpperCase() + w.substring(1) + " ";
        }
        student.name = name.trim();

        String email = words[words.length-1];
        for (int i=0; i<words.length-1; i++){
            email += words[i].charAt(0);
        }
        student.email = email + "@ptit.edu.vn";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buff, 0, 8);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        byte[] out = baos.toByteArray();
        socket.send(new DatagramPacket(out, out.length, ip, port));
        
        socket.close();
    }
}
