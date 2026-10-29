package UDP2024;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDP_DATA8 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 807;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength(), StandardCharsets.UTF_8).split(";", 2);
        int n = Integer.parseInt(parts[1].trim());
        int count = 0;
        String res = parts[0] + ";";
        for (int x = 2; count < n; x++) {
            boolean prime = true;
            for (int d = 2; d * d <= x; d++) {
                if (x % d == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                res += x + ",";
                count++;
            }
        }
        if (res.endsWith(",")) res = res.substring(0, res.length() - 1);

        byte[] out = res.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
