package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {}
    public void createUsersTable() {try {
               Statement statement = Util.getConnectionJDBS().createStatement();
               statement.executeUpdate("create table users2(" +
                       "id INT(10)not null auto_increment  primary key ," +
                       "name VARCHAR(64)," +
                       "lastname VARCHAR(64), " +
                       "age INT(3))");
               System.out.println("Creation is comзleted");
               statement.close();
           }catch (SQLException e){
               System.out.println("Creation table is failed because "+e.getMessage());
           }}
    public void dropUsersTable() {
        try {
            Statement statement = Util.getConnectionJDBS().createStatement();
            statement.executeUpdate("drop table users2");
            System.out.println("Deletion is completed");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete is failed"+e.getMessage());

        }
    }
    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement statement = Util.getConnectionJDBS().createStatement();
            statement.execute("insert into users2(name,lastname,age) values " +
                    "('"+name+"','"+lastName+"',"+age+")");
            statement.close();
        }catch (SQLException e){
            System.out.println("Error adding a user "+name+"!"+e.getMessage());
        }
    }
    public void saveUser(User user) {try {
            Statement statement = Util.getConnectionJDBS().createStatement();
            statement.execute("insert into users2(name,lastname,age) values " +
                    "('"+user.getName()+"','"+user.getLastName()+"',"+user.getAge()+")");
            statement.close();
        }catch (SQLException e){
            System.out.println("Error adding a user "+user.getName()+"!"+e.getMessage());
        }}
    public void removeUserById(long id) {try{
            Statement statement = Util.getConnectionJDBS().createStatement();
            statement.execute("delete from users2 where id ="+id);
            statement.close();
        }catch (SQLException e ){
            System.out.println("remove is failed"+e.getMessage());
        }}

    public List<User> getAllUsers() {List<User> users = new ArrayList<User>();try {
            Statement statement = Util.getConnectionJDBS().createStatement();
            ResultSet rs = statement.executeQuery("select * from users2");
            while (rs.next()) {
                String id = rs.getObject(1).toString();
                String name = rs.getObject(2).toString();
                String lastname = rs.getObject(3).toString();
                String age = rs.getObject(4).toString();
                User user = new User(Integer.parseInt(id),name, lastname, Byte.parseByte(age));
                users.add(user);
                System.out.println("id number is: " + id + "   | name is: " + name + "  |  lastName is:  " + lastname + " |   age is:" + age);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Showing to console is failed");
        }return null;}

    public void cleanUsersTable() {try {
           Statement statement = Util.getConnectionJDBS().createStatement();
           statement.executeUpdate("delete   from users2 where id>0 ");
       }catch (SQLException e ){
           System.out.println("clean is failed because"+e.getMessage());
       }}
}
