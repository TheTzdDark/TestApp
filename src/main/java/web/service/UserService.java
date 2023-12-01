package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void save(User user);

    void removeById(long id);

    User getById(long id);

    void update(User user, long id);
}
