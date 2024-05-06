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
                    SleepUtil.sleep(ModelPropertiesUtil.SPEED_TIME_THREAD);
                    String time = managerInfoModel.countSeconds() + "s " + managerInfoModel.getMinutes() + "m " + managerInfoModel.getHours() + "h";
                    presenter.updateTime(time);
                }
            }
        };
        thread.start();
    }

    @Override
    public void checkBulletColision() {

    }

    @Override
    public CannonPojo getCannonPojo() {
        CannonPojo cannonPojo = managerCannonModel.getCannonPojo();
        return cannonPojo;
    }

    @Override
    public BulletPojo getBulletPojo() {
        BulletPojo bulletPojo = managerCannonModel.getBulletPojo();
        return bulletPojo;
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
    public void loadAliens() {
        managerAliensModel.createAliens();
    }

    @Override
    public CopyOnWriteArrayList<AlienPojo> getAliens() {
        return managerAliensModel.getAliens();
    }

    @Override
    public void updateCountALiens() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int aliensAlive = managerAliensModel.getAliensAlive();
                    int aliensKilled = managerCannonModel.getAliensKilled();
                    presenter.updateAliveALiens(aliensAlive);
                    presenter.updateKilledALiens(aliensKilled);
                }
            }
        };
        thread.start();
    }

    @Override
    public void spawnNwAlien(){
        managerAliensModel.spawnNewAlien();
    }
}
