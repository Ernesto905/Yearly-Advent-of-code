import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Lobby {

  private static int partOne(File file) {

    int packJoltage = 0;

    try {
      Scanner input = new Scanner(file);

      while (input.hasNextLine()) {
        String batteryBank = input.nextLine();

        char largestLeftBattery;
        char largestRightBattery;

        char largestJolt = batteryBank.charAt(0);
        int largestBatteryIdx = 0;

        for (int i = 0; i < batteryBank.length() - 1; i++) {
          char batteryjoltage = batteryBank.charAt(i);

          if (batteryjoltage > largestJolt) {
            largestJolt = batteryBank.charAt(i);
            largestBatteryIdx = i;
          }
        }

        largestLeftBattery = largestJolt;
        largestJolt = batteryBank.charAt(largestBatteryIdx + 1);

        for (int i = largestBatteryIdx + 1; i < batteryBank.length(); i++) {
          int batteryjoltage = batteryBank.charAt(i);

          if (batteryjoltage > largestJolt) {
            largestJolt = batteryBank.charAt(i);
          }
        }

        largestRightBattery = largestJolt;

        StringBuilder bankJoltage = new StringBuilder().append(largestLeftBattery).append(largestRightBattery);
        packJoltage = packJoltage + Integer.parseInt(bankJoltage.toString());
      }

      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("Add part1.input");
    }

    return packJoltage;

  }

  public static void main(String[] args) {
    File partOneFile = new File("part1.input");
    File partTwoFile = new File("part2.input");

    int partOnePassword = partOne(partOneFile);
    // int partTwoPassword = partOne(partTwoFile);

    System.out.println("Part pw:");
    System.out.println(partOnePassword);
  }
}
