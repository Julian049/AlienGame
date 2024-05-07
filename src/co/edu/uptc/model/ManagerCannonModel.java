package co.edu.uptc.model;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerCannonModel {
    private CannonPojo cannonPojo;
    private CopyOnWriteArrayList<BulletPojo> bullets = new CopyOnWriteArrayList<>();
    private boolean bulletCollision = false;
    private ManagerModel managerModel;
    private int aliensKilled;

    public void initCannon() {
        cannonPojo = new CannonPojo();
        this.cannonPojo.setWidth(ModelPropertiesUtil.CANNON_WIDTH);
        this.cannonPojo.setHeight(ModelPropertiesUtil.CANNON_HEIGHT);
        this.cannonPojo.setCoordinateX(managerModel.getFrameWidth() / 2);
        updateYCoordinate();
        this.cannonPojo.setSpeed(ModelPropertiesUtil.CANNON_PIXEL_MOVEMENT);
    }

    public void setManagerModel(ManagerModel managerModel) {
        this.managerModel = managerModel;
    }

    public void setBulletPojo(BulletPojo bulletPojo) {
        bulletPojo.setWidth(ModelPropertiesUtil.BULLET_WIDTH);
        bulletPojo.setHeight(ModelPropertiesUtil.BULLET_HEIGHT);
        int middleCannonX = cannonPojo.getCoordinateX() + cannonPojo.getWidth() / 2;
        int middleCannonY = cannonPojo.getCoordinateY() + cannonPojo.getHeight() / 2;
        bulletPojo.setCoordinateX(middleCannonX - bulletPojo.getWidth() / 2);
        bulletPojo.setCoordinateY(middleCannonY - bulletPojo.getHeight() / 2);
        bulletPojo.setSpeed(ModelPropertiesUtil.BULLET_PIXEL_MOVEMENT);
    }

    public void leftCannon() {
        if (cannonPojo.getCoordinateX() >= 0) {
            cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() - cannonPojo.getSpeed());
        }
    }

    public void rightCannon() {
        if (cannonPojo.getCoordinateX() <= (managerModel.getFrameWidth() - cannonPojo.getWidth())) {
            cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() + cannonPojo.getSpeed());
        }
    }

    public void shoot(CopyOnWriteArrayList<AlienPojo> aliens) {
        BulletPojo bulletPojo = new BulletPojo();
        setBulletPojo(bulletPojo);
        bullets.add(bulletPojo);
        Thread thread = new Thread(() -> {
            while (bulletPojo.getCoordinateY() >= 0 && !bulletCollision) {
                SleepUtil.sleep(1);
                moveBullet(bulletPojo);
                killAlien(aliens, bulletPojo);
            }
            bullets.remove(bulletPojo);
            bulletCollision = false;
        });
        thread.start();
    }

    private void moveBullet(BulletPojo bulletPojo) {
        if (!bulletCollision) {
            int coordinateY = bulletPojo.getCoordinateY();
            bulletPojo.setCoordinateY(coordinateY - bulletPojo.getSpeed());
        } else {
            bulletPojo.setCoordinateY(cannonPojo.getCoordinateY());
        }
    }

    public CannonPojo getCannonPojo() {
        return cannonPojo;
    }

    public CopyOnWriteArrayList<BulletPojo> getBullets() {
        return bullets;
    }

    public void killAlien(CopyOnWriteArrayList<AlienPojo> aliens, BulletPojo bulletPojo) {
        List<AlienPojo> toRemove = new CopyOnWriteArrayList<>();
        for (AlienPojo alien : aliens) {
            int ax1 = alien.getCoordinateX();
            int ax2 = alien.getCoordinateX() + alien.getWidth();
            int bx1 = bulletPojo.getCoordinateX();
            int bx2 = bulletPojo.getCoordinateX() + bulletPojo.getWidth();
            int by = bulletPojo.getCoordinateY();
            if (by >= alien.getCoordinateY() && by <= alien.getCoordinateY() + alien.getHeight()) {
                if ((bx1 <= ax2 && bx1 >= ax1) || (bx2 <= ax2 && bx2 >= ax1)) {
                    toRemove.add(alien);
                    bulletCollision = true;
                    aliensKilled++;
                    break;
                }
            }
        }
        aliens.removeAll(toRemove);
    }

    public int getAliensKilled() {
        return aliensKilled;
    }

    public void updateYCoordinate() {
        int downSide = managerModel.getFrameHeight() - cannonPojo.getHeight();
        cannonPojo.setCoordinateY(downSide);
    }
}
