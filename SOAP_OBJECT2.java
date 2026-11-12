import java.util.ArrayList;
import java.util.List;
import WS.object.Customer;
import WS.object.ObjectService;
import WS.object.SoapObjectService;

public class SOAP_OBJECT2 {
    public static void main(String[] args) throws Exception {
        SoapObjectService service = new ObjectService().getSoapObjectServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "gZOiIVi5";

        List<Customer> a = service.requestListCustomer(studentCode, qCode);
        List<Customer> res = new ArrayList<>();
        for (Customer c : a) {
            if (c.getPurchaseCount() >= 6 && c.getTotalSpent() >= 4000) res.add(c);
        }
        res.sort((x, y) -> {
            int cmp = Float.compare(y.getTotalSpent(), x.getTotalSpent());
            return cmp != 0 ? cmp : x.getCustomerId().compareTo(y.getCustomerId());
        });

        service.submitListCustomer(studentCode, qCode, res);
    }
}
