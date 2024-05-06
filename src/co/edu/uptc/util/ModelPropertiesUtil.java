package co.edu.uptc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ModelPropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/ModelConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int INIT_TIME = Integer.parseInt(properties.getProperty("initTime"));
    public static int MAX_SECONDS_AND_MINUTES = Integer.parseInt(properties.getProperty("maxSecondsAndMinutes"));
    public static int MAX_HOURS = Integer.parseInt(properties.getProperty("maxHours"));
    public static int CANNON_X = Integer.parseInt(properties.getProperty("cannonX"));
    public static int CANNON_Y = Integer.parseInt(properties.getProperty("cannonY"));
    public static int CANNON_WIDTH = Integer.parseInt(properties.getProperty("cannonWidth"));
    public static int CANNON_HEIGHT = Integer.parseInt(properties.getProperty("cannonHeight"));
    public static int CANNON_PIXEL_MOVEMENT = Integer.parseInt(properties.getProperty("cannonPixelMovement"));
    public static int BULLET_WIDTH = Integer.parseInt(properties.getProperty("bulletWidth"));
    public static int BULLET_HEIGHT = Integer.parseInt(properties.getProperty("bulletHeight"));
    public static int BULLET_PIXEL_MOVEMENT = Integer.parseInt(properties.getProperty("bulletPixelMovement"));
    public static int MIN_CANNON_MOVEMENT = Integer.parseInt(properties.getProperty("minCannonMovement"));
    public static int MAX_CANNON_MOVEMENT = Integer.parseInt(properties.getProperty("maxCannonMovement"));
    public static int MIN_BULLET_MOVEMENT = Integer.parseInt(properties.getProperty("minBulletMovement"));
    public static int SPEED_TIME_THREAD = Integer.parseInt(properties.getProperty("speedTimeThread"));
    public static int MIN_ALIEN_WIDTH = Integer.parseInt(properties.getProperty("minAlienWidth"));
    public static int MAX_ALIEN_WIDTH = Integer.parseInt(properties.getProperty("maxAlienWidth"));
    public static int MIN_ALIEN_HEIGHT = Integer.parseInt(properties.getProperty("minAlienHeight"));
    public static int MAX_ALIEN_HEIGHT = Integer.parseInt(properties.getProperty("maxAlienHeight"));
    public static int MIN_ALIEN_SPEED = Integer.parseInt(properties.getProperty("minAlienSpeed"));
    public static int MAX_ALIEN_SPEED = Integer.parseInt(properties.getProperty("maxAlienSpeed"));
    public static int TIME_TO_SPAWN_ALIEN = Integer.parseInt(properties.getProperty("timeToSpawnAlien"));
    public static int INITIAL_ALIENS = Integer.parseInt(properties.getProperty("initialAliens"));
}
