package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.view.ManagerView;

import java.util.concurrent.CopyOnWriteArrayList;


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
        model.initElements();
        model.countTime();
        model.updateCountALiens();
        model.startAliens();
        model.spawnNewAlien();
    }

    public void makeMVP() {
        ManagerView managerView = new ManagerView();
        managerView.setPresenter(this);

        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        setView(managerView);
        setModel(managerModel);
    }

    @Override
    public void updateTime(String time) {
        view.updateTime(time);
    }

    @Override
    public void updateAliveALiens(int aliensAlive) {
        view.updateAliveALiens(aliensAlive);
    }

    @Override
    public void updateKilledALiens(int aliensKilled) {
        view.updateKilledALiens(aliensKilled);
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
    public CopyOnWriteArrayList<BulletPojo> getBullets() {
        return model.getBullets();
    }

    @Override
    public CopyOnWriteArrayList<AlienPojo> getAliens() {
        return model.getAliens();
    }

    @Override
    public int getFrameWidth() {
        return view.getFrameWidth();
    }

    @Override
    public int getFrameHeight() {
        return view.getFrameHeight();
    }

    @Override
    public void updateCannonYCoordinate() {
        model.updateCannonYCoordinate();
    }
}
