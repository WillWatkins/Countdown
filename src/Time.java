
public class Time {
    private int hours, minutes, seconds;


    /**
     * Creating a Time object.
     *
     * @param requiredHours hours
     * @param requiredMinutes minutes
     * @param requiredSeconds seconds
     */
    public Time (int requiredHours, int requiredMinutes, int requiredSeconds){
        hours = requiredHours;
        minutes = requiredMinutes;
        seconds = requiredSeconds;
    }

    /**
     * The method to countdown.
     *
     * @return a new instance of Time.
     */
    public Time subtractSecond(){
        if (seconds >= 1) {
            seconds--;
        }
        if (seconds == 0 && minutes > 0) {
            minutes--;
            seconds = 59;
            return new Time(hours, minutes,seconds);
        }
        if (seconds == 0 && minutes == 0 && hours > 0){
            hours--;
            minutes = 59;
            seconds = 59;
        }
        return new Time(hours, minutes, seconds);
    }

    /**
     * @return The seconds of the countdown
     */
    public int getSeconds(){
        return seconds;
    }

    /**
     * @return The minutes of the countdown
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return The hours of the countdown
     */
    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
