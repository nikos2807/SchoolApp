package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuManager {

    private StudentManager studentManager;

    public MenuManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    /**
     * Метод в котором запускается моя программа
     *
     * @throws SQLException
     */
    public void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("let's move on");
        String in = scanner.next();
        System.out.println("Здравствуйте");
        System.out.println("Моя программа даст вам доступ к базе данных \n" +
                "школы номер 15");
        if (in != null) {
                while (true) {
                    if (!choice()) {
                        break; // выход из цикла
                    }
                }

        } else {
            studentManager.getConnectionManager().getConnection().close();
        }


    }

    /**
     * Метод где выстроенная логика моей программы
     *
     * @return
     * @throws SQLException
     */
    private boolean choice() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы можете работать с базой данных");
        System.out.println("Есть выбор методов которые вы можете использовать ");
        System.out.println("1-Добавление в таблицу \n " +
                "2-Удаление с таблицы \n " +
                "3-Обновить таблицу \n " +
                "4- Получение данных с таблицы учеников\n" +
                "5-добавить оценку у ученика\n" +
                "6-Получение данных с таблицы оценок\n" +
                "7-Получение данных с таблицы предметов\n" +
                "8-Получение лучших учеников\n" +
                "9-Добавить предмет\n"+
                "10- завершить работу");
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

        } else if (command == 6) {
            studentManager.selectGrades();

        } else if (command == 7) {
            studentManager.selectItems();
        }else if (command == 8){
            studentManager.SelectBestStudent();
        }else if (command == 9){
            System.out.println("Введите id");
            int id = scanner.nextInt();
            System.out.println("Введите name предмета");
            String name = scanner.next();
            studentManager.createItem(id, name);
        }
        else {
            System.out.println("Вы успешно завершили работу");
            studentManager.getConnectionManager().getConnection().close();
            return false;
        }
        return true;
    }
}