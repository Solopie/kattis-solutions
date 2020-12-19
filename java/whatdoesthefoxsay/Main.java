import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();
        // Get rid of newline
        sc.nextLine();

        for (int i = 0; i < numCases; i++) {
            HashSet<String> animalSounds = new HashSet<>();
            String recording = sc.nextLine();
            String curLine = sc.nextLine();

            // Save all animal sounds
            while (!curLine.equals("what does the fox say?")) {
                String[] curLineParts = curLine.split(" ");
                animalSounds.add(curLineParts[2]);
                curLine = sc.nextLine();
            }

            String[] recordingParts = recording.split(" ");
            ArrayList<String> foxSounds = new ArrayList<>();
            for (int j = 0; j < recordingParts.length; j++) {
                if (!animalSounds.contains(recordingParts[j])) {
                    foxSounds.add(recordingParts[j]);
                }
            }

            System.out.println(String.join(" ", foxSounds));
        }
    }
}
