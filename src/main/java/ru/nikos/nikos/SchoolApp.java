package ru.nikos.nikos;
import java.sql.SQLException;

public class SchoolApp {
    private final StudentManager studentManager;
    private final ConnectionManager connectionManager;
    private final MenuManager menuManager;

    /**
     * Класс где установлены все соединения моей программы
     * @throws SQLException
     */

    public SchoolApp() throws SQLException {
        this.connectionManager = createConnectionManager();
        this.studentManager = createStudentManager(connectionManager);
        this.menuManager = createMenuManager(studentManager);
    }

    public StudentManager createStudentManager(ConnectionManager connectionManager) throws SQLException {
        return new StudentManager(connectionManager);
    }

    public ConnectionManager createConnectionManager() throws SQLException {
        return new ConnectionManager();
    }

    public MenuManager createMenuManager(StudentManager studentManager) throws SQLException {
        return new MenuManager(studentManager);
    }

    public void start() throws SQLException {
        menuManager.start();
    }
}
