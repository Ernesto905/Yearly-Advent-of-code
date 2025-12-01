import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class SecretEntrance {

  private static int partOne(File file) {
    int password = 0;
    int dialNumber = 50;

    try {
      Scanner input = new Scanner(file);

      while (input.hasNextLine()) {
        String rotation = input.nextLine();

        int rotationAmount = Integer.parseInt(rotation.replaceAll("[^0-9]", ""));
        char rotationDirection = rotation.charAt(0);

        if (rotationDirection == 'L') {
          dialNumber = Math.floorMod(dialNumber - rotationAmount, 100);
        } else {
          dialNumber = Math.floorMod(dialNumber + rotationAmount, 100);
        }

        if (dialNumber == 0) {
          password = password + 1;
        }

      }

      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("add a part1.input file");
    }

    return password;
  }

  private static int partTwo(File file) {
    int password = 0;
    int dialNumber = 50;

    try {
      Scanner input = new Scanner(file);

      while (input.hasNextLine()) {
        String rotation = input.nextLine();

        int rotationAmount = Integer.parseInt(rotation.replaceAll("[^0-9]", ""));
        char rotationDirection = rotation.charAt(0);

        if (rotationDirection == 'L') {
          int oldDialNumber = dialNumber;

          while (rotationAmount > oldDialNumber) {
            // start from 0 & never loop around
            if (oldDialNumber == 0 && rotationAmount < 100) {
              break;
            }

            rotationAmount = rotationAmount - 100;
            password = password + 1;
          }

          dialNumber = Math.floorMod(dialNumber - rotationAmount, 100);
        } else {

          while (rotationAmount > 100) {
            rotationAmount = rotationAmount - 100;
            password = password + 1;
          }

          if (rotationAmount + dialNumber > 100) {
            rotationAmount = rotationAmount - 100;
            password = password + 1;
          }

          dialNumber = Math.floorMod(dialNumber + rotationAmount, 100);
        }

        if (dialNumber == 0) {
          password = password + 1;
        }

      }

      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("add a part2.input file");
    }

    return password;
  }

  public static void main(String[] args) {
    File partOneFile = new File("part1.input");
    File partTwoFile = new File("part2.input");

    int partOnePassword = SecretEntrance.partOne(partOneFile);
    int partTwoPassword = SecretEntrance.partTwo(partTwoFile);

    System.out.println("Part 1 pw: " + partOnePassword);
    System.out.println("Part 2 pw: " + partTwoPassword);

  }
}
