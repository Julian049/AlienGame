package co.edu.uptc.util;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ViewPropertiesUtil {
    private static final Properties properties = new Properties();
    private static Font myFont;

    static {
        try {
            properties.load(new FileInputStream("src/ViewConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int PAINT_SPEED_THREAD = Integer.parseInt(properties.getProperty("paintSpeedThread"));
    public static int FRAME_WIDTH = Integer.parseInt(properties.getProperty("frameWidth"));
    public static int FRAME_HEIGHT = Integer.parseInt(properties.getProperty("frameHeight"));
    public static String ALIEN_IMAGE = properties.getProperty("alienImage");
    public static String CANNON_IMAGE = properties.getProperty("cannonImage");
    public static String BULLET_IMAGE = properties.getProperty("bulletImage");
    public static String BACKGROUND_IMAGE = properties.getProperty("backgroundImage");

    public static Font getMyFont() {
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, new File(properties.getProperty("fontPath")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return myFont;
    }

    public static String ALIENS_ALIVE_TITLE = properties.getProperty("aliensAliveTitle");
    public static String ALIENS_KILLED_TITLE = properties.getProperty("aliensKilledTitle");
    public static String TIME_TITLE = properties.getProperty("timeTitle");
    public static int MENU_WIDTH = Integer.parseInt(properties.getProperty("menuWidth"));
    public static int MENU_HEIGHT = Integer.parseInt(properties.getProperty("menuHeight"));
    public static String MENU_KEY_LABEL = properties.getProperty("menuKeyLabel");
    public static String BEFORE_SELECT_KEY_LABEL = properties.getProperty("beforeSelectKeyLabel");
    public static String KEY_SELECTED = properties.getProperty("keySelectedLabel");
    public static String START_BUTTON_TEXT = properties.getProperty("startButtonText");
    public static String ERROR_TEXT = properties.getProperty("errorText");
    public static String TITLE_GAME_LABEL = properties.getProperty("titleGameLabel");
    public static String NOTE_LABEL = properties.getProperty("noteLabel");
}
