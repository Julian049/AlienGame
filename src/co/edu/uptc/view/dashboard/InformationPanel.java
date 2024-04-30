package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {

    private JLabel aliensKilledLabel;
    private JLabel aliensAliveLabel;
    private JLabel timeLabel;

    public InformationPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.BLUE);
        Font font = new Font("Arial", Font.BOLD, 20);
        aliensKilledLabel = new JLabel("Aliens killed: 0");
        aliensKilledLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        aliensKilledLabel.setFont(font);
        aliensAliveLabel = new JLabel("Aliens alive: 0");
        aliensAliveLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        aliensAliveLabel.setFont(font);
        timeLabel = new JLabel("Time: 0");
        timeLabel.setFont(font);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        add(aliensKilledLabel);
        add(aliensAliveLabel);
        add(timeLabel);
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
}
