package app;

import draft.*;
import teams.entity.TeamFactory;
import teams.service.createTeam.CreateTeamDataAccessInterface;
import teams.service.createTeam.CreateTeamInputBoundary;
import teams.service.createTeam.CreateTeamInteractor;
import teams.service.createTeam.CreateTeamOutputBoundary;
import teams.service.createTeam.interface_adapter.CreateTeamController;
import teams.service.createTeam.interface_adapter.CreateTeamPresenter;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import view.DraftViewModel;
import view.ViewManagerModel;
import view.draft.DraftView;
import view.teams.CreateTeamView;

import javax.swing.*;
import java.io.IOException;

public class CreateDraftUseCaseFactory {
    private CreateDraftUseCaseFactory() {}
    public static DraftView create(
            ViewManagerModel viewManagerModel, DraftViewModel draftViewModel){
        try {
            DraftController draftController = createDraftUseCase(viewManagerModel, draftViewModel);

            return new DraftView(draftController, draftViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not access data");
        }

        return null;
    }

    private static DraftController createDraftUseCase(ViewManagerModel viewManagerModel, DraftViewModel draftViewModel) throws IOException {
        DraftOutputBoundary draftPresenter = new DraftPresenter(draftViewModel, viewManagerModel);

        DraftInputBoundary draftInteractor = new DraftInteractor(draftPresenter);

        return new DraftController(draftInteractor);
    }
}
