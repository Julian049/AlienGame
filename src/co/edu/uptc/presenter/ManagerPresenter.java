package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.view.ManagerView;

import java.util.ArrayList;

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

    @Override
    public void moveCannonLeft() {
        model.moveCannonLeft();
    }

    @Override
    public void moveCannonRight() {
        model.moveCannonRight();
    }

    @Override
    public CannonPojo getCannonPojo() {
        return model.getCannonPojo();
    }

    @Override
    public void shoot() {
        model.shoot();
    }

    @Override
    public BulletPojo getBulletPojo() {
        return model.getBulletPojo();
    }
}
