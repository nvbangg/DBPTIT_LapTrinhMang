import java.util.Collections;
import java.util.List;
import WS.character.CharacterService;
import WS.character.SoapCharacterService;

public class WS_CHARACTER1 {
    public static void main(String[] args) throws Exception {
        SoapCharacterService service = new CharacterService().getSoapCharacterServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "tvRP4LWy";

        List<Integer> a = service.requestCharacter(studentCode, qCode);
        Collections.rotate(a, a.get(0));

        service.submitCharacterCharArray(studentCode, qCode, a);
    }
}
