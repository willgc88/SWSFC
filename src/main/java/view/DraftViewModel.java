package view;

import draft.DraftState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DraftViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Draft Player Selector";
    private DraftState state = new DraftState();
    public DraftViewModel() { super("draft"); }
    public void setState(DraftState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() { support.firePropertyChange("state", null, this.state); }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DraftState getState() {
        return state;
    }
}
