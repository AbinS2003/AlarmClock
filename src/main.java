import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "src\\alarm_beeps.wav";

        while (alarmTime == null) {

            try {

                System.out.print("Enter the alarm time (HH:MM:SS:): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeParseException e) {

                System.out.println("Invalid Format!");
            }

        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);

        alarmThread.start();

    }
}
