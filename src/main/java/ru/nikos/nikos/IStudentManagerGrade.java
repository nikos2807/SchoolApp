package ru.nikos.nikos;

import java.sql.SQLException;

public interface IStudentManagerGrade {
    /**
     * Интерфейс IStudentManagerGrade
     * @param id
     * @param schoolchildren_id
     * @param item_id
     * @param grade
     * @throws SQLException
     */

    void insertGrade(int id, int schoolchildren_id, int item_id, int grade) throws SQLException;

    void selectGrades() throws SQLException;
}
