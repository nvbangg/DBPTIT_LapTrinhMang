package UDP2024;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDP_DATA6 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 807;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength(), StandardCharsets.UTF_8).split(";", 3);
        int shift = Math.floorMod(Integer.parseInt(parts[2].trim()), 26);
        String data = "";
        // Theo vi du trong de: s = 3 thi A thanh D (dich tien).
        for (char c : parts[1].toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + shift) % 26);
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + shift) % 26);
            }
            data += c;
        }
        String res = parts[0] + ";" + data;

        byte[] out = res.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
