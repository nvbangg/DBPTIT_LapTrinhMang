import WS.character.CharacterService;
import WS.character.SoapCharacterService;

public class SOAP_CHARACTER1 {
    public static void main(String[] args) throws Exception {
        SoapCharacterService service = new CharacterService().getSoapCharacterServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "v2B9F0NV";

        String s = service.requestString(studentCode, qCode);
        String res = new StringBuilder(s).reverse().toString();

        service.submitString(studentCode, qCode, res);
    }
}
