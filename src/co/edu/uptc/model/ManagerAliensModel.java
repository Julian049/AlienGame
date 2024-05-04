package co.edu.uptc.model;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.util.ModelPropertiesUtil;
import co.edu.uptc.util.ViewPropertiesUtil;

import java.util.ArrayList;
import java.util.Random;

public class ManagerAliensModel {

    private ArrayList<AlienPojo> aliens = new ArrayList<>();
    ;

    public void createAliens() {
        for (int i = 0; i < 10; i++) {
            AlienPojo alien = new AlienPojo();
            alien.setWidth(randomWidth());
            alien.setHeight(randomHeight());
            alien.setCoordinateX(randomX(alien));
            alien.setCoordinateY(randomY(alien));
            alien.setSpeed(randomSpeed());
            randomType(alien);
            aliens.add(alien);
        }
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

    private int randomX(AlienPojo alien) {
        Random random = new Random();
        int X = 0;
        X = random.nextInt(ViewPropertiesUtil.FRAME_WIDTH - alien.getWidth());
        return X;
    }

    private int randomY(AlienPojo alien) {
        Random random = new Random();
        int Y = 0;
        int maxY = ((ViewPropertiesUtil.DASHBOARD_PANEL_HEIGHT / 2) - alien.getHeight());
        Y = random.nextInt(maxY);
        return Y;
    }

    private void randomType(AlienPojo alien) {
        int option = new Random().nextInt(2);
        switch (option) {
            case 0:
                alien.setDirection(DirectionEnum.LEFT);
                break;
            case 1:
                alien.setDirection(DirectionEnum.RIGHT);
                break;
        }
    }

    public void startAliens() {

        for (AlienPojo alien : aliens) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(alien.getSpeed());
                            moveAlien(alien);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }

    public void moveAlien(AlienPojo alien) {
        if (alien.getDirection() == DirectionEnum.LEFT) {
            leftAlien(alien);
        }
        if (alien.getDirection() == DirectionEnum.RIGHT) {
            rightAlien(alien);
        }
    }

    public void leftAlien(AlienPojo alien) {
        alien.setCoordinateX(alien.getCoordinateX() - ModelPropertiesUtil.CANNON_PIXEL_MOVEMENT);
        if (alien.getCoordinateX() < 0) {
            alien.setDirection(DirectionEnum.RIGHT);
        }
    }

    public void rightAlien(AlienPojo alien) {
        alien.setCoordinateX(alien.getCoordinateX() + ModelPropertiesUtil.CANNON_PIXEL_MOVEMENT);
        if (alien.getCoordinateX() >= (ViewPropertiesUtil.FRAME_WIDTH - alien.getWidth())) {
            alien.setDirection(DirectionEnum.LEFT);
        }
    }

    public ArrayList<AlienPojo> getAliens() {
        return aliens;
    }
}
