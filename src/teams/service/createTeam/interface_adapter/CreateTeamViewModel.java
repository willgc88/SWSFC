package teams.service.createTeam.interface_adapter;

import users.service.createUser.interface_adapter.CreateUserState;
import view.ViewModel;
import view.teams.CreateTeamView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateTeamViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create a new team";
    public static final String CREATE_TEAM_BUTTON_LABEL = "create team";

    private CreateTeamState state = new CreateTeamState();
    public CreateTeamViewModel() {
        super("create team");
    }

    public void setState(CreateTeamState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getViewName() {
        return null;
    }
    public CreateTeamState getState() {
        return state;
    }

}
