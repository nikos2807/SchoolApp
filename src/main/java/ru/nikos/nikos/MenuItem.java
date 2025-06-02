package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuItem {
    private StudentManager studentManager;

    public MenuItem(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    private boolean choice() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы можете работать с предметами ученика");
        System.out.println("Есть выбор методов по работе с предметами");
        System.out.println("1 - Добавить предмет\n" +
                "2 - получить данные с таблицы предметы\n" +
                "3 - завершить работу");
        int command = scanner.nextInt();
        if (command == 1) {
            System.out.println("Введите id");
            int id = scanner.nextInt();
            System.out.println("Введите name предмета");
            String name = scanner.next();
            studentManager.createItem(id, name);
        } else if (command == 2) {
            studentManager.selectItems();
        } else {
            System.out.println("Вы успешно завершили работу");
            studentManager.getConnectionManager().getConnection().close();
            return false;
        }
        return true;
    }
}
