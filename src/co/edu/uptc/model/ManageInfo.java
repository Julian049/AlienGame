package co.edu.uptc.model;

public class ManageInfo {

    private int seconds;
    private int minutes;
    private int hours;

    public ManageInfo() {
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }

    public int countSeconds() {
        if (seconds < 59) {
            seconds++;
        }else {
            countMinutes();
            seconds = 0;
        }
        return seconds;
    }

    public void countMinutes() {
        if (minutes < 59 && seconds == 59) {
            minutes++;
        }else {
            countHours();
            minutes = 0;
        }
    }

    public void countHours() {
        if (hours < 23 && minutes == 59) {
            hours++;
        }else {
            hours = 0;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}
