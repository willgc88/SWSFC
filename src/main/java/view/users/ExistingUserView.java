package view.users;

import users.service.existingUser.interface_adapter.ExistingUserController;
import users.service.existingUser.interface_adapter.ExistingUserState;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ExistingUserView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "existing user";
    private final ExistingUserViewModel existingUserViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JButton existingUser;
    final JButton cancel;
    private final ExistingUserController existingUserController;

    public ExistingUserView(ExistingUserViewModel existingUserViewModel, ExistingUserController controller) {

        this.existingUserController = controller;
        this.existingUserViewModel = existingUserViewModel;
        existingUserViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Existing User");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);

        JPanel buttons = new JPanel();
        existingUser = new JButton(existingUserViewModel.EXISTING_USER_BUTTON_LABEL);
        buttons.add(existingUser);
        cancel = new JButton(existingUserViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        existingUser.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(existingUser)) {
                            ExistingUserState currentState = existingUserViewModel.getState();

                            existingUserController.execute(currentState.getUsername()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ExistingUserState currentState = existingUserViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                existingUserViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ExistingUserState state = (ExistingUserState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(ExistingUserState state) {
        usernameInputField.setText(state.getUsername());
    }

}
