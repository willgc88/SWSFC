import draft.finalDraft.interfaceAdapters.FinalDraftState;
import org.junit.Before;
import org.junit.Test;
import view.FinalDraftViewModel;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FinalDraftViewModelTest {

    private FinalDraftViewModel finalDraftViewModel;
    private TestPropertyChangeListener testListener;

    @Before
    public void setUp() {
        finalDraftViewModel = new FinalDraftViewModel();
        testListener = new TestPropertyChangeListener();
        finalDraftViewModel.addPropertyChangeListener(testListener);
    }

    @Test
    public void testSetTitleLabel() {
        assertEquals("Final Draft", FinalDraftViewModel.TITLE_LABEL);
    }

    @Test
    public void testSetState() {
        // Arrange
        FinalDraftState newState = new FinalDraftState(/* provide necessary data */);

        // Act
        finalDraftViewModel.setState(newState);

        // Assert
        assertNotNull(finalDraftViewModel.getState());
        assertEquals(newState, finalDraftViewModel.getState());
    }

    @Test
    public void testFirePropertyChanged() {
        // Act
        finalDraftViewModel.firePropertyChanged();

        // Assert
        assertEquals(finalDraftViewModel.getState(), testListener.getLastReceivedState());
    }

    // Helper class for testing property changes
    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private FinalDraftState lastReceivedState;

        @Override
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            if ("state".equals(evt.getPropertyName())) {
                lastReceivedState = (FinalDraftState) evt.getNewValue();
            }
        }

        public FinalDraftState getLastReceivedState() {
            return lastReceivedState;
        }
    }
}
