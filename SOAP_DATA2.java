import java.util.List;
import WS.data.DataService;
import WS.data.SoapDataService;

public class SOAP_DATA2 {
    public static void main(String[] args) throws Exception {
        SoapDataService service = new DataService().getSoapDataServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "06hJh2Q1";

        List<Integer> a = service.getData(studentCode, qCode);
        int primeCount = 0;
        long checksum = 0;
        for (int i = 0; i < a.size(); i++) {
            int n = a.get(i);
            boolean prime = n >= 2;
            for (int j = 2; j <= n / j; j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) primeCount++;
            checksum += (i + 1L) * n;
        }
        String res = "primeCount=" + primeCount + ";checksum=" + checksum % 100000;

        service.submitDataString(studentCode, qCode, res);
    }
}
