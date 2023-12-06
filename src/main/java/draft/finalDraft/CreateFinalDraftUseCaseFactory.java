package draft.finalDraft;

import draft.finalDraft.interfaceAdapters.FinalDraftController;
import draft.finalDraft.interfaceAdapters.FinalDraftPresenter;
import view.FinalDraftViewModel;
import view.ViewManagerModel;
import view.draft.FinalDraftView;

import javax.swing.*;
import java.io.IOException;

public class CreateFinalDraftUseCaseFactory {
    private CreateFinalDraftUseCaseFactory() {}
    public static FinalDraftView create(
            ViewManagerModel viewManagerModel, FinalDraftViewModel finalDraftViewModel){
        try {
            FinalDraftController finalDraftController = createFinalDraftUseCase(viewManagerModel, finalDraftViewModel);

            return new FinalDraftView(finalDraftController, finalDraftViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not access data");
        }

        return null;
    }

    private static FinalDraftController createFinalDraftUseCase(ViewManagerModel viewManagerModel, FinalDraftViewModel finalDraftViewModel) throws IOException {
        FinalDraftOutputBoundary finalDraftPresenter = new FinalDraftPresenter(finalDraftViewModel, viewManagerModel);

        FinalDraftInputBoundary finalDraftInteractor = new FinalDraftInteractor(finalDraftPresenter);

        return new FinalDraftController(finalDraftInteractor);
    }
}


