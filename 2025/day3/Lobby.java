import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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

  private static Map<String, Object> scanPack(String batteryBank, int leftOffIdx, int iterationNum) {
    Map<String, Object> output = new HashMap<>();

    char largestJolt = batteryBank.charAt(leftOffIdx);
    int largestBatteryIdx = leftOffIdx;

    for (int i = leftOffIdx; i < batteryBank.length() - (11 - iterationNum); i++) {
      char batteryjoltage = batteryBank.charAt(i);

      if (batteryjoltage > largestJolt) {
        largestJolt = batteryBank.charAt(i);
        largestBatteryIdx = i;
      }
    }

    output.put("leftOffIdx", largestBatteryIdx + 1);
    output.put("batteryJoltage", largestJolt);

    return output;
  }

  private static double partTwo(File file) {

    Double packJoltage = 0.0;

    try {
      Scanner input = new Scanner(file);

      while (input.hasNextLine()) {
        String batteryBank = input.nextLine();

        int leftOffIdx = 0;
        StringBuilder batteriesChosen = new StringBuilder();

        for (int i = 0; i < 12; i++) {
          Map<String, Object> packScanResult = Lobby.scanPack(batteryBank, leftOffIdx, i);

          leftOffIdx = (int) packScanResult.get("leftOffIdx");
          batteriesChosen.append(packScanResult.get("batteryJoltage"));
        }

        packJoltage = packJoltage + Double.parseDouble(batteriesChosen.toString());
      }

      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("Add part2.input");
    }

    return packJoltage;

  }

  public static void main(String[] args) {
    File partOneFile = new File("part1.input");
    File partTwoFile = new File("part2.input");

    int partOnePassword = partOne(partOneFile);
    double partTwoPassword = partTwo(partTwoFile);

    System.out.println("Part 1 pw:");
    System.out.println(partOnePassword);

    System.out.printf("Part 2 pw:\n%.0f\n", partTwoPassword);
  }
}
