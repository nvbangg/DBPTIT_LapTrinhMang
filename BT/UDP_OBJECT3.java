import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Locale;

public class UDP_OBJECT3 {
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
        Customer customer = (Customer) ois.readObject();

        String[] words = customer.name.trim().toLowerCase(Locale.ROOT).split(" ");
        String lastName = words[words.length - 1];
        String firstName = "";
        String user = "";
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].isEmpty()) continue;
            firstName += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ";
            user += words[i].charAt(0);
        }
        customer.name = lastName.toUpperCase(Locale.ROOT);
        if (!firstName.isEmpty()) customer.name += ", " + firstName.trim();
        customer.userName = user + lastName;

        String[] dob = customer.dayOfBirth.split("-");
        customer.dayOfBirth = dob[1] + "/" + dob[0] + "/" + dob[2];

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buff, 0, 8);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        byte[] out = baos.toByteArray();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}

