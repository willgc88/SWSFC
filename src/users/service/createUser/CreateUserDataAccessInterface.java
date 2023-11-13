package users.service.createUser;
import users.entity.User;

public interface CreateUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
