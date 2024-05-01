package co.edu.uptc.model;

import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;

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
        this.cannonPojo.setCoordinateX(540);
        this.cannonPojo.setCoordinateY(350);
        this.cannonPojo.setSize(200);
        this.cannonPojo.setSpeed(10);
        setBulletPojo();
    }

    public void setBulletPojo() {
        bulletPojo = new BulletPojo();
        this.bulletPojo.setCoordinateX(cannonPojo.getCoordinateX()+50);
        this.bulletPojo.setCoordinateY(cannonPojo.getCoordinateY()+50);
        this.bulletPojo.setSize(50);
        this.bulletPojo.setSpeed(1);
    }

    public void leftCannon() {
        cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() - cannonPojo.getSpeed());
        if (cannonPojo.getCoordinateX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightCannon() {
        cannonPojo.setCoordinateX(cannonPojo.getCoordinateX() + cannonPojo.getSpeed());
        if (cannonPojo.getCoordinateX() >= 1280) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void shoot() {
        setBulletPojo();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (bulletPojo.getCoordinateY() >= 0) {
                    try {
                        Thread.sleep(bulletPojo.getSpeed());
                        moveBullet(bulletPojo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bulletPojo = null;
            }
        };
        thread.start();
    }

    private void moveBullet(BulletPojo bulletPojo) {
        int coordinateY = bulletPojo.getCoordinateY();
        bulletPojo.setCoordinateY(coordinateY -1);
    }

    public CannonPojo getCannonPojo() {
        return cannonPojo;
    }

    public BulletPojo getBulletPojo() {
        return bulletPojo;
    }
}
