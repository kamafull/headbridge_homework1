import java.io.IOException;
import java.util.Scanner;

/**
 * @author Gleb Gavrilov
 * @version 02.10.2023 10:28 (mac)
 * description -
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Executor executor = new Executor();
        Scanner in = new Scanner(System.in);
        Commands.printCommands();
        boolean active = true;
        while (active) {
            String c = in.nextLine().replaceAll("\\s", "");
            int a = Integer.parseInt(c);
            if (a == 1) {
                String b = in.nextLine();
                executor.addStudent(b);
                System.out.println();
                Commands.printCommands();
            }
            if (a == 2) {
                String b = in.nextLine();
                executor.deleteStudent(b);
                System.out.println();
                Commands.printCommands();
            }
            if (a == 3) {
                System.out.println("Введите имя ученика и оценку через пробел");
                String b = in.nextLine();
                String[] s = b.split(" ");
                executor.updateStudent(s);
                System.out.println();
                Commands.printCommands();
            }
            if (a == 4) {
                executor.getAllData();
                System.out.println();
                Commands.printCommands();
            }
            if (a == 5) {
                String b = in.nextLine();
                executor.getDataByUser(b);
                System.out.println();
                Commands.printCommands();
            }
            if (a == 0){
                active = false;
                System.out.println("Программа стоп");
            }
        }
        in.close();
    }
}
