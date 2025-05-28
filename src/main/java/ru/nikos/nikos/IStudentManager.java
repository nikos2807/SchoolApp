package ru.nikos.nikos;

import java.sql.SQLException;

public interface IStudentManager {
    /**
     * Интерфейс StudentManager
     * @param id
     * @param name
     * @param surname
     * @param age
     * @return
     * @throws SQLException
     */
    Student create(int id, String name, String surname, int age) throws SQLException;

    boolean delete(int id) throws SQLException;

    void updateByName(int id, String name) throws SQLException;

    void updateBySurname(int id, String surname) throws SQLException;

    void updateByAge(int id, int age) throws SQLException;

    void select() throws SQLException;

}
