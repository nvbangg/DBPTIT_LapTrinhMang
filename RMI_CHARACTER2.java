import java.rmi.Naming;
import RMI.CharacterService;

public class RMI_CHARACTER2 {
    public static void main(String[] args) throws Exception {
        CharacterService service = (CharacterService) Naming.lookup("rmi://36.50.135.242/RMICharacterService");
        String studentCode = "B23DCCN067";
        String qCode = "wWlXqfMz";

        int n = Integer.parseInt(service.requestCharacter(studentCode, qCode));
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res = "";
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                res += roman[i];
                n -= values[i];
            }
        }

        service.submitCharacter(studentCode, qCode, res);
    }
}
