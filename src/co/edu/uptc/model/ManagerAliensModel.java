package co.edu.uptc.model;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.SleepUtil;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerAliensModel {

    private CopyOnWriteArrayList<AlienPojo> aliens = new CopyOnWriteArrayList<>();
    private int aliensAlive = 0;
    private ManagerModel managerModel;

    public void setManagerModel(ManagerModel managerModel) {
        this.managerModel = managerModel;
    }

    public synchronized void spawnNewAlien() {
        Thread thread = new Thread(() -> {
            while (true) {
                SleepUtil.sleep(ModelPropertiesUtil.TIME_TO_SPAWN_ALIEN);
                AlienPojo alien = new AlienPojo();
                alien.setWidth(randomWidth());
                alien.setHeight(randomHeight());
                alien.setCoordinateY(randomY(alien));
                alien.setSpeed(randomSpeed());
                randomType(alien);
                aliensAlive++;
                aliens.add(alien);
            }
        });
        thread.start();

    }

    private int randomWidth() {
        Random random = new Random();
        int min = ModelPropertiesUtil.MIN_ALIEN_WIDTH;
        int max = ModelPropertiesUtil.MAX_ALIEN_WIDTH;
        return random.nextInt((max - min) + 1) + min;
    }

    private int randomHeight() {
        Random random = new Random();
        int min = ModelPropertiesUtil.MIN_ALIEN_HEIGHT;
        int max = ModelPropertiesUtil.MAX_ALIEN_HEIGHT;
        return random.nextInt((max - min) + 1) + min;
    }

    private int randomSpeed() {
        Random random = new Random();
        int min = ModelPropertiesUtil.MIN_ALIEN_SPEED;
        int max = ModelPropertiesUtil.MAX_ALIEN_SPEED;
        return random.nextInt((max - min) + 1) + min;
    }

    private int randomY(AlienPojo alien) {
        Random random = new Random();
        int Y;
        int maxY = ((managerModel.getFrameHeight() / 2) - alien.getHeight());
        Y = random.nextInt(maxY);
        return Y;
    }

    private void randomType(AlienPojo alien) {
        int option = new Random().nextInt(2);
        switch (option) {
            case 0:
                alien.setDirection(DirectionEnum.LEFT);
                alien.setCoordinateX(managerModel.getFrameWidth() - alien.getWidth());
                break;
            case 1:
                alien.setDirection(DirectionEnum.RIGHT);
                alien.setCoordinateX(0);
                break;
        }
    }

    public synchronized void startAliens() {
        Thread thread = new Thread(() -> {
            while (true) {
                for (AlienPojo alien : aliens) {
                    moveAlien(alien);
                }
                SleepUtil.sleep(ModelPropertiesUtil.SPEED_ALIENS);
            }
        });
        thread.start();
    }

    public void moveAlien(AlienPojo alien) {
        if (alien.getDirection() == DirectionEnum.LEFT) {
            leftAlien(alien);
        }
        if (alien.getDirection() == DirectionEnum.RIGHT) {
            rightAlien(alien);
        }
    }

    public synchronized void leftAlien(AlienPojo alien) {
        alien.setCoordinateX(alien.getCoordinateX() - alien.getSpeed());
        if ((alien.getCoordinateX() + alien.getWidth()) < 0) {
            aliens.remove(alien);
        }
    }

    public synchronized void rightAlien(AlienPojo alien) {
        alien.setCoordinateX(alien.getCoordinateX() + alien.getSpeed());
        if (alien.getCoordinateX() >= managerModel.getFrameWidth()) {
            aliens.remove(alien);
        }
    }

    public CopyOnWriteArrayList<AlienPojo> getAliens() {
        return aliens;
    }

    public int getAliensAlive() {
        return aliensAlive;
    }
}
