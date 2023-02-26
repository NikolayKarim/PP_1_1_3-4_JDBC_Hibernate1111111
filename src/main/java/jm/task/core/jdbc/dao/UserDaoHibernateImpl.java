package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getConnectionHiber().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE  users2 " +
                "(id INT NOT NULL  PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age int NOT NULL)";
        session.createSQLQuery(sql).addEntity(User.class);
        transaction.commit();session.close();


    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getConnectionHiber().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("DROP table  users2").executeUpdate();
        transaction.commit();session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }
    public void saveUser(User user) {
        Session sessionCreate = Util.getConnectionHiber().openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        sessionCreate.save(user);
        trCreate.commit();
        sessionCreate.close();

    }

    @Override
    public void removeUserById(long id) {
           Session sessionDelete = Util.getConnectionHiber().openSession();
           Transaction trDelete = sessionDelete.beginTransaction();
           sessionDelete.delete(id);
           trDelete.commit(); sessionDelete.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getConnectionHiber().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = session.createQuery(all);

        return allQuery.getResultList();
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getConnectionHiber().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("delete  from users2").executeUpdate();
        transaction.commit();session.close();
    }

}
