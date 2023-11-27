package app;

import data_access.FileUserDataAccessObject;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.entity.HumanUserFactory;
import users.service.createUser.CreateUserUseCaseFactory;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.startup.*;
import users.service.createUser.interface_adapter.CreateUserViewModel;
import view.ViewManager;
import view.ViewManagerModel;
import view.teams.CreateTeamView;
import view.users.CreateUserView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("SWSFC Draft Simulator");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        StartupViewModel startupViewModel = new StartupViewModel();
        CreateTeamViewModel createTeamViewModel = new CreateTeamViewModel();
        CreateUserViewModel createUserViewModel = new CreateUserViewModel();
        ExistingUserViewModel existingUserViewModel = new ExistingUserViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new HumanUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StartupView startupView = StartupUseCaseFactory.create(viewManagerModel, startupViewModel, createUserViewModel, existingUserViewModel);
        views.add(startupView, startupView.viewName);

        // ExistingUserView existingUserView = ExistingUserUseCaseFactory.create();
        // views.add(existingUserView, existingUserView.viewName);

        CreateUserView createUserView = CreateUserUseCaseFactory.create(viewManagerModel, createTeamViewModel, createUserViewModel, userDataAccessObject);
        views.add(createUserView, createUserView.viewName);

        CreateTeamView createTeamView = new CreateTeamView(createTeamViewModel);
        // views.add(createTeamView, createTeamView.viewName);

        viewManagerModel.setActiveView(startupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}