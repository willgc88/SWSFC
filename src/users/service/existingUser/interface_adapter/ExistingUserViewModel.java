package users.service.existingUser.interface_adapter;
import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExistingUserViewModel extends ViewModel {
    public final String TITLE_LABEL = "Existing User View";
    public final String USERNAME_LABEL = "Enter username";

    public static final String EXISTING_USER_BUTTON_LABEL = "Existing User";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private ExistingUserState state = new ExistingUserState();

    public ExistingUserViewModel() {
        super("existing user");
    }

    public void setState(ExistingUserState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ExistingUserState getState() {
        return state;
    }
}

