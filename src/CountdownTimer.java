import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class CountdownTimer {
//A countdown timer that alerts the user when the time has reached 00:00:00 (hh:mm:ss).

        public static void main(String[] args) throws Exception {

            Scanner input = new Scanner(System.in);

            //Getting the users desired time to countdown from.
            Time time = inputTime(input);

            System.out.println("Counting down from " + time.toString());

            /**
             *
             *
             */
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (time.getSeconds() > 0) {
                        System.out.println(time.toString());
                        try {
                            time.subtractSecond();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    else {
                        System.out.println(time.toString() + "\n END");
                        timer.cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 1000, 1000);
        }


    private static Time inputTime(Scanner input) throws Exception{

        //Result will eventually refer to a legal time
        Time result = null;
        System.out.print("Please input the time to countdown from in the format (hh:mm:ss): ");

        //Keep trying until we get a legal time
        boolean inputValidYet = false;
            do {
                try {
                    result = new Time(input.nextInt(), input.nextInt(), input.nextInt());
                    //If we get here, the time was valid
                    inputValidYet = true;
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.print("Please re-type the time to countdown from in the format (hh:mm:ss): ");
                }
            } while (!inputValidYet);
            //When we get here the result will be a valid time
            return result;
        }
}


