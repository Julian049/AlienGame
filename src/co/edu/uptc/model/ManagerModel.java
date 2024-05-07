package co.edu.uptc.model;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.util.concurrent.CopyOnWriteArrayList;


public class ManagerModel implements ContractPlay.Model {
    private ContractPlay.Presenter presenter;
    private ManagerInfoModel managerInfoModel = new ManagerInfoModel();
    private ManagerCannonModel managerCannonModel = new ManagerCannonModel();
    private ManagerAliensModel managerAliensModel = new ManagerAliensModel();

    public ManagerModel() {
        managerCannonModel.setManagerModel(getInstance());
        managerAliensModel.setManagerModel(getInstance());
    }

    private ManagerModel getInstance() {
        return this;
    }

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void countTime() {
        Thread thread = new Thread(() -> {
            while (true) {
                SleepUtil.sleep(ModelPropertiesUtil.SPEED_TIME_THREAD);
                String time = managerInfoModel.countSeconds() + "s " + managerInfoModel.getMinutes() + "m " + managerInfoModel.getHours() + "h";
                presenter.updateTime(time);
            }
        });
        thread.start();
    }

    @Override
    public CannonPojo getCannonPojo() {
        return managerCannonModel.getCannonPojo();
    }

    @Override
    public CopyOnWriteArrayList<BulletPojo> getBullets() {
        return managerCannonModel.getBullets();
    }

    @Override
    public void shoot() {
        managerCannonModel.shoot(managerAliensModel.getAliens());
    }

    @Override
    public void moveCannonRight() {
        managerCannonModel.rightCannon();
    }

    @Override
    public void moveCannonLeft() {
        managerCannonModel.leftCannon();
    }

    @Override
    public CopyOnWriteArrayList<AlienPojo> getAliens() {
        return managerAliensModel.getAliens();
    }

    @Override
    public void updateCountALiens() {
        Thread thread = new Thread(() -> {
            while (true) {
                int aliensAlive = managerAliensModel.getAliensAlive();
                int aliensKilled = managerCannonModel.getAliensKilled();
                presenter.updateAliveALiens(aliensAlive);
                presenter.updateKilledALiens(aliensKilled);
            }
        });
        thread.start();
    }

    @Override
    public void startAliens() {
        managerAliensModel.startAliens();
    }

    @Override
    public void spawnNewAlien() {
        managerAliensModel.spawnNewAlien();
    }

    @Override
    public int getFrameWidth() {
        return presenter.getFrameWidth();
    }

    @Override
    public int getFrameHeight() {
        return presenter.getFrameHeight();
    }

    @Override
    public void initElements() {
        managerCannonModel.initCannon();
    }

    @Override
    public void updateCannonYCoordinate() {
        managerCannonModel.updateYCoordinate();
    }
}
