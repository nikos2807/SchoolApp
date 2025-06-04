package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuStudent {

    private StudentManager studentManager;

    public MenuStudent(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    /**
     * Метод где выстроенная логика моей программы
     *
     * @return
     * @throws SQLException
     */
    public boolean choice() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы можете работать с базой данных");
        System.out.println("Есть выбор методов которые вы можете использовать ");
        System.out.println("1-Добавить ученика\n " +
                "2-Удалить ученика \n " +
                "3-Обновить ученика \n " +
                "4- Получение данных с таблицы учеников\n" +
                "5-Получение лучших учеников\n" +
                "6- завершить работу");
        System.out.println("Выберите команду");
        int command = scanner.nextInt();
        if (command == 1) {
            System.out.println("Введите id");
            int id = scanner.nextInt();
            System.out.println("Введите name");
            String name = scanner.next();
            System.out.println("Введите surname");
            String surname = scanner.next();
            System.out.println("Введите age");
            System.out.println("Введите возраст чтобы он был >7 и <=17");
            int age = scanner.nextInt();
            studentManager.create(id, name, surname, age);
            System.out.println("Ученик успешно добавлен");
        } else if (command == 2) {
            System.out.println("Введите id ученика которого хотите удалить");
            studentManager.select();
            int id = scanner.nextInt();
            studentManager.delete(id);
            System.out.println("Ученик успешно удален");
        } else if (command == 3) {
            System.out.println("Введите id ученика,которого хотите обновить");
            int id = scanner.nextInt();
            System.out.println("Введите колонку по которой хотите изменить ученика: \n" +
                    "Выбор колонок \n" +
                    "1-age \n" +
                    "2-name \n" +
                    "3-surname \n");
            int column = scanner.nextInt();
            if (column == 1) {
                System.out.println("Введите возраст чтобы он был >7 и <=17");
                int age = scanner.nextInt();
                studentManager.updateByAge(id, age);
                System.out.println("Ученик успешно обновлен");
            } else if (column == 2) {
                System.out.println("Введите имя");
                String name = scanner.next();
                studentManager.updateByName(id, name);
                System.out.println("Ученик успешно обновлен");
            } else {
                System.out.println("Введите фамилию");
                String surname = scanner.next();
                studentManager.updateBySurname(id, surname);
                System.out.println("Ученик успешно обновлен");
            }
        } else if (command == 4) {
            studentManager.select();

        } else if (command == 5) {
            studentManager.SelectBestStudent();
        } else {
            System.out.println("Вы успешно завершили работу");
            studentManager.getConnectionManager().getConnection().close();
            return false;
        }
        return true;
    }
}