package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    @Transactional()
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional()
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional()
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    @Transactional()
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional()
    public void delete(int id) {
        userDao.delete(id);
    }
}
