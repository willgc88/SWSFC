package view.draft;

import draft.finalDraft.interfaceAdapters.FinalDraftController;
import draft.finalDraft.interfaceAdapters.FinalDraftState;
import draft.finalDraft.interfaceAdapters.FinalDraftViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FinalDraftView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Final draft";
    private final FinalDraftViewModel finalDraftViewModel;
    private final FinalDraftController finalDraftController;
    private JLabel title;
    private final JComboBox<String> p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private final JButton confirm;

    public FinalDraftView(FinalDraftController finalDraftController, FinalDraftViewModel finalDraftViewModel) {
        this.finalDraftController = finalDraftController;
        this.finalDraftViewModel = finalDraftViewModel;
        finalDraftViewModel.addPropertyChangeListener(this);

        title = new JLabel("Player Draft for " + this.finalDraftViewModel.getState().getTeamName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        int buttonWidth = 200;
        int buttonHeight = 150;
        JPanel forwards = new JPanel();
        JPanel midfielders = new JPanel();
        JPanel defenders = new JPanel();
        JPanel keeper = new JPanel();

        p1 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p1.addActionListener(this);
        p2 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p2.addActionListener(this);
        p3 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p3.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p3.addActionListener(this);
        p4 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p4.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p4.addActionListener(this);
        p5 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p5.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p5.addActionListener(this);
        p6 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p6.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p6.addActionListener(this);
        p7 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p7.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p7.addActionListener(this);
        p8 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p8.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p8.addActionListener(this);
        p9 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p9.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p9.addActionListener(this);
        p10 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
        p10.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        p10.addActionListener(this);
        p11 = new JComboBox<>(new String[]{"messi", "ronaldo", "nursultan", "will", "shayan"});
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
        String p1Selection = (String)p1.getSelectedItem();
        String p2Selection = (String)p2.getSelectedItem();

        if (e.getSource().equals(confirm)) {
             finalDraftController.execute(p1, p1Selection);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FinalDraftState state = (FinalDraftState) evt.getNewValue();
        title.setText("Player Draft for " + state.getTeamName());
    }
}

