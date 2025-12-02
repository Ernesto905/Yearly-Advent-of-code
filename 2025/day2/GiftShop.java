import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiftShop {

  private static boolean isDoublet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 2 != 0) {
      // womp womp
      return false;
    }

    int halvedNumOfDigits = (int) numOfDigits / 2;
    int baseTenOperand = (int) Math.pow(10, halvedNumOfDigits);

    double firstNDigits = Math.floor(number / baseTenOperand);
    double lastNDigits = number % baseTenOperand;

    if (firstNDigits == lastNDigits) {
      return true;
    }

    return false;
  }

  private static boolean isTriplet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 3 != 0) {
      return false;
    }

    long thirdOfDigits = (long) numOfDigits / 3;
    int baseTenOperand = (int) Math.pow(10, thirdOfDigits);

    double lastThird = number % baseTenOperand;

    double theRest = Math.floor(number / baseTenOperand);
    double lastThirdOfTheRest = theRest % baseTenOperand;

    if (!isDoublet(theRest)) {
      return false;
    }

    if (lastThird != lastThirdOfTheRest) {
      return false;
    }

    return true;
  }

  private static boolean isQuintuplet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 5 != 0) {
      return false;
    }

    long fifthOfDigits = (long) numOfDigits / 5;
    int baseTenOperand = (int) Math.pow(10, fifthOfDigits);
    int baseTenOperandInvert = (int) Math.pow(10, numOfDigits - fifthOfDigits);

    double firstFifth = Math.floor(number / baseTenOperandInvert);
    double lastFifth = number % baseTenOperand;
    double theRest = Math.floor(number / baseTenOperand);
    double lastFifthOfTheRest = theRest % baseTenOperand;

    if (!isDoublet(theRest)) {
      return false;
    }

    if (firstFifth != lastFifthOfTheRest) {
      return false;
    }

    if (lastFifth != lastFifthOfTheRest) {
      return false;
    }

    return true;
  }

  private static boolean isSeptuplet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 7 != 0) {
      return false;
    }

    long seventhOfDigits = (long) numOfDigits / 7;
    int baseTenOperand = (int) Math.pow(10, seventhOfDigits);
    int baseTenOperandInvert = (int) Math.pow(10, numOfDigits - seventhOfDigits);

    double firstSeventh = Math.floor(number / baseTenOperandInvert);
    double lastSeventh = number % baseTenOperand;
    double theRest = Math.floor(number / baseTenOperand);
    double lastSeventhOfTheRest = theRest % baseTenOperand;

    if (!isDoublet(theRest)) {
      return false;
    }

    if (firstSeventh != lastSeventhOfTheRest) {
      return false;
    }

    if (lastSeventh != lastSeventhOfTheRest) {
      return false;
    }

    return true;
  }

  private static boolean isUndecuplet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 11 != 0) {
      return false;
    }

    long eleventhOfDigits = (long) numOfDigits / 11;
    int baseTenOperand = (int) Math.pow(10, eleventhOfDigits);

    int baseTenOperandInvert = (int) Math.pow(10, numOfDigits - eleventhOfDigits);

    double firstEleventh = Math.floor(number / baseTenOperandInvert);

    double lastEleventh = number % baseTenOperand;
    double theRest = Math.floor(number / baseTenOperand);
    double lastEleventhOfTheRest = theRest % baseTenOperand;

    if (!isDoublet(theRest)) {
      return false;
    }

    if (firstEleventh != lastEleventhOfTheRest) {
      return false;
    }

    if (lastEleventh != lastEleventhOfTheRest) {
      return false;
    }

    return true;
  }

  private static boolean isTredecuplet(double number) {
    double numOfDigits = Math.floor(Math.log10(number)) + 1;

    if (numOfDigits % 13 != 0) {
      return false;
    }

    long thirteenthOfDigits = (long) numOfDigits / 13;
    int baseTenOperand = (int) Math.pow(10, thirteenthOfDigits);

    int baseTenOperandInvert = (int) Math.pow(10, numOfDigits - thirteenthOfDigits);

    double firstThirteenth = Math.floor(number / baseTenOperandInvert);

    double lastThirteenth = number % baseTenOperand;
    double theRest = Math.floor(number / baseTenOperand);
    double lastThirteenthOfTheRest = theRest % baseTenOperand;

    if (!isDoublet(theRest)) {
      return false;
    }

    if (firstThirteenth != lastThirteenthOfTheRest) {
      return false;
    }

    if (lastThirteenth != lastThirteenthOfTheRest) {
      return false;
    }

    return true;
  }

  private static double partTwo() {
    File file = new File("part2.input");
    double totalSum = 0;

    try {
      Scanner input = new Scanner(file);

      input.useDelimiter("[,\\-\\s]");

      while (input.hasNext("[0-9]+")) {
        double currentNumber = Long.parseLong(input.next("[0-9]+"));
        double lastNumber = Long.parseLong(input.next("[0-9]+"));

        for (; currentNumber <= lastNumber; currentNumber++) {

          if (isDoublet(currentNumber)) {
            totalSum = totalSum + currentNumber;
            System.out.println("2 Bad boy: " + currentNumber);
          }

          // me and my homies love prime numbers
          else if (isTriplet(currentNumber)) {
            totalSum = totalSum + currentNumber;

            System.out.println("3 Bad boy: " + currentNumber);
          } else if (isQuintuplet(currentNumber)) {
            totalSum = totalSum + currentNumber;

            System.out.println("5 Bad boy: " + currentNumber);
          } else if (isSeptuplet(currentNumber)) {
            totalSum = totalSum + currentNumber;
            System.out.println("7 Bad boy: " + currentNumber);
          } else if (isUndecuplet(currentNumber)) {
            totalSum = totalSum + currentNumber;
            System.out.println("9 Bad boy: " + currentNumber);
          } else if (isTredecuplet(currentNumber)) {
            totalSum = totalSum + currentNumber;
            System.out.println("13 Bad boy: " + currentNumber);
          }

        }
      }
      input.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("add part2.input");
    }

    return totalSum;

  }

  public static void main(String[] args) {
    /*
     * double testNum = 123123123;
     * double testNum2 = 121212;
     * double testNum3 = 111;
     * 
     * double testFifth1 = 11111;
     * double testFifth2 = 1212121212;
     * 
     * double testSeventh = 1111111;
     * 
     * double testEleventh = 11111111111D;
     * 
     * double testsThirteenth = 1111111111111D;
     * double testsThirteenth2 = 12121212121212121212121212D;
     * 
     * assert GiftShop.isTriplet(testNum);
     * assert GiftShop.isTriplet(testNum2);
     * assert GiftShop.isTriplet(testNum3);
     * 
     * assert GiftShop.isQuintuplet(testFifth1);
     * assert GiftShop.isQuintuplet(testFifth2);
     * 
     * assert GiftShop.isSeptuplet(testSeventh);
     * 
     * assert GiftShop.isUndecuplet(testEleventh);
     * 
     * assert GiftShop.isTredecuplet(testsThirteenth);
     * assert GiftShop.isTredecuplet(testsThirteenth2);
     */

    double total = GiftShop.partTwo();
    System.out.printf("%.0f\n", total);
    /*
     * File file = new File("part1.input");
     * long totalSum = 0;
     * 
     * try {
     * Scanner input = new Scanner(file);
     * 
     * input.useDelimiter("[,\\-\\s]");
     * 
     * while (input.hasNext("[0-9]+")) {
     * long currentNumber = Long.parseLong(input.next("[0-9]+"));
     * long lastNumber = Long.parseLong(input.next("[0-9]+"));
     * 
     * for (; currentNumber <= lastNumber; currentNumber++) {
     * if (isDoublet(currentNumber)) {
     * totalSum = totalSum + currentNumber;
     * }
     * }
     * }
     * input.close();
     * 
     * } catch (FileNotFoundException fnfe) {
     * System.out.println("add a part1.input file");
     * }
     * 
     * System.out.println(totalSum);
     */
  }
}
