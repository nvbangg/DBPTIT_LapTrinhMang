import java.util.List;
import WS.object.EmployeeY;
import WS.object.ObjectService;
import WS.object.SoapObjectService;

public class WS_OBJECT1 {
    public static void main(String[] args) throws Exception {
        SoapObjectService service = new ObjectService().getSoapObjectServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "vQhpNPxe";

        List<EmployeeY> a = service.requestListEmployeeY(studentCode, qCode);
        a.sort((x, y) -> x.getStartDate().toGregorianCalendar().compareTo(y.getStartDate().toGregorianCalendar()));

        service.submitListEmployeeY(studentCode, qCode, a);
    }
}
