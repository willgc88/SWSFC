package draft;

public interface DraftOutputBoundary {
    void prepareSuccessView(DraftOutputData data);
    void prepareFailView(String error);
}
