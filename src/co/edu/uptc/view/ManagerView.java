package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.view.dashboard.Dashboard;
import co.edu.uptc.view.dashboard.InformationPanel;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JFrame implements ContractPlay.View {
    public ContractPlay.Presenter presenter;
    private InformationPanel informationPanel;
    private Dashboard dashboard;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    public ManagerView() {
        initComponents();
    }

    private ManagerView getInstance() {
        return this;
    }

    private void initComponents() {
        setSize(1280, 650);
        this.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        informationPanel = new InformationPanel();
        informationPanel.setPreferredSize(new Dimension(1280, 100));
        add(informationPanel);

        dashboard = new Dashboard();
        dashboard.setPreferredSize(new Dimension(1280, 550));
        dashboard.setManagerView(getInstance());
        add(dashboard);

        pack();
    }

    @Override
    public void run() {
        dashboard.threadPaint();
        setVisible(true);
    }

    @Override
    public void updateTime(String time) {
        informationPanel.getTimeLabel().setText("Time: " + time);
    }
}
