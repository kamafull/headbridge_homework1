import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gleb Gavrilov
 * @version 02.10.2023 10:30 (mac)
 * description -
 */
@Data
public class Commands {
    private static Map<Integer, String> commands = new HashMap<Integer, String>() {{
        put(1, "Добавьте нового ученика");
        put(2, "Удалите ученика");
        put(3, "Обновите оценку ученика");
        put(4, "Просмотр оценок всех учащихся");
        put(5, "Просмотр оценок конкретного учащегося");
        put(0, "Выйти из программы");
    }};

    static void printCommands() {
        System.out.println("Введите только число!!!");
        for (Map.Entry<Integer, String> entry : commands.entrySet()) {
            System.out.println("Введите " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
