/**
 * Created by yura- on 11.07.2016.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import  java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) {
        System.out.println("App was started. Enter '--stop' to exit.");
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter new line...");
                String line = sc.nextLine();
                if ("--stop".equals(line)) {
                    System.out.println("App was stopped");
                    return;
                }
                writeToFile(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void writeToFile(String consoleText) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("ConsoleText.txt", true));
            bw.write(consoleText);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
