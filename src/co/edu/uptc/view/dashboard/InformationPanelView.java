package co.edu.uptc.view.dashboard;

import co.edu.uptc.util.ViewPropertiesUtil;

import javax.swing.*;
import java.awt.*;

public class InformationPanelView extends JPanel {

    private JLabel aliensKilledLabel;
    private JLabel aliensAliveLabel;
    private JLabel timeLabel;

    public InformationPanelView() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.black);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        createLabels(gbc);
    }

    private void createLabels(GridBagConstraints gbc) {
        createLabelAliensKilled(gbc);
        createLabelAliensAlive(gbc);
        createLabelTime(gbc);
    }

    private void createLabelAliensKilled(GridBagConstraints gbc) {
        aliensKilledLabel = new JLabel(ViewPropertiesUtil.ALIENS_KILLED_TITLE);
        aliensKilledLabel.setForeground(Color.WHITE);
        aliensKilledLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(aliensKilledLabel, gbc);
    }

    private void createLabelAliensAlive(GridBagConstraints gbc) {
        aliensAliveLabel = new JLabel(ViewPropertiesUtil.ALIENS_ALIVE_TITLE);
        aliensAliveLabel.setForeground(Color.WHITE);
        aliensAliveLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 25, 0, 0);
        add(aliensAliveLabel, gbc);
    }

    private void createLabelTime(GridBagConstraints gbc) {
        timeLabel = new JLabel(ViewPropertiesUtil.TIME_TITLE);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(timeLabel, gbc);
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JLabel getAliensKilledLabel() {
        return aliensKilledLabel;
    }

    public JLabel getAliensAliveLabel() {
        return aliensAliveLabel;
    }

}
