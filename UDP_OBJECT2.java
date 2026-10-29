import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import UDP.Customer;

public class UDP_OBJECT2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        int port = 2209;

        byte[] req = ";B23DCCN067;xcFNQUI4".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[2048];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(dp.getData(), 8, dp.getLength() - 8));
        Customer customer = (Customer) ois.readObject();

        String[] words = customer.name.trim().toLowerCase().split(" ");

        String lastName = words[words.length - 1].toUpperCase();
        String firstName = "";
        String user = "";
        for (int i=0; i<words.length - 1; i++){
            firstName += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ";
            user += words[i].charAt(0);
        }
        customer.name = lastName + ", " + firstName.trim();

        String[] dob = customer.dayOfBirth.trim().split("-");
        customer.dayOfBirth = dob[1] + "/" + dob[0] + "/" + dob[2];

        customer.userName = user + words[words.length - 1];

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
