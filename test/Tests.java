import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import users.entity.HumanUser;
import users.entity.User;
import users.entity.UserFactory;
import users.service.createUser.CreateUserDataAccessInterface;
import users.service.createUser.CreateUserInteractor;
import users.service.createUser.CreateUserOutputBoundary;
import users.service.createUser.CreateUserOutputData;
import users.service.createUser.CreateUserInputData;

import static org.junit.Assert.*;
public class Tests {
    private CreateUserInteractor createUserInteractor;
    private TestCreateUserDataAccess createUserDataAccess;
    private TestCreateUserPresenter userPresenter;
    private TestUserFactory userFactory;

    // Set up objects before each test
    @Before
    public void setUp() {
        createUserDataAccess = new TestCreateUserDataAccess();
        userPresenter = new TestCreateUserPresenter();
        userFactory = new TestUserFactory();
        createUserInteractor = new CreateUserInteractor(createUserDataAccess, userPresenter, userFactory);
    }

    // Clean up objects after each test
    @After
    public void tearDown() {
        createUserDataAccess = null;
        userPresenter = null;
        userFactory = null;
        createUserInteractor = null;
    }

    // Test case for successful user creation
    @Test
    public void testExecute_Success() {
        CreateUserInputData inputData = new CreateUserInputData("newUser");
        createUserInteractor.execute(inputData);

        //assertTrue(createUserDataAccess.existsByName("newUser"));
        assertNotNull(userFactory.createdUser);
        assertEquals("newUser", userFactory.createdUser.getName());
        assertEquals("newUser", userPresenter.successOutputData.getUsername());
        //assertEquals(false, userPresenter.successOutputData.isFailed());
    }

    // Test case for existing user
    @Test
    public void testExecute_UserAlreadyExists() {
        // Arrange
        createUserDataAccess.setExistsByNameResult(true);
        CreateUserInputData inputData = new CreateUserInputData("existingUser");

        // Act
        createUserInteractor.execute(inputData);

        // Assert
        assertTrue(createUserDataAccess.existsByName("existingUser"));
        assertNull(userFactory.createdUser);
        assertEquals("User already exists.", userPresenter.failViewMessage);
    }

    // UI-like test for creating a user
    @Test
    public void testCreateUserInteractorUI() {
        // Simulate user input
        CreateUserInputData userInputData = new CreateUserInputData("testUser");

        // Execute the interactor
        createUserInteractor.execute(userInputData);

        // Assert the expected results
        //assertTrue(createUserDataAccess.existsByName("testUser"));
        assertNotNull(userFactory.createdUser);
        assertEquals("testUser", userFactory.createdUser.getName());
        assertEquals("testUser", userPresenter.successOutputData.getUsername());
    }

    // Helper classes and methods remain unchanged from the previous example
    private static class TestCreateUserPresenter implements CreateUserOutputBoundary {
        private CreateUserOutputData successOutputData;
        private String failViewMessage;

        @Override
        public void prepareSuccessView(CreateUserOutputData outputData) {
            this.successOutputData = outputData;
        }

        @Override
        public void prepareFailView(String message) {
            this.failViewMessage = message;
        }
    }
    private static class TestCreateUserDataAccess implements CreateUserDataAccessInterface {
        private boolean existsByNameResult;
        private User savedUser;

        public void setExistsByNameResult(boolean result) {
            this.existsByNameResult = result;
        }

        @Override
        public boolean existsByName(String username) {
            return existsByNameResult;
        }

        @Override
        public void save(User user) {
            this.savedUser = user;
        }

        @Override
        public User get(String username) {
            // Implement get if needed for testing
            return savedUser;
        }
    }

    // Helper class for mocking UserFactory
    private static class TestUserFactory implements UserFactory {
        private User createdUser;

        @Override
        public User create(String username) {
            this.createdUser = new HumanUser(username);
            return createdUser;
        }
    }
}
