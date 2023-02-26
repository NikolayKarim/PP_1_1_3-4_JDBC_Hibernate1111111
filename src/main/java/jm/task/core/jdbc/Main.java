package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;

import java.sql.Statement;


public class Main {
    public static void showInfoAll(Statement statement) {

    }
    public static void main(String[] args) {
        User user1 = new User(1,"Вася", "Popov", (byte) 34);
        User user2 = new User(2,"Genadiy", "Golovkin", (byte)40);
        User user3 = new User(3,"Angelina", "Joly", (byte) 45);
        User user4 = new User(4,"Madonna", "Shalava", (byte)80);// four users

        //new UserDaoHibernateImpl().createUsersTable();
       // new UserDaoHibernateImpl().dropUsersTable();
       // new UserDaoHibernateImpl().removeUserById(1);
//        List<User> users = new UserDaoHibernateImpl().getAllUsers();
//        users.stream().forEach(System.out::println);






//
//        Session sessionRead = Util.getConnectionHiber().openSession();
//        Transaction trRead = sessionRead.beginTransaction();
//         User userRead = sessionRead.find(User.class, 2);
//        System.out.println(userRead.toString());
//        trRead.commit();
//        sessionRead.close();

//           Session sessionUpdate = Util.getConnectionHiber().openSession();
//           Transaction trUpdate = sessionUpdate.beginTransaction();
//           User userUpdate = sessionUpdate.find(User.class, 1);
//           userUpdate.setName("Вася8");
//           sessionUpdate.update(userUpdate);
//           System.out.println(userUpdate.toString());
//           trUpdate.commit(); sessionUpdate.close();
//

    }
}
