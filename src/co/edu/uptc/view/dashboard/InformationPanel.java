package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {

    private JLabel aliensKilledLabel;
    private JLabel aliensAliveLabel;
    private JLabel timeLabel;
    private Font font;

    public InformationPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.BLUE);
        font = new Font("Arial", Font.BOLD, 20);
        createLabels();
    }

    private void createLabels(){
            createLabelAliensKilled();
            createLabelAliensAlive();
            createLabelTime();
    }

    private void createLabelAliensKilled(){
        aliensKilledLabel = new JLabel("Aliens killed: 0");
        aliensKilledLabel.setForeground(Color.WHITE);
        aliensKilledLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        aliensKilledLabel.setFont(font);
        add(aliensKilledLabel);
    }

    private void createLabelAliensAlive(){
        aliensAliveLabel = new JLabel("Aliens alive: 0");
        aliensAliveLabel.setForeground(Color.WHITE);
        aliensAliveLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        aliensAliveLabel.setFont(font);
        add(aliensAliveLabel);
    }

    private void createLabelTime(){
        timeLabel = new JLabel("Time: 0");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(font);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(timeLabel);
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

}
