import java.util.List;
import WS.data.DataService;
import WS.data.SoapDataService;

public class WS_DATA2 {
    public static void main(String[] args) throws Exception {
        SoapDataService service = new DataService().getSoapDataServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "Wve7GCTx";

        List<Integer> a = service.getData(studentCode, qCode);
        int sum = 0;
        for (int x : a) {
            sum += x;
        }

        service.submitDataInt(studentCode, qCode, sum);
    }
}
