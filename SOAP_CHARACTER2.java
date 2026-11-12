import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import WS.character.CharacterService;
import WS.character.SoapCharacterService;

public class SOAP_CHARACTER2 {
    public static void main(String[] args) throws Exception {
        SoapCharacterService service = new CharacterService().getSoapCharacterServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "SX3iqOut";

        List<String> a = service.requestStringArray(studentCode, qCode);
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i).replaceAll("email=\\S+", "email=[EMAIL]")
                    .replaceAll("phone=\\S+", "phone=[PHONE]")
                    .replaceAll("token=\\S+", "token=[TOKEN]");
            a.set(i, s);
        }
        List<String> levels = Arrays.asList("ERROR", "WARN", "INFO");
        a.sort(Comparator.comparingInt(s -> levels.indexOf(s.split(" ")[0])));

        service.submitStringArray(studentCode, qCode, a);
    }
}
