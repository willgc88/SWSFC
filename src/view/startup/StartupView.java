package view.startup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StartupView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "startup";

    private final StartupViewModel startupViewModel;
    private final JButton signup;
    private final JButton login;

    public StartupView(StartupViewModel startupViewModel) {
        this.startupViewModel = startupViewModel;
        startupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Startup");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        signup = new JButton(StartupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signup);
        login = new JButton(StartupViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);

        signup.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signup)) {
                            // go to signup view
                            System.out.println("signup");
                        }
                    }
                }
        );

        login.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(login)) {
                            // go to login view
                            System.out.println("login");
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}