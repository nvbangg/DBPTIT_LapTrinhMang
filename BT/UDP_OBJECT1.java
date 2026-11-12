import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Locale;

public class UDP_OBJECT1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 809;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buff, 8, dp.getLength() - 8));
        Student student = (Student) ois.readObject();

        String[] words = student.name.trim().toLowerCase(Locale.ROOT).split(" ");
        String name = "";
        String email = words[words.length - 1];
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            name += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ";
            if (i < words.length - 1) email += words[i].charAt(0);
        }
        student.name = name.trim();
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

