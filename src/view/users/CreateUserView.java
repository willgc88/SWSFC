package view.users;

import users.service.createUser.interface_adapter.CreateUserController;
import users.service.createUser.interface_adapter.CreateUserState;
import users.service.createUser.interface_adapter.CreateUserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateUserView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create user";

    private final CreateUserViewModel createUserViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final CreateUserController createUserController;
    private final JButton createUser;
    private final JButton exit;

    public CreateUserView(CreateUserController controller, CreateUserViewModel createUserViewModel) {

        this.createUserController = controller;
        this.createUserViewModel = createUserViewModel;
        createUserViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CreateUserViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(CreateUserViewModel.USERNAME_LABEL), usernameInputField);

        JPanel buttons = new JPanel();
        createUser = new JButton(CreateUserViewModel.CREATE_USER_BUTTON_LABEL);
        buttons.add(createUser);
        exit = new JButton(CreateUserViewModel.EXIT_BUTTON_LABEL);
        buttons.add(exit);

        createUser.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createUser)) {
                            CreateUserState currentState = createUserViewModel.getState();

                            createUserController.execute(
                                    currentState.getUsername()
                            );
                        }
                    }
                }
        );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateUserState currentState = createUserViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        createUserViewModel.setState(currentState);
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
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateUserState state = (CreateUserState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}
