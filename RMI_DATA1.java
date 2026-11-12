import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import RMI.DataService;

public class RMI_DATA1 {
    public static void main(String[] args) throws Exception {
        DataService service = (DataService) Naming.lookup("rmi://36.50.135.242/RMIDataService");
        String studentCode = "B23DCCN067";
        String qCode = "yXDW6AQR";

        int[] a = (int[]) service.requestData(studentCode, qCode);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if ((i == 0 || a[i] > a[i - 1]) && (i == a.length - 1 || a[i] > a[i + 1])) {
                res.add(i + 1);
            }
        }

        service.submitData(studentCode, qCode, res);
    }
}
