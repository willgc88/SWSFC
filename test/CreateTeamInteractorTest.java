import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import teams.entity.Player;
import teams.entity.Team;
import teams.entity.TeamFactory;
import teams.service.createTeam.*;

import java.util.List;

import static org.junit.Assert.*;
public class CreateTeamInteractorTest {

    private CreateTeamInteractor createTeamInteractor;
    private TestCreateTeamDataAccess createTeamDataAccess;
    private TestCreateTeamPresenter teamPresenter;
    private TestTeamFactory teamFactory;

    // Set up objects before each test
    @Before
    public void setUp() {
        createTeamDataAccess = new TestCreateTeamDataAccess();
        teamPresenter = new TestCreateTeamPresenter();
        TestTeamFactory testTeamFactory = new TestTeamFactory();  // Use a different variable name
        createTeamInteractor = new CreateTeamInteractor(createTeamDataAccess, teamPresenter, testTeamFactory);
    }

    // Clean up objects after each test
    @After
    public void tearDown() {
        createTeamDataAccess = null;
        teamPresenter = null;
        teamFactory = null;
        createTeamInteractor = null;
    }

    // Test case for successful team creation
    @Test
    public void testExecute_Success() {
        // Arrange
        CreateTeamInputData inputData = new CreateTeamInputData("newTeam");

        // Act
        createTeamInteractor.execute(inputData);

        // Assert
        assertTrue(createTeamDataAccess.existsByName("newTeam"));
        assertNotNull(teamFactory.createdTeam);
        assertEquals("newTeam", teamFactory.createdTeam.getTeamName());
        assertEquals("newTeam", teamPresenter.successOutputData.getTeamName());
    }

    // Test case for existing team
    @Test
    public void testExecute_TeamAlreadyExists() {
        // Arrange
        createTeamDataAccess.setExistsByNameResult(true);
        CreateTeamInputData inputData = new CreateTeamInputData("existingTeam");

        // Act
        createTeamInteractor.execute(inputData);

        // Assert
        assertTrue(createTeamDataAccess.existsByName("existingTeam"));
        //assertNull(teamFactory.createdTeam);
        assertEquals("Team with this name already exists", teamPresenter.failViewMessage);
    }

    // UI-like test for creating a team
    @Test
    public void testCreateTeamInteractor() {
        // Simulate user input
        CreateTeamInputData userInputData = new CreateTeamInputData("testTeam");

        // Execute the interactor
        createTeamInteractor.execute(userInputData);

        // Assert the expected results
        assertTrue(createTeamDataAccess.existsByName("testTeam"));
        assertNotNull(teamFactory.createdTeam);
        assertEquals("testTeam", teamFactory.createdTeam.getTeamName());
        assertEquals("testTeam", teamPresenter.successOutputData.getTeamName());
    }

    // Helper classes and methods
    private static class TestCreateTeamDataAccess implements CreateTeamDataAccessInterface {
        private boolean existsByNameResult;
        private Team savedTeam;

        public void setExistsByNameResult(boolean result) {
            this.existsByNameResult = result;
        }

        @Override
        public boolean existsByName(String teamName) {
            return existsByNameResult;
        }

        @Override
        public void save(Team team) {
            this.savedTeam = team;
        }
    }

    private static class TestCreateTeamPresenter implements CreateTeamOutputBoundary {
        private CreateTeamOutputData successOutputData;
        private String failViewMessage;

        @Override
        public void prepareSuccessView(CreateTeamOutputData outputData) {
            this.successOutputData = outputData;
        }

        @Override
        public void prepareFailView(String message) {
            this.failViewMessage = message;
        }
    }

    private static class TestTeamFactory implements TeamFactory {
        private Team createdTeam;
        @Override
        public Team create(String teamName, List<Player> roster, int rating, int chemistry) {
            this.createdTeam = new Team(teamName, null, 0, 0);
            return createdTeam;
        }
    }
}