import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_DATA1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 807;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength()).split(";", 3);
        int n = Integer.parseInt(parts[1].trim());
        boolean[] seen = new boolean[n + 1];
        if (!parts[2].trim().isEmpty()) {
            for (String x : parts[2].split(",")) {
                seen[Integer.parseInt(x.trim())] = true;
            }
        }

        String res = parts[0] + ";";
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) res += i + ",";
        }
        if (res.endsWith(",")) res = res.substring(0, res.length() - 1);

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
