import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class TCP_BYTE_RAW1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2206);

        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        os.write("B23DCCN067;2bqXfIJH".getBytes());

        byte[] buff = new byte[1024];
        int bytes = is.read(buff);
        String str = new String(buff, 0, bytes);

        String[] a = str.split(",");
        int[] nums = new int[a.length];
        for (int i=0; i<a.length; i++){
            nums[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int numA = 0;
        int numB = 0;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i+1]- nums[i] < min){
                min = nums[i+1]- nums[i];
                numA = nums[i];
                numB = nums[i+1];
            }
        }

        os.write((min+","+numA+","+numB).getBytes());

        socket.close();
    }
}
