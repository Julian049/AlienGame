package co.edu.uptc.model;

import co.edu.uptc.pojo.CannonPojo;

public class ManagerCannon {
    private CannonPojo cannonPojo;
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

    public CannonPojo getCannonPojo() {
        return cannonPojo;
    }
}
