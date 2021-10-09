import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String[] sunrise = parts[3].split(":");
            String[] sunset = parts[4].split(":");

            int sunriseTotal = Integer.parseInt(sunrise[0]) * 60 + Integer.parseInt(sunrise[1]);
            int sunsetTotal = Integer.parseInt(sunset[0]) * 60 + Integer.parseInt(sunset[1]);

            System.out
                    .println(parts[0] + " " + parts[1] + " " + parts[2] + " " + minString(sunsetTotal - sunriseTotal));
        }
    }

    public static String minString(int mins) {
        return (mins / 60) + " hours " + (mins - ((mins / 60) * 60)) + " minutes";
    }
}
