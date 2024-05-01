package co.edu.uptc.model;

import co.edu.uptc.util.ModelPropertiesUtil;

public class ManageInfo {

    private int seconds;
    private int minutes;
    private int hours;

    public ManageInfo() {
        this.seconds = ModelPropertiesUtil.INIT_TIME;
        this.minutes = ModelPropertiesUtil.INIT_TIME;
        this.hours = ModelPropertiesUtil.INIT_TIME;
    }

    public int countSeconds() {
        if (seconds < ModelPropertiesUtil.MAX_SECONDS_AND_MINUTES) {
            seconds++;
        }else {
            countMinutes();
            seconds = ModelPropertiesUtil.INIT_TIME;
        }
        return seconds;
    }

    public void countMinutes() {
        if (minutes < ModelPropertiesUtil.MAX_SECONDS_AND_MINUTES && seconds == ModelPropertiesUtil.MAX_SECONDS_AND_MINUTES) {
            minutes++;
        }else {
            countHours();
            minutes = ModelPropertiesUtil.INIT_TIME;
        }
    }

    public void countHours() {
        if (hours < ModelPropertiesUtil.MAX_HOURS && minutes == ModelPropertiesUtil.MAX_SECONDS_AND_MINUTES) {
            hours++;
        }else {
            hours = ModelPropertiesUtil.INIT_TIME;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}
