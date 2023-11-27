package view.startup;

public class StartupInteractor implements StartupInputBoundary {
    final StartupOutputBoundary startupPresenter;

    public StartupInteractor(StartupOutputBoundary startupPresenter) {
        this.startupPresenter = startupPresenter;
    }

    @Override
    public void execute(StartupInputData startupInputData) {
        if (startupInputData.existingUser) {
            startupPresenter.prepareExistingUserView();
        } else {
            startupPresenter.prepareCreateUserView();
        }
    }
}
