package view.startup;

public class StartupController {
    StartupInputBoundary startupInteractor;

    public StartupController(StartupInputBoundary startupInteractor) {
        this.startupInteractor = startupInteractor;
    }
    public void execute(boolean existingUser) {
        StartupInputData startupInputData = new StartupInputData(existingUser);
        startupInteractor.execute(startupInputData);
    }
}
