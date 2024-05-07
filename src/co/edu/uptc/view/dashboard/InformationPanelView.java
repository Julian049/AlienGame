package co.edu.uptc.view.dashboard;

import co.edu.uptc.util.ViewPropertiesUtil;

import javax.swing.*;
import java.awt.*;

public class InformationPanelView extends JPanel {

    private JLabel aliensKilledLabel;
    private JLabel aliensAliveLabel;
    private JLabel timeLabel;
    private Font font;

    public InformationPanelView() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.black);
        font = new Font(ViewPropertiesUtil.FONT_NAME, ViewPropertiesUtil.FONT_STYLE, ViewPropertiesUtil.FONT_SIZE);
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
        aliensKilledLabel = new JLabel("Aliens killed: ");
        aliensKilledLabel.setForeground(Color.WHITE);
        aliensKilledLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(aliensKilledLabel, gbc);
    }

    private void createLabelAliensAlive(GridBagConstraints gbc) {
        aliensAliveLabel = new JLabel("Aliens alive: ");
        aliensAliveLabel.setForeground(Color.WHITE);
        aliensAliveLabel.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 25, 0, 0);
        add(aliensAliveLabel, gbc);
    }

    private void createLabelTime(GridBagConstraints gbc) {
        timeLabel = new JLabel("Time: 0");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(font);
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
