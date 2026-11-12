import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import WS.character.CharacterService;
import WS.character.SoapCharacterService;

public class WS_CHARACTER2 {
    public static void main(String[] args) throws Exception {
        SoapCharacterService service = new CharacterService().getSoapCharacterServicePort();
        String studentCode = "B23DCCN067";
        String qCode = "RoIwRzSu";

        List<String> words = service.requestStringArray(studentCode, qCode);
        Map<Integer, List<String>> groups = new TreeMap<>();
        for (String word : words) {
            int count = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) count++;
            }
            if (!groups.containsKey(count)) groups.put(count, new ArrayList<>());
            groups.get(count).add(word);
        }
        List<String> res = new ArrayList<>();
        for (List<String> group : groups.values()) {
            Collections.sort(group);
            // Hệ thống chấm yêu cầu danh sách từng từ, không ghép mỗi nhóm thành một chuỗi.
            res.addAll(group);
        }

        service.submitCharacterStringArray(studentCode, qCode, res);
    }
}
