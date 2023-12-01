import org.testng.annotations.Test;

import users.service.existingUser.ExistingUserInputBoundary;
import users.service.existingUser.interface_adapter.ExistingUserController;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.LabelTextPanel;

import view.users.ExistingUserView;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ExistingUserTest {
    @Test
    public void existingUserViewTest() {

        ExistingUserInputBoundary euib = null;
        ExistingUserController controller = new ExistingUserController(euib);
        ExistingUserViewModel viewModel = new ExistingUserViewModel();
        JPanel existingUserView = new ExistingUserView(viewModel, controller);
        JFrame jf = new JFrame();
        jf.setContentPane(existingUserView);
        jf.pack();
        jf.setVisible(true);

        LabelTextPanel usernamepanel = (LabelTextPanel) existingUserView.getComponent(1);
        JTextField usrfield = (JTextField) usernamepanel.getComponent(1);

        KeyEvent event = new KeyEvent(
                usrfield,
                KeyEvent.KEY_TYPED, //
                System.currentTimeMillis(),
                0, // no modifiers
                KeyEvent.VK_UNDEFINED,
                'u');

        usernamepanel.dispatchEvent(event);


        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("field 1: " + new String(usrfield.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        KeyEvent eventRight = new KeyEvent(
                usrfield,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        usernamepanel.dispatchEvent(eventRight);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        KeyEvent event2 = new KeyEvent(
                usrfield,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                's');
        usernamepanel.dispatchEvent(event2);


        // pause execution for 3 seconds
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("field 1: " + new String(usrfield.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        assertEquals("us", new String(usrfield.getText()));
        assertEquals("us", viewModel.getState().getUsername());
    }
}

