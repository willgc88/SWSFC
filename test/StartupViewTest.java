import org.junit.Before;
import org.junit.Test;
import view.startup.StartupController;
import view.startup.StartupView;
import view.startup.StartupViewModel;

import java.awt.event.ActionEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StartupViewTest {
    private StartupViewModel startupViewModel;
    private StartupController startupController;
    private StartupView startupView;

    @Before
    public void setUp() {
        startupViewModel = new StartupViewModel();
        startupController = mock(StartupController.class);
        startupView = new StartupView(startupViewModel, startupController);
    }

    @Test
    public void testSignupButtonActionPerformed() {
        // Trigger the signup button action
        ActionEvent actionEvent = new ActionEvent(startupView.getSignupButton(), ActionEvent.ACTION_PERFORMED, "Signup");
        startupView.getSignupButton().getActionListeners()[0].actionPerformed(actionEvent);

        // Verify that the controller's execute method was called with the correct argument
        verify(startupController).execute(false);
    }

    @Test
    public void testLoginButtonActionPerformed() {
        // Trigger the login button action
        ActionEvent actionEvent = new ActionEvent(startupView.getLoginButton(), ActionEvent.ACTION_PERFORMED, "Login");
        startupView.getLoginButton().getActionListeners()[0].actionPerformed(actionEvent);

        // Verify that the controller's execute method was called with the correct argument
        verify(startupController).execute(true);
    }

}
