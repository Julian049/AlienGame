package co.edu.uptc.model;

import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.util.ArrayList;

public class ManagerModel implements ContractPlay.Model {
    private ContractPlay.Presenter presenter;
    private ManageInfo manageInfo = new ManageInfo();
    private ManagerCannon managerCannon = new ManagerCannon();

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
                    String time = manageInfo.countSeconds() + "s " + manageInfo.getMinutes() + "m " + manageInfo.getHours() + "h";
                    presenter.updateTime(time);
                }
            }
        };
        thread.start();
    }

    @Override
    public CannonPojo getCannonPojo() {
        CannonPojo cannonPojo = managerCannon.getCannonPojo();
        return cannonPojo;
    }

    @Override
    public BulletPojo getBulletPojo() {
        BulletPojo bulletPojo = managerCannon.getBulletPojo();
        return bulletPojo;
    }

    @Override
    public void shoot() {
        managerCannon.shoot();
    }

    @Override
    public void moveCannonRight() {
        managerCannon.rightCannon();
    }

    @Override
    public void moveCannonLeft() {
        managerCannon.leftCannon();
    }


}
