import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_STRING2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        int port = 2208;

        byte[] req = ";B23DCCN067;EkI693uw".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[2048];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String s = new String(dp.getData(), 0, dp.getLength()).trim();
        String[] parts = s.split(";", 2);
        String[] words = parts[1].trim().toLowerCase().split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        String res = parts[0] + ";" + String.join(" ", words);

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));
        socket.close();
    }
}
