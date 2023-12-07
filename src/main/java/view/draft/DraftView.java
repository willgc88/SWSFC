package view.draft;

import draft.DraftController;
import draft.DraftState;
import teams.entity.Player;
import view.DraftViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DraftView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "draft";
    private final DraftViewModel draftViewModel;
    private final DraftController draftController;
    private JLabel title;
    private final JComboBox<String> p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private final JButton confirm;
    Map<String, List<Player>> randomPlayers;
    List<Player> attackersList;
    List<Player> midfieldersList;
    List<Player> defendersList;
    List<Player> goalkeepersList;
    String[] attackerNames = new String[20];
    String[] midfielderNames = new String[20];
    String[] defenderNames = new String[20];
    String[] goalkeeperNames = new String[10];
    String teamName;
    public DraftView(DraftController draftController, DraftViewModel draftViewModel) {
        this.draftController = draftController;
        this.draftViewModel = draftViewModel;
        draftViewModel.addPropertyChangeListener(this);

        randomPlayers = draftViewModel.getState().getRandomPlayers();
        attackersList = randomPlayers.get("Attacker");
        midfieldersList = randomPlayers.get("Midfielder");
        defendersList = randomPlayers.get("Defender");
        goalkeepersList = randomPlayers.get("Goalkeeper");

        for (int i=0;i<20;i++) {
            attackerNames[i] = attackersList.get(i).getName();
            midfielderNames[i] = midfieldersList.get(i).getName();
            defenderNames[i] = defendersList.get(i).getName();
            if (i<10) {
                goalkeeperNames[i] = goalkeepersList.get(i).getName();
            }
        }

        title = new JLabel("Player Draft");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        int buttonWidth = 200;
        int buttonHeight = 150;
        JPanel forwards = new JPanel();
        JPanel midfielders = new JPanel();
        JPanel defenders = new JPanel();
        JPanel keeper = new JPanel();

        p1 = new JComboBox<>(Arrays.copyOfRange(attackerNames, 0, 5));
        p1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p1.addActionListener(this);
        p2 = new JComboBox<>(Arrays.copyOfRange(attackerNames, 5, 10));
        p2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p2.addActionListener(this);
        p3 = new JComboBox<>(Arrays.copyOfRange(midfielderNames, 0, 5));
        p3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p3.addActionListener(this);
        p4 = new JComboBox<>(Arrays.copyOfRange(midfielderNames, 5, 10));
        p4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p4.addActionListener(this);
        p5 = new JComboBox<>(Arrays.copyOfRange(midfielderNames, 10, 15));
        p5.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p5.addActionListener(this);
        p6 = new JComboBox<>(Arrays.copyOfRange(midfielderNames, 15, 20));
        p6.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p6.addActionListener(this);
        p7 = new JComboBox<>(Arrays.copyOfRange(defenderNames, 0, 5));
        p7.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p7.addActionListener(this);
        p8 = new JComboBox<>(Arrays.copyOfRange(defenderNames, 5, 10));
        p8.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p8.addActionListener(this);
        p9 = new JComboBox<>(Arrays.copyOfRange(defenderNames, 10, 15));
        p9.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p9.addActionListener(this);
        p10 = new JComboBox<>(Arrays.copyOfRange(defenderNames, 15, 20));
        p10.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p10.addActionListener(this);
        p11 = new JComboBox<>(Arrays.copyOfRange(goalkeeperNames, 0, 5));
        p11.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p11.addActionListener(this);

        forwards.add(p1);
        forwards.add(p2);
        midfielders.add(p3);
        midfielders.add(p4);
        midfielders.add(p5);
        midfielders.add(p6);
        defenders.add(p7);
        defenders.add(p8);
        defenders.add(p9);
        defenders.add(p10);
        keeper.add(p11);
        JPanel confirmPanel = new JPanel();
        confirm = new JButton("Confirm Selection");
        confirm.addActionListener(this);
        confirmPanel.add(confirm);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(forwards);
        this.add(midfielders);
        this.add(defenders);
        this.add(keeper);
        this.add(confirmPanel);
    }

    public void actionPerformed(ActionEvent e) {
        Player[] playerList = new Player[11];
        String p1Selection = (String)p1.getSelectedItem();
        playerList[0] = attackersList.get(List.of(attackerNames).indexOf(p1Selection));
        String p2Selection = (String)p2.getSelectedItem();
        playerList[1] = attackersList.get(List.of(attackerNames).indexOf(p2Selection));
        String p3Selection = (String)p3.getSelectedItem();
        playerList[2] = midfieldersList.get(List.of(midfielderNames).indexOf(p3Selection));
        String p4Selection = (String)p4.getSelectedItem();
        playerList[3] = midfieldersList.get(List.of(midfielderNames).indexOf(p4Selection));
        String p5Selection = (String)p5.getSelectedItem();
        playerList[4] = midfieldersList.get(List.of(midfielderNames).indexOf(p5Selection));
        String p6Selection = (String)p6.getSelectedItem();
        playerList[5] = midfieldersList.get(List.of(midfielderNames).indexOf(p6Selection));
        String p7Selection = (String)p7.getSelectedItem();
        playerList[6] = defendersList.get(List.of(defenderNames).indexOf(p7Selection));
        String p8Selection = (String)p8.getSelectedItem();
        playerList[7] = defendersList.get(List.of(defenderNames).indexOf(p8Selection));
        String p9Selection = (String)p9.getSelectedItem();
        playerList[8] = defendersList.get(List.of(defenderNames).indexOf(p9Selection));
        String p10Selection = (String)p10.getSelectedItem();
        playerList[9] = defendersList.get(List.of(defenderNames).indexOf(p10Selection));
        String p11Selection = (String)p11.getSelectedItem();
        playerList[10] = goalkeepersList.get(List.of(goalkeeperNames).indexOf(p11Selection));

        if (e.getSource().equals(confirm)) {
           draftController.execute(playerList, teamName);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DraftState state = (DraftState) evt.getNewValue();
        teamName = state.getTeamName();
        title.setText("Player Draft for " + teamName);
    }

    public JComboBox<String> getP1ComboBox() {
        return p1;
    }
}
