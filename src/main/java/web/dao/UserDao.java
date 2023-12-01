package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void save(User user);

    void removeById(long id);

    User getById(long id);

    void update(User user, long id);
}
