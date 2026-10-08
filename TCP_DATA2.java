import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCP_DATA2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2207);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        dos.writeUTF("B23DCCN067;1H9rZUmX");
        dos.flush();

        String input = dis.readUTF();
        int n = dis.readInt();
        String res = "";
        
        // System.out.println(input);
        // System.out.println(n);
        for (char c : input.toCharArray()){
            if (Character.isAlphabetic(c)){
                res += (char) ((c-'A'+n)%26 + 'A');
            }
            else res += c;
        }
        dos.writeUTF(res);
        dos.flush();
        
        socket.close();
    }
}
