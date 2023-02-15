package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Parol#23";                                                                       //URL NAME PASSWORD
    public static  String addTotable(User user){
        return "insert into users2(name,lastname,age) values " +
                "('"+user.getName()+"','"+user.getLastName()+"',"+user.getAge()+")";
    }
    public static void setToTable(Statement statement , User user){
        try {
             statement.execute(addTotable(user));
        }catch (SQLException e){
            System.out.println("Error adding a user "+user.getName()+"!"+e.getMessage());
        }
    }
                                                                            //methods for adding users

    public static void showInfoAll(Statement statement) {
        try {
            ResultSet rs = statement.executeQuery("select * from users2");
            while (rs.next()) {
                String id = rs.getObject(1).toString();
                String name = rs.getObject(2).toString();
                String lastname = rs.getObject(3).toString();
                String age = rs.getObject(4).toString();
                System.out.println("id number is: " + id + "   | name is: " + name + "  |  lastName is:  " + lastname + " |   age is:" + age);
            }
        } catch (SQLException e) {
            System.out.println("Showing to console is failed");
        }
    }
    public static void main(String[] args) {
        Connection connection;
        User user1 = new User("Вася", "Popov", (byte) 34);
        User user2 = new User("Genadiy", "Golovkin", (byte)40);
        User user3 = new User("Angelina", "Joly", (byte) 45);
        User user4 = new User("Madonna", "Shalava", (byte)80);                                                                        // four users

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException q) {
            System.out.println("Create driver is failed");
        }                                                                   //creating driver
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            System.out.println("Data base with statements has been opened");                                                                //trying connection
//---------------------------------------- ------------------------------------------------------------
//            setToTable(statement, user3);                               //add user to table
//            setToTable(statement, user4);                               //add user to table
//                                        //add user to table
//             showInfoAll(statement);








//----------------------------------------------------------------------------------------------------
//
//           try {
//               statement.executeUpdate("create table users2(" +
//                       "id INT(10)not null auto_increment  primary key ," +
//                       "name VARCHAR(64)," +
//                       "lastname VARCHAR(64), " +
//                       "age INT(3))");
//           }catch (SQLException e){
//               System.out.println("Create table is failed because "+e.getMessage());
//           }   // create table                                                                       // creating a candidation table
//----------------------------------------------------------------------------------------------------
//
//            statement.execute("insert into users2(id, name,lastname,age) values " +
//                    "(1,'jorra', 'headov',45)");
//            System.out.println("User с именем jarra добавлен в бд");
//            statement.execute("insert into users2(id, name,lastname,age) values " +
//                    "(2,'George', 'Brainoc',34)");
//            System.out.println("User с именем George добавлен в бд");
//            statement.execute("insert into users2(id, name,lastname,age) values " +
//                    "(3,'Stamach', 'Tothov',63)");
//            System.out.println("User с именем Stamach добавлен в бд");
//            statement.execute("insert into users2(id, name,lastname,age) values " +
//                    "(4,'Uncle', 'Auntov',23)");
//            System.out.println("User с именем Uncle добавлен в бд");
//                                                                                                                                          //adding users directly

                  statement.executeUpdate("drop table users2");                //delete table
//----------------------------------------------------------------------------------------------------

//            Создание таблицы User(ов)
//            Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//            Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//            Очистка таблицы User(ов)
//     Удаление таблицы
//
//
//---------------------------------------------------------------------------------------------------------------------
            connection.close();
            System.out.println("Data base is closed ");
        } catch (SQLException e) {
            System.err.println("Connection is failed" + " " + e.getMessage());

        }
                                              // cod's end

    }
}
