
public class Time {
    private int hours, minutes, seconds;


    /**
     * Creating a Time object.
     *
     * @param requiredHours hours
     * @param requiredMinutes minutes
     * @param requiredSeconds seconds
     */
    public Time (int requiredHours, int requiredMinutes, int requiredSeconds) throws Exception{

        hours = requiredHours;
        minutes = requiredMinutes;
        seconds = requiredSeconds;

        checkTimeIsLegal();
    }

    /**
     * The method to countdown.
     *
     * @return a new instance of Time.
     */
    public Time subtractSecond() throws Exception{
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
        try {
            return new Time(hours, minutes, seconds);
        }
        catch (Exception exception){
            return null;
        }
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

    public void checkTimeIsLegal() throws Exception{
        if (minutes > 59)
            throw new Exception("Minutes are only up to 59, otherwise add on an hour");
        if (seconds > 59)
            throw new Exception("Seconds are only up to 59, otherwise add on a minute");

    }

}
