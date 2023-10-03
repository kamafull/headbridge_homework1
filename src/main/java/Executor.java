import java.io.IOException;
import java.util.Map;

/**
 * @author Gleb Gavrilov
 * @version 02.10.2023 10:41 (mac)
 * description -
 */
public class Executor {
    static Map<String, Integer> map = FileWorker.readFile();

    void addStudent(String userName) throws IOException {
        map.put(userName, null);
        FileWorker.saveData(map);
        System.out.println("Ученик " + userName + " добавлен");
    }

    void deleteStudent(String userName) throws IOException {
        if (map.containsKey(userName)){
            map.remove(userName);
            FileWorker.saveData(map);
            System.out.println("Ученик "  + userName + " удален");
        } else {
            System.out.println("Ученик "  + userName + " не найден");
        }
    }

    void updateStudent(String[] s) throws IOException {
        if (s.length == 2) {
            String userName = s[0];
            Integer a;
            try {
                a = Integer.valueOf(s[1]);
            } catch (NumberFormatException e){
                System.out.println("Оценка введена в неправильно формате");
                return;
            }
            if (map.containsKey(userName)) {
                map.put(userName, a);
                FileWorker.saveData(map);
                System.out.println("Ученик " + userName + " обновлен");
            } else {
                System.out.println("Ученик " + userName + " не найден");
            }
        } else {
            System.out.println("Неправильно введены данные");
        }
    }

    void getAllData() {
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Имя ученика " + entry.getKey() + " оценка " + entry.getValue());
        }
    }

    void getDataByUser(String userName) {
        if (map.containsKey(userName)) {
            System.out.println("Оценка ученика " + userName + " " + map.get(userName));
        } else {
            System.out.println("Ученик "  + userName + " не найден");
        }
    }
}
