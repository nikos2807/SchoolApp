package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    StudentManager studentManager;
    private MenuStudent menuStudent;
    private MenuGrade menuGrade;
    private MenuItem menuItem;

    public MainMenu(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.menuStudent = new MenuStudent(studentManager);
        this.menuGrade = new MenuGrade(studentManager);
        this.menuItem = new MenuItem(studentManager);
    }

    public void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте");
        System.out.println("Моя программа даст вам доступ к базе данных \n" +
                "школы номер 15");
        System.out.println("Есть выбор меню которым вы можете воспользоваться");
        System.out.println("1 - Меню студент \n" +
                "2 - Меню оценки \n" +
                "3 - Меню предметы");
        System.out.println("Выберите меню");
        int menu = scanner.nextInt();
        if (menu == 1) {
            menuStudent.choice();
        } else if (menu == 2) {
            menuGrade.choice();
        } else if (menu == 3) {
            menuItem.choice();
        } else {
            System.out.println("Неверный выбор меню.");
        }
    }
}
