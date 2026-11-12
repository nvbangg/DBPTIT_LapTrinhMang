import java.util.Arrays;
import java.util.List;
import WS.data.DataService;
import WS.data.SoapDataService;

public class SOAP_DATA1 {
    public static void main(String[] args) throws Exception {
        SoapDataService service = new DataService().getSoapDataServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "dkEZLFFv";

        List<Integer> a = service.getData(studentCode, qCode);
        int even = 0;
        for (int x : a) {
            if (x % 2 == 0) even++;
        }
        List<String> res = Arrays.asList("EVEN=" + even, "ODD=" + (a.size() - even));

        service.submitDataStringArray(studentCode, qCode, res);
    }
}
