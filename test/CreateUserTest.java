import org.testng.annotations.Test;
import users.service.createUser.CreateUserInputBoundary;
import users.service.createUser.interface_adapter.CreateUserController;
import users.service.createUser.interface_adapter.CreateUserViewModel;
import view.LabelTextPanel;
import view.users.CreateUserView;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class CreateUserTest {
    @Test
    public void createUserViewTest() {

        CreateUserInputBoundary cuib = null;
        CreateUserController controller = new CreateUserController(cuib);
        CreateUserViewModel viewModel = new CreateUserViewModel();
        JPanel createUserView = new CreateUserView(controller, viewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(createUserView);
        jf.pack();
        jf.setVisible(true);

        LabelTextPanel usernamePanel = (LabelTextPanel) createUserView.getComponent(1);
        JTextField usrfield = (JTextField) usernamePanel.getComponent(1);

        KeyEvent event = new KeyEvent(
                usrfield,
                KeyEvent.KEY_TYPED, //
                System.currentTimeMillis(),
                0, // no modifiers
                KeyEvent.VK_UNDEFINED,
                'u');

        createUserView.dispatchEvent(event);


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
        createUserView.dispatchEvent(eventRight);

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
        createUserView.dispatchEvent(event2);


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

