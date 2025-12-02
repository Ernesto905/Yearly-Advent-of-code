import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiftShop {

  private static boolean isDoublet(long number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 2 != 0) {
      // womp womp
      return false;
    }

    int halvedNumOfDigits = (int) numOfDigits / 2;
    int baseTenOperand = (int) Math.pow(10, halvedNumOfDigits);

    double firstNDigits = Math.floorDiv(number, baseTenOperand);
    double lastNDigits = Math.floorMod(number, baseTenOperand);

    if (firstNDigits == lastNDigits) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    File file = new File("part1.input");
    long totalSum = 0;

    try {
      Scanner input = new Scanner(file);

      input.useDelimiter("[,\\-\\s]");

      while (input.hasNext("[0-9]+")) {
        long currentNumber = Long.parseLong(input.next("[0-9]+"));
        long lastNumber = Long.parseLong(input.next("[0-9]+"));

        for (; currentNumber <= lastNumber; currentNumber++) {
          if (isDoublet(currentNumber)) {
            totalSum = totalSum + currentNumber;
          }
        }
      }
      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("add a part1.input file");
    }

    System.out.println(totalSum);
  }
}
