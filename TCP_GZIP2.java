import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class TCP_GZIP2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2210);

        GZIPOutputStream gos = new GZIPOutputStream(socket.getOutputStream());
        gos.write("B23DCCN067;UrLXNu5H\n".getBytes());
        gos.finish();

        GZIPInputStream gis = new GZIPInputStream(socket.getInputStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        while ((b = gis.read()) != -1 && b != '\n'){
            baos.write(b);
        }
        String str = baos.toString();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String res = new String(chars);

        gos = new GZIPOutputStream(socket.getOutputStream());
        gos.write((res+"\n").getBytes());
        gos.finish();

        socket.close();
    }
}