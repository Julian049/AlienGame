package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.view.ManagerView;

public class ManagerPresenter implements ContractPlay.Presenter {
    private ContractPlay.View view;
    private ContractPlay.Model model;

    @Override
    public void setView(ContractPlay.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractPlay.Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        makeMVP();
        view.run();
        model.countTime();
    }

    public void makeMVP() {
        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        ManagerView managerView = new ManagerView();
        managerView.setPresenter(this);

        setModel(managerModel);
        setView(managerView);
    }

    @Override
    public void updateTime(String time) {
        view.updateTime(time);
    }
}
