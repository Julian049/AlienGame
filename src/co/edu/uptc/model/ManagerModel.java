package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractPlay;

public class ManagerModel implements ContractPlay.Model {
    private ContractPlay.Presenter presenter;
    private ManageInfo manageInfo = new ManageInfo();
    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void countTime() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        String time = manageInfo.countSeconds() + "s " + manageInfo.getMinutes() + "m " + manageInfo.getHours() + "h";
                        presenter.updateTime(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}