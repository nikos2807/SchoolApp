package ru.nikos.nikos;

import java.sql.SQLException;

public interface IManagerItem {
    /**
     * Интерфейс IStudentManagerItem
     * @param id
     * @param name
     * @throws SQLException
     */
    void createItem(int id, String name) throws SQLException;

    void selectItems() throws SQLException;
}
