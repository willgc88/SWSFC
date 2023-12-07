import draft.DraftInputData;
import draft.DraftInteractor;
import draft.DraftOutputBoundary;
import draft.DraftOutputData;
import draft.finalDraft.FinalDraftInputData;
import draft.finalDraft.FinalDraftInteractor;
import draft.finalDraft.FinalDraftOutputBoundary;
import draft.finalDraft.FinalDraftOutputData;
import draft.finalDraft.interfaceAdapters.FinalDraftPresenter;
import org.junit.Before;
import org.junit.Test;
import teams.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static api.ApiRequest.apiRequest;
import static org.junit.Assert.*;

public class DraftInteractorTest {

    private DraftInteractor draftInteractor;
    private FinalDraftInteractor finalDraftInteractor;
    private TestDraftPresenter draftPresenter;
    private TestFinalDraftPresenter finalDraftPresenter;

    @Before
    public void setUp() {
        draftPresenter = new TestDraftPresenter();
        draftInteractor = new DraftInteractor(draftPresenter);

        finalDraftPresenter = new TestFinalDraftPresenter();
        finalDraftInteractor = new FinalDraftInteractor(finalDraftPresenter);
    }

    @Test
    public void testExecute_Success() {
        // Arrange
        Player[] players = {
                new Player("Lionel Messi", "Paris Saint-Germain", "Forward", 1),
                new Player("Cristiano Ronaldo", "Manchester United", "Forward", 2),
                new Player("Robert Lewandowski", "Bayern Munich", "Forward", 3),
                new Player("Kevin De Bruyne", "Manchester City", "Midfielder", 4),
                new Player("N'Golo Kanté", "Chelsea", "Midfielder", 5),
                new Player("Virgil van Dijk", "Liverpool", "Defender", 6),
                new Player("Ruben Dias", "Manchester City", "Defender", 7),
                new Player("Joshua Kimmich", "Bayern Munich", "Midfielder", 8),
                new Player("Erling Haaland", "Borussia Dortmund", "Forward", 9),
                new Player("Kylian Mbappé", "Paris Saint-Germain", "Forward", 10),
                new Player("Harry Kane", "Tottenham Hotspur", "Forward", 11)
        };

        String teamName = "Test Team";
        DraftInputData inputData = new DraftInputData(players, teamName);
        FinalDraftInputData finalInputData = new FinalDraftInputData(5, 5);

        // Act
        draftInteractor.execute(inputData);
        finalDraftInteractor.execute(finalInputData);


        // Assert
        assertNotNull(draftPresenter.lastExecutedInputData);
        assertArrayEquals(players, draftPresenter.lastExecutedInputData.getPlayers());
        assertEquals(teamName, draftPresenter.lastExecutedInputData.getTeamName());

        assertNotNull(finalDraftPresenter.successOutputData);
        assertEquals(5, finalDraftPresenter.successOutputData.getPosition());
        assertEquals(5, finalDraftPresenter.successOutputData.getSelection());
    }

    // Helper classes and methods
    private static class TestDraftPresenter implements DraftOutputBoundary {
        private DraftInputData lastExecutedInputData;

        @Override
        public void prepareSuccessView(DraftOutputData outputData) {
            this.lastExecutedInputData = new DraftInputData(outputData.getPlayers(), outputData.getTeamName());
        }

        @Override
        public void prepareFailView(String error) {
            // No implementation needed for this test
        }
    }
    private static class TestFinalDraftPresenter implements FinalDraftOutputBoundary {
        private FinalDraftOutputData successOutputData;

        @Override
        public void prepareSuccessView(FinalDraftOutputData outputData) {
            this.successOutputData = outputData;
        }

        @Override
        public void prepareFailView(String error) {

        }
    }
}
