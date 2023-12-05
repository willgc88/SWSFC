package draft.finalDraft.interfaceAdapters;

import draft.finalDraft.FinalDraftInputBoundary;
import draft.finalDraft.FinalDraftInputData;

public class FinalDraftController {
    final FinalDraftInputBoundary finaldraftInteractor;
    public FinalDraftController(FinalDraftInputBoundary finaldraftInteractor) {
        this.finaldraftInteractor = finaldraftInteractor;
    }

    public void execute(int position, int selection) {
        FinalDraftInputData finalDraftInputData = new FinalDraftInputData(position, selection);
        finaldraftInteractor.execute(finalDraftInputData);
    }
}
