package view.teams;

import teams.service.createTeam.interface_adapter.CreateTeamController;
import teams.service.createTeam.interface_adapter.CreateTeamState;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateTeamView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "create user";

    private final CreateTeamViewModel createTeamViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final CreateTeamController createTeamController;
    private final JButton createTeam;
    public CreateTeamView(CreateTeamController controller, CreateTeamViewModel createTeamViewModel) {

        this.createTeamController = controller;
        this.createTeamViewModel = createTeamViewModel;
        createTeamViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(CreateTeamViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        createTeam = new JButton(createTeamViewModel.CREATE_TEAM_BUTTON_LABEL);
        buttons.add(createTeam);

        createTeam.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createTeam)) {
                            CreateTeamState currentState = createTeamViewModel.getState();

                            createTeamController.execute(
                                    currentState.getTeamName()
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
                        CreateTeamState currentState = createTeamViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setTeamName(text);
                        createTeamViewModel.setState(currentState);
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
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateTeamState state = (CreateTeamState) evt.getNewValue();
        if (state.getTeamNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getTeamNameError());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
