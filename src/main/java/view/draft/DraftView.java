package view.draft;

import draft.DraftController;
import view.DraftViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DraftView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "draft";
    private final DraftViewModel draftViewModel;
    private final DraftController draftController;
    private final JButton p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;

    public DraftView(DraftController draftController, DraftViewModel draftViewModel) {
        this.draftController = draftController;
        this.draftViewModel = draftViewModel;
        draftViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DraftViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        int buttonWidth = 200;
        int buttonHeight = 150;
        JPanel forwards = new JPanel();
        JPanel midfielders = new JPanel();
        JPanel defenders = new JPanel();
        JPanel keeper = new JPanel();
        p1 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p2 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p3 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p4 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p5 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p5.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p6 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p6.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p7 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p7.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p8 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p8.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p9 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p9.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p10 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p10.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p11 = new JButton(DraftViewModel.ADD_PLAYER_LABEL);
        p11.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
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
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
