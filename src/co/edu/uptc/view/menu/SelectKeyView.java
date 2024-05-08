package co.edu.uptc.view.menu;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectKeyView extends JFrame {

    private JLabel titleGameLabel;
    private JButton selectKeyButton;
    private JTextArea selectKeyTextArea;
    private JLabel noteLabel;
    private char keyToShoot;
    private ManagerView managerView;

    public SelectKeyView() {
        initComponents();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }
    private void initComponents() {
        this.setSize(ViewPropertiesUtil.MENU_WIDTH, ViewPropertiesUtil.MENU_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        createComponents(backgroundPanel, gbc);

        this.setContentPane(backgroundPanel);
    }

    private void createComponents(JPanel panel,GridBagConstraints gbc) {
        createTitleGameLabel(panel,gbc);
        createSelectKeyTextField(panel,gbc);
        createSelectKeyButton(panel,gbc);
        createNoteLabel(panel,gbc);
    }

    private void createSelectKeyTextField(JPanel panel,GridBagConstraints gbc) {
        selectKeyTextArea = new JTextArea(ViewPropertiesUtil.MENU_KEY_LABEL);
        selectKeyTextArea.setForeground(Color.WHITE);
        selectKeyTextArea.setBackground(new Color(0,0,0,0));
        selectKeyTextArea.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectKeyTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectKeyTextArea.setText(ViewPropertiesUtil.BEFORE_SELECT_KEY_LABEL);
                selectKeyTextArea.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        keyToShoot = e.getKeyChar();
                        selectKeyTextArea.setText(ViewPropertiesUtil.KEY_SELECTED + keyToShoot);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
            }
        });
        selectKeyTextArea.setEditable(false);
        selectKeyTextArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.REMAINDER;
        panel.add(selectKeyTextArea, gbc);
    }

    private void createSelectKeyButton(JPanel panel,GridBagConstraints gbc) {
        selectKeyButton = new JButton(ViewPropertiesUtil.START_BUTTON_TEXT);
        selectKeyButton.setBackground(new Color(45,227,51));
        selectKeyButton.setBorderPainted(false);
        selectKeyButton.setFocusPainted(false);
        selectKeyButton.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 10));
        selectKeyButton.addActionListener(e -> {
            if ((int)keyToShoot == 0) {
                JOptionPane.showMessageDialog(null, ViewPropertiesUtil.ERROR_TEXT,"ERROR", JOptionPane.ERROR_MESSAGE);
            }else {
                close();
                managerView.startGame();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(selectKeyButton, gbc);
    }

    private void createTitleGameLabel(JPanel panel,GridBagConstraints gbc) {
        titleGameLabel = new JLabel(ViewPropertiesUtil.TITLE_GAME_LABEL);
        titleGameLabel.setForeground(new Color(45,227,51));
        titleGameLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 30));
        titleGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleGameLabel, gbc);
    }

    private void createNoteLabel(JPanel panel,GridBagConstraints gbc) {
        noteLabel = new JLabel(ViewPropertiesUtil.NOTE_LABEL);
        noteLabel.setForeground(Color.WHITE);
        noteLabel.setFont(ViewPropertiesUtil.getMyFont().deriveFont(Font.PLAIN, 7));
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(noteLabel, gbc);
    }

    public void run() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }

    public char getKeyToShoot() {
        return keyToShoot;
    }
}
