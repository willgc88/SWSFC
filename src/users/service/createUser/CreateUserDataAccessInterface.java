package users.service.createUser;

import users.entity.HumanUser;

public interface CreateUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(HumanUser user);
}
