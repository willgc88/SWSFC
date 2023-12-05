package draft.finalDraft.interfaceAdapters;

import draft.DraftState;
import draft.finalDraft.interfaceAdapters.FinalDraftState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FinalDraftViewModel {
    public static final String TITLE_LABEL = "Final Draft";
    private FinalDraftState state = new FinalDraftState();
    public FinalDraftViewModel() { super("draft"); }
    public void setState(FinalDraftState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() { support.firePropertyChange("state", null, this.state); }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public FinalDraftState getState() {
        return state;
    }
}
