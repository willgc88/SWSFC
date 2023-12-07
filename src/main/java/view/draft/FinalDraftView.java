package view.draft;

import app.RatingCalculator;
import draft.finalDraft.interfaceAdapters.FinalDraftController;
import draft.finalDraft.interfaceAdapters.FinalDraftState;
import teams.entity.Player;
import view.FinalDraftViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FinalDraftView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "final draft";
    private final FinalDraftViewModel finalDraftViewModel;
    private final FinalDraftController finalDraftController;
    private JLabel title;
    public final JLabel p1;
    public final JLabel p2;
    private final JLabel p3;
    private final JLabel p4;
    private final JLabel p5;
    private final JLabel p6;
    private final JLabel p7;
    private final JLabel p8;
    private final JLabel p9;
    private final JLabel p10;
    private final JLabel p11;
    private final JLabel stats;

    public FinalDraftView(FinalDraftController finalDraftController, FinalDraftViewModel finalDraftViewModel) {
        this.finalDraftController = finalDraftController;
        this.finalDraftViewModel = finalDraftViewModel;
        finalDraftViewModel.addPropertyChangeListener(this);

        title = new JLabel("Final Draft");

        int buttonWidth = 200;
        int buttonHeight = 150;
        Dimension dim = new Dimension(buttonWidth, buttonHeight);
        JPanel forwards = new JPanel();
        JPanel midfielders = new JPanel();
        JPanel defenders = new JPanel();
        JPanel keeper = new JPanel();
        stats = new JLabel("", SwingConstants.CENTER);

        stats.setBackground(Color.DARK_GRAY);
        stats.setPreferredSize(new Dimension(4*buttonWidth,buttonHeight));
        stats.setAlignmentX(Component.CENTER_ALIGNMENT);

        p1 = new JLabel("", SwingConstants.CENTER);
        p1.setPreferredSize(dim);
        p2 = new JLabel("", SwingConstants.CENTER);
        p2.setPreferredSize(dim);
        p3 = new JLabel("", SwingConstants.CENTER);
        p3.setPreferredSize(dim);
        p4 = new JLabel("", SwingConstants.CENTER);
        p4.setPreferredSize(dim);
        p5 = new JLabel("", SwingConstants.CENTER);
        p5.setPreferredSize(dim);
        p6 = new JLabel("", SwingConstants.CENTER);
        p6.setPreferredSize(dim);
        p7 = new JLabel("", SwingConstants.CENTER);
        p7.setPreferredSize(dim);
        p8 = new JLabel("", SwingConstants.CENTER);
        p8.setPreferredSize(dim);
        p9 = new JLabel("", SwingConstants.CENTER);
        p9.setPreferredSize(dim);
        p10 = new JLabel("", SwingConstants.CENTER);
        p10.setPreferredSize(dim);
        p11 = new JLabel("", SwingConstants.CENTER);
        p11.setPreferredSize(dim);

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(forwards);
        this.add(midfielders);
        this.add(defenders);
        this.add(keeper);
        this.add(stats);
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FinalDraftState state = (FinalDraftState) evt.getNewValue();
        title.setText("Final Draft for " + state.getTeamName());
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Player player1 = state.getPlayers()[0];
        Player player2 = state.getPlayers()[1];
        Player player3 = state.getPlayers()[2];
        Player player4 = state.getPlayers()[3];
        Player player5 = state.getPlayers()[4];
        Player player6 = state.getPlayers()[5];
        Player player7 = state.getPlayers()[6];
        Player player8 = state.getPlayers()[7];
        Player player9 = state.getPlayers()[8];
        Player player10 = state.getPlayers()[9];
        Player player11 = state.getPlayers()[10];
        p1.setText("<html><div style='text-align: center;'>" + player1.getName() + "<br> Position: " + player1.getPosition() + "<br> Club: "+ player1.getClub() + "</html>");
        p2.setText("<html><div style='text-align: center;'>" + player2.getName() + "<br> Position: " + player2.getPosition() + "<br> Club: "+ player2.getClub() + "</html>");
        p3.setText("<html><div style='text-align: center;'>" + player3.getName() + "<br> Position: " + player3.getPosition() + "<br> Club: "+ player3.getClub() + "</html>");
        p4.setText("<html><div style='text-align: center;'>" + player4.getName() + "<br> Position: " + player4.getPosition() + "<br> Club: "+ player4.getClub() + "</html>");
        p5.setText("<html><div style='text-align: center;'>" + player5.getName() + "<br> Position: " + player5.getPosition() + "<br> Club: "+ player5.getClub() + "</html>");
        p6.setText("<html><div style='text-align: center;'>" + player6.getName() + "<br> Position: " + player6.getPosition() + "<br> Club: "+ player6.getClub() + "</html>");
        p7.setText("<html><div style='text-align: center;'>" + player7.getName() + "<br> Position: " + player7.getPosition() + "<br> Club: "+ player7.getClub() + "</html>");
        p8.setText("<html><div style='text-align: center;'>" + player8.getName() + "<br> Position: " + player8.getPosition() + "<br> Club: "+ player8.getClub() + "</html>");
        p9.setText("<html><div style='text-align: center;'>" + player9.getName() + "<br> Position: " + player9.getPosition() + "<br> Club: "+ player9.getClub() + "</html>");
        p10.setText("<html><div style='text-align: center;'>" + player10.getName() + "<br> Position: " + player10.getPosition() + "<br> Club: "+ player10.getClub() + "</html>");
        p11.setText("<html><div style='text-align: center;'>" + player11.getName() + "<br> Position: " + player11.getPosition() + "<br> Club: "+ player11.getClub() + "</html>");
        RatingCalculator rating = new RatingCalculator();
        String finalRating = rating.RatingCalculator(state);
        stats.setText(String.valueOf(finalRating));
        stats.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        stats.setFont(new Font("Serif", Font.BOLD, 22));
    }
}

