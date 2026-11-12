import WS.object.ObjectService;
import WS.object.ProductY;
import WS.object.SoapObjectService;

public class SOAP_OBJECT1 {
    public static void main(String[] args) throws Exception {
        SoapObjectService service = new ObjectService().getSoapObjectServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "KchxMEtQ";

        ProductY product = service.requestProductY(studentCode, qCode);
        float price = product.getPrice() * (1 + product.getTaxRate() / 100) * (1 - product.getDiscount() / 100);
        product.setFinalPrice(price);

        service.submitProductY(studentCode, qCode, product);
    }
}
