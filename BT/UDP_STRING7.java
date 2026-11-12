import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class UDP_STRING7 {
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
        int[] count = new int[65536];
        for (char c : parts[1].toCharArray()) {
            count[c]++;
        }

        // Duyet ky tu tang dan de cac ky tu cung tan suat dung thu tu.
        TreeMap<Integer, List<Character>> groups = new TreeMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (!groups.containsKey(count[i])) groups.put(count[i], new ArrayList<>());
                groups.get(count[i]).add((char) i);
            }
        }

        String data = "";
        for (int n : groups.descendingKeySet()) {
            for (char c : groups.get(n)) {
                if (!data.isEmpty()) data += ",";
                data += c + ":" + n;
            }
        }
        String res = parts[0] + ";" + data;

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));
        socket.close();
    }
}
