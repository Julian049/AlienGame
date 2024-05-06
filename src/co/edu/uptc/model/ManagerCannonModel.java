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
    private BulletPojo bulletPojo;
    private DirectionEnum direction = DirectionEnum.LEFT;
    private boolean shoot = false;
    private ManagerAliensModel managerAliensModel = new ManagerAliensModel();
    private boolean bulletCollision = false;
    private int aliensKilled;

    public void setCannonPojo(CannonPojo cannonPojo) {
        this.cannonPojo = cannonPojo;
    }

    public ManagerCannonModel() {
        cannonPojo = new CannonPojo();
        this.cannonPojo.setCoordinateX(ModelPropertiesUtil.CANNON_X);
        this.cannonPojo.setCoordinateY(ModelPropertiesUtil.CANNON_Y);
        this.cannonPojo.setWidth(ModelPropertiesUtil.CANNON_WIDTH);
        this.cannonPojo.setHeight(ModelPropertiesUtil.CANNON_HEIGHT);
        this.cannonPojo.setSpeed(ModelPropertiesUtil.CANNON_PIXEL_MOVEMENT);
        setBulletPojo();
    }

    public void setBulletPojo() {
        bulletPojo = new BulletPojo();
        this.bulletPojo.setWidth(ModelPropertiesUtil.BULLET_WIDTH);
        this.bulletPojo.setHeight(ModelPropertiesUtil.BULLET_HEIGHT);

        int middleCannonX = cannonPojo.getCoordinateX() + cannonPojo.getWidth() / 2;
        int middleCannonY = cannonPojo.getCoordinateY() + cannonPojo.getHeight() / 2;

        this.bulletPojo.setCoordinateX(middleCannonX - bulletPojo.getWidth() / 2);
        this.bulletPojo.setCoordinateY(middleCannonY - bulletPojo.getHeight() / 2);



        this.bulletPojo.setSpeed(ModelPropertiesUtil.BULLET_PIXEL_MOVEMENT);
    }

    public void leftCannon() {
        cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() - cannonPojo.getSpeed());
        if (cannonPojo.getCoordinateX() <= ModelPropertiesUtil.MIN_CANNON_MOVEMENT) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightCannon() {
        cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() + cannonPojo.getSpeed());
        if (cannonPojo.getCoordinateX() >= ModelPropertiesUtil.MAX_CANNON_MOVEMENT) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void shoot(CopyOnWriteArrayList<AlienPojo> aliens) {
        if (shoot) {
            return;
        }
        shoot = true;
        setBulletPojo();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (bulletPojo.getCoordinateY() >= ModelPropertiesUtil.MIN_BULLET_MOVEMENT && !bulletCollision) {
                    SleepUtil.sleep(1);
                    if (bulletPojo != null) {
                        moveBullet(bulletPojo);
                        killAlien(aliens);
                    }
                }
                bulletPojo = null;
                shoot = false;
                bulletCollision = false;
            }
        };
        thread.start();
    }

    private void moveBullet(BulletPojo bulletPojo) {
        if (!bulletCollision){
            int coordinateY = bulletPojo.getCoordinateY();
            bulletPojo.setCoordinateY(coordinateY - bulletPojo.getSpeed());
        }else {
            bulletPojo.setCoordinateY(cannonPojo.getCoordinateY());
        }
    }

    public CannonPojo getCannonPojo() {
        return cannonPojo;
    }

    public BulletPojo getBulletPojo() {
        return bulletPojo;
    }

    public void killAlien(CopyOnWriteArrayList<AlienPojo> aliens) {
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
}
