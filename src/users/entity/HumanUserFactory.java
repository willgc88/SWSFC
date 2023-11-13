package users.entity;

public class HumanUserFactory implements UserFactory{
    @Override

    public User create(String name) {
        return new HumanUser(name);
    }
}
