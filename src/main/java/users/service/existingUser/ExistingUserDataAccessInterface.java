package users.service.existingUser;

import users.entity.User;

public interface ExistingUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
