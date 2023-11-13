package users.service.createUser.interface_adapter;

import users.service.createUser.CreateUserInputData;
import users.service.createUser.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateUserViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create User View";
    public static final String USERNAME_LABEL = "Choose username";

    public static final String CREATE_USER_BUTTON_LABEL = "Create User";
    public static final String EXIT_BUTTON_LABEL = "Exit";

    private CreateUserState state = new CreateUserState();

    public CreateUserViewModel() {
        super("create user");
    }

    public void setState(CreateUserState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public CreateUserState getState() {
        return state;
    }
}
