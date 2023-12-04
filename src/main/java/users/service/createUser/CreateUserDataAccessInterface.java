package users.service.createUser;
import users.entity.User;

import users.entity.HumanUser;

public interface CreateUserDataAccessInterface {
    User get(String username);

    boolean existsByName(String identifier);

    void save(User user);
}
