package app;

import teams.entity.TeamFactory;
import teams.service.createTeam.CreateTeamDataAccessInterface;
import teams.service.createTeam.CreateTeamInputBoundary;
import teams.service.createTeam.CreateTeamInteractor;
import teams.service.createTeam.CreateTeamOutputBoundary;
import teams.service.createTeam.interface_adapter.CreateTeamController;
import teams.service.createTeam.interface_adapter.CreateTeamPresenter;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.service.createUser.CreateUserDataAccessInterface;
import view.DraftViewModel;
import view.ViewManagerModel;
import view.teams.CreateTeamView;

import javax.swing.*;
import java.io.IOException;

public class CreateTeamUseCaseFactory {
    private CreateTeamUseCaseFactory() {
    }

    public static CreateTeamView create(
            ViewManagerModel viewManagerModel, DraftViewModel draftViewModel, CreateTeamViewModel createTeamViewModel, CreateTeamDataAccessInterface createTeamDataAccessObject) {

        try {
            CreateTeamController createTeamController = createTeamUseCase(viewManagerModel, createTeamViewModel, draftViewModel, createTeamDataAccessObject);
            return new CreateTeamView(createTeamController, createTeamViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open the data file.");
        }

        return null;
    }

    private static CreateTeamController createTeamUseCase(ViewManagerModel viewManagerModel, CreateTeamViewModel createTeamViewModel, DraftViewModel draftViewModel, CreateTeamDataAccessInterface createTeamDataAccessObject) throws IOException {
        // Notice how we pass this method's parameters to the Presenter.
        CreateTeamOutputBoundary createTeamOutputBoundary = new CreateTeamPresenter(createTeamViewModel, draftViewModel, viewManagerModel);
        TeamFactory teamFactory = new TeamFactory();

        CreateTeamInputBoundary createTeamInteractor = new CreateTeamInteractor(
                createTeamDataAccessObject, createTeamOutputBoundary, teamFactory);

        return new CreateTeamController(createTeamInteractor);
    }
}
