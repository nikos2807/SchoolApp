package ru.nikos.nikos;
import java.sql.SQLException;

public class SchoolApp {
    private final StudentManager studentManager;
    private final ConnectionManager connectionManager;
    private final MainMenu mainMenu;

    /**
     * Класс где установлены все соединения моей программы
     * @throws SQLException
     */

    public SchoolApp() throws SQLException {
        this.connectionManager = createConnectionManager();
        this.studentManager = createStudentManager(connectionManager);
        this.mainMenu = createMenuManager(studentManager);
    }

    public StudentManager createStudentManager(ConnectionManager connectionManager) throws SQLException {
        return new StudentManager(connectionManager);
    }

    public ConnectionManager createConnectionManager() throws SQLException {
        return new ConnectionManager();
    }

    public MainMenu createMenuManager(StudentManager studentManager) throws SQLException {
        return new MainMenu(studentManager);
    }

    public void start() throws SQLException {
        mainMenu.start();
    }
}
