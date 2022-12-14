package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;




    @Override
    public List getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {

        entityManager.persist(user);

    }

    @Override
    public void update(int id, User user) {


    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));

    }
}
