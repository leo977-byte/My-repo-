import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;
public class SpeedDetector {
    static String[] sentences = {
      "bright city lights shimmered across the water late at night",
      "the sound of laughter echoed through the quiet hallway",
      "a lot of people enjoy drinking hot coffee while reading a book",
      "tech is constantly evolving and changing the way we live and work"
    };
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("-------------------------------");
        System.out.println("    TYPING SPEED TEST   ");
        System.out.println("-------------------------------");

        String sentence = sentences[random.nextInt(sentences.length)];
        System.out.println("Type the following sentence");
        System.out.println(">> " + sentence);
        System.out.println("Star typing");
        long startTime = System.currentTimeMillis();
        String input = scanner.nextLine();
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime);

        int wordCount = sentence.split(" ").length;
        double wpm = (wordCount / (timeTaken / 1000 / 60.0));
        int correct = 0;
        String[] originalWords = sentence.split(" ");
        String[] typedWords = input.split(" ");
        for (int i = 0; i < originalWords.length; i++) {
            if (i < typedWords.length && typedWords[i].equals(originalWords[i])) {
                correct++;
            }
        }
        double accuracy = ((double) correct / originalWords.length) * 100;
        System.out.println("-------------------------------");
        System.out.println("   RESULTS   ");
        System.out.println("-------------------------------");
        System.out.printf("Time taken  : %.2f seconds%n", timeTaken);
        System.out.printf("Speed       : %.1f WPM%n", wpm);
        System.out.printf("Accuracy    : %.1f%%%n", accuracy);
        System.out.printf("Words Typed : %d / %d correct%n", correct , originalWords.length);

        if (accuracy == 100){
            System.out.println("perfect no mistakes!");
        }
        else if (accuracy >= 80){
            System.out.println("Great job!");
        }
        else {
            System.out.println("keep practicing");
        }
        scanner.close();

    }
}