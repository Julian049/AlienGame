package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.dashboard.DashboardView;
import co.edu.uptc.view.dashboard.InformationPanelView;

import javax.swing.*;
import java.awt.*;
 

public class ManagerView extends JFrame implements ContractPlay.View {
    public ContractPlay.Presenter presenter;
    private InformationPanelView informationPanelView;
    private DashboardView dashboardView;

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
        setSize(ViewPropertiesUtil.FRAME_WIDTH, ViewPropertiesUtil.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        informationPanelView = new InformationPanelView();
        constraints.weighty = 0.1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(informationPanelView, constraints);

        dashboardView = new DashboardView();
        dashboardView.setManagerView(getInstance());
        constraints.weighty = 0.9;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(dashboardView, constraints);
    }

    @Override
    public void run() {
        dashboardView.threadPaint();
        setVisible(true);
    }

    @Override
    public void updateTime(String time) {
        informationPanelView.getTimeLabel().setText("Time: " + time);
    }

    @Override
    public void updateAliveALiens(int aliensAlive) {
        informationPanelView.getAliensAliveLabel().setText("Aliens alive: " + aliensAlive);
    }

    @Override
    public void updateKilledALiens(int aliensKilled) {
        informationPanelView.getAliensKilledLabel().setText("Aliens killed: " + aliensKilled);
    }

    @Override
    public int getFrameWidth() {
        return this.getWidth();
    }

    @Override
    public int getFrameHeight() {
        return dashboardView.getHeight();
    }
}
