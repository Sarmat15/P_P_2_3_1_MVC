package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager em;

    public UserDaoImpl() {
    }


    @Override
    public List getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {

        em.persist(user);

    }

    @Override
    public void update(int id, User user) {
        User userForUpdate = getUser(id);
        userForUpdate.setName(user.getName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setAge(user.getAge());
        userForUpdate.setPhoneNumber(user.getPhoneNumber());

    }

    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));

    }
}
