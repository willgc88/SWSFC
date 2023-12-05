package draft.finalDraft;

import draft.DraftOutputData;

public interface FinalDraftOutputBoundary {
    void prepareSuccessView(FinalDraftOutputData data);

    void prepareFailView(String error);
}