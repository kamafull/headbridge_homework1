import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gleb Gavrilov
 * @version 03.10.2023 10:43 (mac)
 * description -
 */
public class FileWorker {
    static final String fileName = "/Users/ggm/Desktop/homework1/db.txt";

    static Map<String, Integer> readFile(){
        File file = new File(fileName);
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            JSONObject startInfo = new JSONObject(br.readLine());
            for (String keyStr : startInfo.keySet()) {
                Object keyvalue = startInfo.get(keyStr);
                map.put(keyStr, (Integer) keyvalue);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return map;
    }

    static void saveData(Map<String, Integer> map) throws IOException {
        JSONObject jsonObject = new JSONObject(map);
        FileWriter writer = new FileWriter(fileName);
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }
}
