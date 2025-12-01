import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class SecretEntrance {
  public static void main(String[] args) {
    File file = new File("part1.input");

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

    System.out.println("Password: " + password);
  }
}
