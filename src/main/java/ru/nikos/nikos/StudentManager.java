package ru.nikos.nikos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IStudentManager, IStudentManagerItem, IStudentManagerGrade {
    private ConnectionManager connectionManager;


    public StudentManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    /**
     * Метод добавление ученика
     *
     * @param id
     * @param name
     * @param surname
     * @param age
     * @throws SQLException
     */
    @Override
    public Student create(int id, String name, String surname, int age) throws SQLException {
        connectionManager.getConnection().prepareStatement("INSERT INTO schoolchildren(id,name,surname,age) values" +
                "(" + id + ",'" + name + "','" + surname + "'," + age + ")").executeUpdate();
        Student newStudent = new Student(id, name, surname, age);
        return newStudent;
    }

    /**
     * Метод, удаление ученика
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(int id) throws SQLException {
        connectionManager.getConnection().prepareStatement("Delete FROM schoolchildren " +
                "where id = " + id + " ").executeUpdate();
        return true;
    }

    /**
     * Метод обновление ученика по имени
     *
     * @param id
     * @param name
     * @throws SQLException
     */
    @Override
    public void updateByName(int id, String name) throws SQLException {
        connectionManager.getConnection().prepareStatement("UPDATE schoolchildren\n " +
                "SET name = '" + name + "' \n" +
                "WHERE id = " + id + " ").executeUpdate();
    }

    /**
     * Метод обновление ученика по фамилии
     *
     * @param id
     * @param surname
     * @throws SQLException
     */
    @Override
    public void updateBySurname(int id, String surname) throws SQLException {
        connectionManager.getConnection().prepareStatement("UPDATE schoolchildren\n " +
                "SET surname = '" + surname + "' \n" +
                "WHERE id = " + id + " ").executeUpdate();
    }

    /**
     * Метод обновление ученика по возрасту
     *
     * @param id
     * @param age
     * @throws SQLException
     */
    @Override
    public void updateByAge(int id, int age) throws SQLException {
        connectionManager.getConnection().prepareStatement("UPDATE schoolchildren\n " +
                "SET age = " + age + "\n " +
                "WHERE id = " + id + " ").executeUpdate();
    }

    public void SelectBestStudent() throws SQLException {

        var result = connectionManager.getConnection().prepareStatement("SELECT \n" +
                "  schoolchildren_id,\n" +
                "  array_agg(grade) AS grades,\n" +
                "  'отличник' AS academic_performance\n" +
                "FROM grades\n" +
                "GROUP BY schoolchildren_id\n" +
                "HAVING bool_and(grade = '5');\n").executeQuery();
        while (result.next()) {
            var column = result.getString(1);
            System.out.println(column);

        }

    }


    /**
     * Метод добавления предмета
     *
     * @param id
     * @param name
     * @throws SQLException
     */
    public void createItem(int id, String name) throws SQLException {
        connectionManager.getConnection().prepareStatement("INSERT INTO items(id , name) values" +
                "('" + id + "','" + name + "')").executeUpdate();

    }

    /**
     * /
     * метод добавления оценки
     *
     * @param id
     * @param schoolchildren_id
     * @param item_id
     * @param grade
     * @throws SQLException
     */
    public void insertGrade(int id, int schoolchildren_id, int item_id, int grade) throws SQLException {
        connectionManager.getConnection().prepareStatement("INSERT INTO grades (id,schoolchildren_id,item_id,grade) values" +
                "(" + id + ",'" + schoolchildren_id + "','" + item_id + "','" + grade + "')").executeUpdate();
    }

    /**
     * Метод вывода всех учеников
     *
     * @throws SQLException
     */
    @Override
    public void select() throws SQLException {
        var result = connectionManager.getConnection().prepareStatement("select * from schoolchildren").executeQuery();
        List<String> resultList = new ArrayList<>();
        while (result.next()) {
            var column1 = result.getString(1);
            var column2 = result.getString(2);
            var column3 = result.getString(3);
            var column4 = result.getString(4);
            resultList.add(column1);
            resultList.add(column2);
            resultList.add(column3);
            resultList.add(column4);
            System.out.println(resultList);
            resultList.clear();
        }
    }

    public void selectGrades() throws SQLException {
        var result = connectionManager.getConnection().prepareStatement("select * from grades").executeQuery();
        List<String> resultList = new ArrayList<>();
        while (result.next()) {
            var column2 = result.getString(2);
            var column3 = result.getString(3);
            var column4 = result.getString(4);
            resultList.add(column2);
            resultList.add(column3);
            resultList.add(column4);
            System.out.println(resultList);
            resultList.clear();

        }

    }

    /**
     * Показать предметы
     *
     * @throws SQLException
     */
    public void selectItems() throws SQLException {
        var result = connectionManager.getConnection().prepareStatement("select * from items").executeQuery();
        List<String> resultList = new ArrayList<>();
        while (result.next()) {
            var column1 = result.getString(1);
            var column2 = result.getString(2);
            resultList.add(column1);
            resultList.add(column2);
            System.out.println(resultList);
            resultList.clear();

        }
    }
}
