package ru.nikos.nikos;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private DataSource dataSource;
    private Connection connection;
    private String user = "root";
    private String password = "12345678";

    public ConnectionManager() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(3306);
        ds.setDatabaseName("schoolapp");
        ds.setUser(user);
        ds.setPassword(password);

        this.dataSource = ds;
        this.connection = dataSource.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
}
