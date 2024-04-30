package co.edu.uptc.pojo;

import java.util.List;

public class CannonPojo {

    private int coordinateX;
    private int coordinateY;
    private int speed;
    private int size;
    private List<BulletPojo> bullets;

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<BulletPojo> getBullets() {
        return bullets;
    }

    public void setBullets(List<BulletPojo> bullets) {
        this.bullets = bullets;
    }
}
