import java.rmi.Naming;
import RMI.ByteService;

public class RMI_BYTE2 {
    public static void main(String[] args) throws Exception {
        ByteService service = (ByteService) Naming.lookup("rmi://36.50.135.242/RMIByteService");
        String studentCode = "B23DCCN067";
        String qCode = "nEUEhw46";

        byte[] a = service.requestData(studentCode, qCode);
        int[] count = new int[256];
        for (byte x : a) {
            count[x + 128]++;
        }

        byte value = a[0];
        for (byte x : a) {
            if (count[x + 128] > count[value + 128]) value = x;
        }

        byte[] res = {value, (byte) count[value + 128]};
        service.submitData(studentCode, qCode, res);
    }
}
