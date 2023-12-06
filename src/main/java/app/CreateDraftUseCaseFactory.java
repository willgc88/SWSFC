package app;

import api.ApiRequest;
import draft.*;
import view.DraftViewModel;
import view.FinalDraftViewModel;
import view.ViewManagerModel;
import view.draft.DraftView;

import javax.swing.*;
import java.io.IOException;

public class CreateDraftUseCaseFactory {
    private CreateDraftUseCaseFactory() {}
    public static DraftView create(
            ViewManagerModel viewManagerModel, DraftViewModel draftViewModel, FinalDraftViewModel finalDraftViewModel){
        try {
            DraftController draftController = createDraftUseCase(viewManagerModel, draftViewModel, finalDraftViewModel);
            draftViewModel.getState().setRandomPlayers(ApiRequest.apiRequest());
            return new DraftView(draftController, draftViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not access data");
        }

        return null;
    }

    private static DraftController createDraftUseCase(ViewManagerModel viewManagerModel, DraftViewModel draftViewModel, FinalDraftViewModel finalDraftViewModel) throws IOException {
        DraftOutputBoundary draftPresenter = new DraftPresenter(draftViewModel, viewManagerModel, finalDraftViewModel);

        DraftInputBoundary draftInteractor = new DraftInteractor(draftPresenter);

        return new DraftController(draftInteractor);
    }
}
