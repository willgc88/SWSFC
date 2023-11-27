package view.startup;

import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StartupViewModel extends ViewModel {
    public final String TITLE_LABEL = "Startup View";

    private StartupState state = new StartupState();

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String LOGIN_BUTTON_LABEL = "Log in";

    public StartupViewModel() {
        super("startup");
    }

    public void setState(StartupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public StartupState getState() {
        return state;
    }


}
