package draft;

import teams.entity.Player;

public class DraftController {
    final DraftInputBoundary draftInteractor;
    public DraftController(DraftInputBoundary draftInteractor) {
        this.draftInteractor = draftInteractor;
    }

    public void execute(Player[] players, String teamName) {
        DraftInputData draftInputData = new DraftInputData(players, teamName);
        draftInteractor.execute(draftInputData);
    }
}
