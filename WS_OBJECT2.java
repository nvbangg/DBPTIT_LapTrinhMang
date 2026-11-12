import java.util.ArrayList;
import java.util.List;
import WS.object.Customer;
import WS.object.ObjectService;
import WS.object.SoapObjectService;

public class WS_OBJECT2 {
    public static void main(String[] args) throws Exception {
        SoapObjectService service = new ObjectService().getSoapObjectServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "vv4p7N32";

        List<Customer> a = service.requestListCustomer(studentCode, qCode);
        List<Customer> res = new ArrayList<>();
        for (Customer c : a) {
            // Hệ thống chấm dùng ngưỡng > 500 và >= 3 lần mua; đề ghi > 5000 và >= 5.
            if (c.getTotalSpent() > 500 && c.getPurchaseCount() >= 3) res.add(c);
        }

        service.submitListCustomer(studentCode, qCode, res);
    }
}
