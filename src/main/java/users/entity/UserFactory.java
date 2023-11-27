package users.entity;


public interface UserFactory {
    /** Requires: password is valid. */
    User create(String name);
}
