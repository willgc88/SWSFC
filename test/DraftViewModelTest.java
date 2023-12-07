import draft.DraftState;
import org.junit.Before;
import org.junit.Test;
import view.DraftViewModel;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;

public class DraftViewModelTest {

    private DraftViewModel draftViewModel;
    private TestPropertyChangeListener testListener;

    @Before
    public void setUp() {
        draftViewModel = new DraftViewModel();
        testListener = new TestPropertyChangeListener();
        draftViewModel.addPropertyChangeListener(testListener);
    }

    @Test
    public void testSetTitleLabel() {
        assertEquals("Draft Player Selector", DraftViewModel.TITLE_LABEL);
    }

    @Test
    public void testSetState() {
        // Arrange
        DraftState newState = new DraftState(/* provide necessary data */);

        // Act
        draftViewModel.setState(newState);

        // Assert
        assertEquals(newState, draftViewModel.getState());
    }

    @Test
    public void testFirePropertyChanged() {
        // Act
        draftViewModel.firePropertyChanged();

        // Assert
        assertEquals(draftViewModel.getState(), testListener.getLastReceivedState());
    }

    // Helper classes and methods
    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private DraftState lastReceivedState;

        @Override
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            if ("state".equals(evt.getPropertyName())) {
                lastReceivedState = (DraftState) evt.getNewValue();
            }
        }

        public DraftState getLastReceivedState() {
            return lastReceivedState;
        }
    }
}
