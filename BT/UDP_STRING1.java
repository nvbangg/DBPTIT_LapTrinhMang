import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_STRING1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 808;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength()).split(";", 2);
        String data = parts[1];
        int[] count = new int[65536];
        for (char c : data.toCharArray()) {
            count[c]++;
        }

        // Neu cung tan suat, chon ky tu xuat hien dau tien nhu bai mau.
        char maxChar = 0;
        int max = 0;
        for (char c : data.toCharArray()) {
            if (count[c] > max) {
                max = count[c];
                maxChar = c;
            }
        }

        String res = parts[0] + ";";
        if (!data.isEmpty()) {
            res += maxChar + ":";
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == maxChar) res += (i + 1) + ",";
            }
        }

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));
        socket.close();
    }
}
