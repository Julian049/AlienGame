package co.edu.uptc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ViewPropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/ViewConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int PAINT_SPEED_THREAD = Integer.parseInt(properties.getProperty("paintSpeedThread"));
    public static String FONT_NAME = properties.getProperty("fontName");
    public static int FONT_STYLE = Integer.parseInt(properties.getProperty("fontStyle"));
    public static int FONT_SIZE = Integer.parseInt(properties.getProperty("fontSize"));
    public static int FRAME_WIDTH = Integer.parseInt(properties.getProperty("frameWidth"));
    public static int FRAME_HEIGHT = Integer.parseInt(properties.getProperty("frameHeight"));
    public static int DASHBOARD_PANEL_WIDTH = Integer.parseInt(properties.getProperty("dashboardPanelWidth"));
    public static int DASHBOARD_PANEL_HEIGHT = Integer.parseInt(properties.getProperty("dashboardPanelHeight"));
    public static int INFORMATION_PANEL_WIDTH = Integer.parseInt(properties.getProperty("informationPanelWidth"));
    public static int INFORMATION_PANEL_HEIGHT = Integer.parseInt(properties.getProperty("informationPanelHeight"));


}
