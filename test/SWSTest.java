import draft.DraftController;
import draft.DraftInputBoundary;
import draft.finalDraft.FinalDraftInputBoundary;
import draft.finalDraft.interfaceAdapters.FinalDraftController;
import draft.finalDraft.interfaceAdapters.FinalDraftState;
import org.junit.Before;
import org.junit.Test;
import teams.entity.Player;
import users.service.createUser.CreateUserInputBoundary;
import users.service.createUser.interface_adapter.CreateUserController;
import users.service.createUser.interface_adapter.CreateUserViewModel;
import users.service.existingUser.ExistingUserInputBoundary;
import users.service.existingUser.interface_adapter.ExistingUserController;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.DraftViewModel;
import view.FinalDraftViewModel;
import view.LabelTextPanel;
import view.draft.DraftView;
import view.draft.FinalDraftView;
import view.users.CreateUserView;
import view.users.ExistingUserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

// TODO: write test cases for SWSFC
public class SWSTest {

    @org.junit.Test
    public void testCreateUserView() {

        // create the UI; note, we don't make a real SignupInputBoundary,
        // since we don't need it for this test.
        CreateUserInputBoundary cuib = null;
        CreateUserController controller = new CreateUserController(cuib);
        CreateUserViewModel viewModel = new CreateUserViewModel();
        JPanel createUserView = new CreateUserView(controller, viewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(createUserView);
        jf.pack();
        jf.setVisible(true);

        // get a reference to the first password field
        LabelTextPanel panel = (LabelTextPanel) createUserView.getComponent(1);
        JTextField userField = (JTextField) panel.getComponent(1);

        // create and dispatch KeyEvents to the UI
        KeyEvent event = new KeyEvent(
                userField, // we are interacting with the userField
                KeyEvent.KEY_TYPED, //
                System.currentTimeMillis(), // say the event happened right now
                0, // no modifiers
                KeyEvent.VK_UNDEFINED, // for KEY_TYPED, the KeyCode is undefined per documentation
                'c'); // the character that is being typed

        panel.dispatchEvent(event);


        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(userField.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        // move to the right in the password field, otherwise the event
        // will type the character as the first character instead of the last!
        KeyEvent eventRight = new KeyEvent(
                userField,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        panel.dispatchEvent(eventRight);

        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // type a second character
        KeyEvent event2 = new KeyEvent(
                userField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'r');
        panel.dispatchEvent(event2);


        // pause execution for 3 seconds
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(userField.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        // assert that the values are as expected.
        assertEquals("cr", new String(userField.getText()));
        assertEquals("cr", viewModel.getState().getUsername());
    }

    @org.junit.Test
    public void testExistingUserView() {

        // create the UI; note, we don't make a real SignupInputBoundary,
        // since we don't need it for this test.
        ExistingUserInputBoundary euib = null;
        ExistingUserController controller = new ExistingUserController(euib);
        ExistingUserViewModel viewModel = new ExistingUserViewModel();
        JPanel existingUserView = new ExistingUserView(viewModel, controller);
        JFrame jf = new JFrame();
        jf.setContentPane(existingUserView);
        jf.pack();
        jf.setVisible(true);

        // get a reference to the first password field
        LabelTextPanel panel = (LabelTextPanel) existingUserView.getComponent(1);
        JTextField userField = (JTextField) panel.getComponent(1);

        // create and dispatch KeyEvents to the UI
        KeyEvent event = new KeyEvent(
                userField, // we are interacting with the userField
                KeyEvent.KEY_TYPED, //
                System.currentTimeMillis(), // say the event happened right now
                0, // no modifiers
                KeyEvent.VK_UNDEFINED, // for KEY_TYPED, the KeyCode is undefined per documentation
                'e'); // the character that is being typed

        panel.dispatchEvent(event);


        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(userField.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        // move to the right in the password field, otherwise the event
        // will type the character as the first character instead of the last!
        KeyEvent eventRight = new KeyEvent(
                userField,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        panel.dispatchEvent(eventRight);

        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // type a second character
        KeyEvent event2 = new KeyEvent(
                userField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'x');
        panel.dispatchEvent(event2);


        // pause execution for 3 seconds
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(userField.getText()));
        System.out.println("view-model: " + viewModel.getState().getUsername());

        // assert that the values are as expected.
        assertEquals("ex", new String(userField.getText()));
        assertEquals("ex", viewModel.getState().getUsername());
    }

    @org.junit.Test
    public void testDraftView() {
        DraftInputBoundary duib = null;
        DraftController draftController = new DraftController(duib);
        DraftViewModel draftViewModel = new DraftViewModel();
        DraftView draftViewPanel = new DraftView(draftController, draftViewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(draftViewPanel);
        jf.pack();
        jf.setVisible(true);

        // get a reference to one of the JComboBox components
        JComboBox<String> p1ComboBox = draftViewPanel.getP1ComboBox();

        // create and dispatch ActionEvent to the JComboBox
        ActionEvent event = new ActionEvent(
                p1ComboBox, // we are interacting with the p1ComboBox
                ActionEvent.ACTION_PERFORMED,
                "Item selected"
        );
        p1ComboBox.setSelectedIndex(1);
        p1ComboBox.getActionListeners()[0].actionPerformed(event);

        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values of the JComboBox and view-model
        System.out.println("Selected item in JComboBox: " + p1ComboBox.getSelectedItem());
        System.out.println("view-model state: " + draftViewModel.getState());

        // assert that the values are as expected.
        assertEquals("Second Item", p1ComboBox.getSelectedItem());
    }

}





