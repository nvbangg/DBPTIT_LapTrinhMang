import java.net.URI;
import java.rmi.Naming;
import RMI.CharacterService;

public class RMI_CHARACTER1 {
    public static void main(String[] args) throws Exception {
        CharacterService service = (CharacterService) Naming.lookup("rmi://36.50.135.242/RMICharacterService");
        String studentCode = "B23DCCN067";
        String qCode = "B9djTG98";

        String s = service.requestCharacter(studentCode, qCode);
        String res = new URI(null, null, s, null).toASCIIString();

        service.submitCharacter(studentCode, qCode, res);
    }
}
