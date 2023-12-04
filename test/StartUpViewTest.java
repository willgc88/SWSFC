import org.testng.annotations.Test;
import view.startup.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartUpViewTest {
    @Test
    public void testStartupView() {
        StartupInputBoundary suib = new StartupInteractor(null);
        StartupController startupController = new StartupController(suib);
        StartupViewModel startupViewModel = new StartupViewModel();
        JPanel startupPanel = new StartupView(startupViewModel, startupController);
        JFrame frame = new JFrame();
        frame.setContentPane(startupPanel);
        frame.pack();
        frame.setVisible(true);

        JButton createUserButton = null;
        JButton existingUserButton = null;

        // Iterate over the components and identify the buttons
        for (Component component : startupPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel buttonsPanel = (JPanel) component;
                createUserButton = (JButton) buttonsPanel.getComponent(0);
                existingUserButton = (JButton) buttonsPanel.getComponent(1);
            }
        }

        // Ensure that both buttons are found
        if (createUserButton == null || existingUserButton == null) {
            throw new RuntimeException("Buttons not found in the expected structure");
        }

        // Simulate clicking the Signup button
        ActionEvent signupEvent = new ActionEvent(createUserButton, ActionEvent.ACTION_PERFORMED, "CreateUser");
        createUserButton.getActionListeners()[0].actionPerformed(signupEvent);

        // Simulate clicking the Login button
        ActionEvent loginEvent = new ActionEvent(existingUserButton, ActionEvent.ACTION_PERFORMED, "ExistingUser");
        existingUserButton.getActionListeners()[0].actionPerformed(loginEvent);
    }
}

