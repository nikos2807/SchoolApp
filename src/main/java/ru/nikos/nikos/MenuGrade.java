package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuGrade {
    private StudentManager studentManager;

    public MenuGrade(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    private boolean choice() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы можете работать с оценками ученика");
        System.out.println("Есть выбор методов по работе с оценками");
        System.out.println("1 - добавить оценку у ученика\n" +
                "2 - получить данные с таблицы оценок\n" +
                "3 - завершить работу");
        System.out.println("Выберите команду");
        int command = scanner.nextInt();
        if (command == 1) {
            System.out.println("Введите id");
            int id = scanner.nextInt();
            System.out.println("Введите id ученика, у которого хотите добавить оценку");
            int schoolchildren_id = scanner.nextInt();
            System.out.println("выберите предмет");
            studentManager.selectItems();
            int item_id = scanner.nextInt();
            System.out.println("Введите какую оценку хотите поставить");
            int grade = scanner.nextInt();
            studentManager.insertGrade(id, schoolchildren_id, item_id, grade);
            System.out.println("Оценка успешно добавлена");
        } else if (command == 2) {
            studentManager.selectGrades();
        } else {
            System.out.println("Вы успешно завершили работу");
            studentManager.getConnectionManager().getConnection().close();
            return false;
        }
        return true;
    }
}
