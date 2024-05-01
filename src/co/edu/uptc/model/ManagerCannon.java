package co.edu.uptc.model;

import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.util.ArrayList;

public class ManagerCannon {
    private CannonPojo cannonPojo;
    private BulletPojo bulletPojo;
    private DirectionEnum direction = DirectionEnum.LEFT;

    public void setCannonPojo(CannonPojo cannonPojo) {
        this.cannonPojo = cannonPojo;
    }

    public ManagerCannon() {
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
        this.bulletPojo.setCoordinateX(cannonPojo.getCoordinateX());
        this.bulletPojo.setCoordinateY(cannonPojo.getCoordinateY());
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

    public void shoot() {
        setBulletPojo();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (bulletPojo.getCoordinateY() >= ModelPropertiesUtil.MIN_BULLET_MOVEMENT) {
                    SleepUtil.sleep(bulletPojo.getSpeed());
                    moveBullet(bulletPojo);
                }
                bulletPojo = null;
            }
        };
        thread.start();
    }

    private void moveBullet(BulletPojo bulletPojo) {
        int coordinateY = bulletPojo.getCoordinateY();
        bulletPojo.setCoordinateY(coordinateY - bulletPojo.getSpeed());
    }

    public CannonPojo getCannonPojo() {
        return cannonPojo;
    }

    public BulletPojo getBulletPojo() {
        return bulletPojo;
    }
}
