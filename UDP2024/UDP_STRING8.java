package UDP2024;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDP_STRING8 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 808;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength(), StandardCharsets.UTF_8).split(";", 2);
        String[] words = parts[1].split(" ");
        String data = "";
        // Theo cau chu cua de: moi ky tu deu la nguyen am; vi du is,an bi mau thuan.
        for (String w : words) {
            if (w.isEmpty()) continue;
            boolean ok = true;
            for (char c : w.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) == -1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (!data.isEmpty()) data += ",";
                data += w;
            }
        }
        String res = parts[0] + ";" + data;

        byte[] out = res.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(out, out.length, ip, port));
        socket.close();
    }
}
