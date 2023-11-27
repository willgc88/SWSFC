package view.startup;

public class StartupInputData {
    boolean existingUser;

    StartupInputData(boolean existingUser) {
        this.existingUser = existingUser;
    }

    boolean isExistingUser() {
        return existingUser;
    }
}
