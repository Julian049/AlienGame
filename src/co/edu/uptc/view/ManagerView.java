package co.edu.uptc.view;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.dashboard.DashboardView;
import co.edu.uptc.view.dashboard.InformationPanelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        setLayout(new FlowLayout());
        setResizable(false);

        informationPanelView = new InformationPanelView();
        informationPanelView.setPreferredSize(new Dimension(ViewPropertiesUtil.INFORMATION_PANEL_WIDTH, ViewPropertiesUtil.INFORMATION_PANEL_HEIGHT));
        add(informationPanelView);

        dashboardView = new DashboardView();
        dashboardView.setManagerView(getInstance());
        dashboardView.setPreferredSize(new Dimension(ViewPropertiesUtil.DASHBOARD_PANEL_WIDTH, ViewPropertiesUtil.DASHBOARD_PANEL_HEIGHT));
        add(dashboardView);
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
}
