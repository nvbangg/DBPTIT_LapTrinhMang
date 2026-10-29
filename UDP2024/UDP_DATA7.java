package UDP2024;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UDP_DATA7 {
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
        String[] values = parts[1].split(",");
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i].trim());
        }
        Arrays.sort(nums);

        // Tim hang thu hai theo gia tri phan biet, bo qua cac so trung.
        int left = 1;
        while (left < nums.length && nums[left] == nums[0]) left++;
        int right = nums.length - 2;
        while (right >= 0 && nums[right] == nums[nums.length - 1]) right--;
        if (left == nums.length) {
            throw new IllegalArgumentException("Day can it nhat hai gia tri phan biet");
        }
        String res = parts[0] + ";" + nums[right] + "," + nums[left];

        byte[] out = res.getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}
