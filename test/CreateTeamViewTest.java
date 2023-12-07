import org.junit.Before;
import org.junit.Test;
import teams.service.createTeam.interface_adapter.CreateTeamController;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import view.teams.CreateTeamView;

import javax.swing.*;

import static org.mockito.Mockito.*;

public class CreateTeamViewTest {
    private CreateTeamController createTeamController;
    private CreateTeamViewModel createTeamViewModel;
    private CreateTeamView createTeamView;

    @Before
    public void setUp() {
        createTeamController = mock(CreateTeamController.class);
        createTeamViewModel = new CreateTeamViewModel();
        createTeamView = new CreateTeamView(createTeamController, createTeamViewModel);
    }

    @Test
    public void testActionPerformed() {

        JFrame jFrame = new JFrame();
        jFrame.setContentPane(createTeamView);
        jFrame.pack();
        jFrame.setVisible(true);


        createTeamView.actionPerformed(null);


        verify(createTeamController, never()).execute(anyString());

    }
}