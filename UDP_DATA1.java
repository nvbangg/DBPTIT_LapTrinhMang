import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_DATA1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        int port = 2207;

        byte[] req = ";B23DCCN067;toft6ekh".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[2048];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength()).split(";");
        int n = Integer.parseInt(parts[1]);
        boolean[] seen = new boolean[n + 1];
        for (String x : parts[2].split(",")) {
            seen[Integer.parseInt(x)] = true;
        }
        String res = parts[0] + ";";
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) res += i + ",";
        }
        res = res.substring(0, res.length() - 1);

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
