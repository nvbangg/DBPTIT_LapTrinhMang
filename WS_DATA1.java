import java.util.ArrayList;
import java.util.List;
import WS.data.DataService;
import WS.data.SoapDataService;

public class WS_DATA1 {
    public static void main(String[] args) throws Exception {
        SoapDataService service = new DataService().getSoapDataServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "VU9y8T9o";

        List<Integer> a = service.getData(studentCode, qCode);
        List<String> nums = new ArrayList<>();
        for (int x : a) {
            nums.add(String.valueOf(x));
        }
        nums.sort((x, y) -> (y + x).compareTo(x + y));
        String res = String.join("", nums);

        service.submitDataString(studentCode, qCode, res);
    }
}
