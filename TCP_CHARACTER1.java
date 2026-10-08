import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCP_CHARACTER1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2208);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        bw.write("B23DCCN067;jNEYbPud\n");
        bw.flush();

        String str = br.readLine();
        List<String> edu = new ArrayList<>();
        String[] a = str.split(", ");
        for (String s : a){
            if (s.endsWith(".edu")){
                edu.add(s);
            }
        }
        String res = String.join(", ", edu);

        bw.write(res +"\n");
        bw.flush();

        socket.close();
    }
}
