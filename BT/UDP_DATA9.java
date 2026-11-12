import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_DATA9 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 807;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        String[] parts = new String(buff, 0, dp.getLength()).split(";", 4);
        int n = Integer.parseInt(parts[1].trim());
        int k = Integer.parseInt(parts[2].trim());
        String[] values = parts[3].split(",");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(values[i].trim());
        }

        String res = parts[0] + ";";
        for (int i = 0; i + k <= n; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) max = nums[j];
            }
            res += max + ",";
        }
        if (res.endsWith(",")) res = res.substring(0, res.length() - 1);

        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
