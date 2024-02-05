package atm_cli_project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCheck extends Account {

  Scanner scanner = new Scanner(System.in);

  boolean pinCheck() {
    Formating.printDash();
    Formating.greenColor("Please Enter your ATM pin");
    Formating.printDash();
    // set getPinEnterLimit for if you continuously doing some operations
    setPinEnterLimit(3);
    while (getPinEnterLimit() > 0) {
      try {
        int enteredPinNumber = scanner.nextInt();

        if (pinDigit(enteredPinNumber)) {
          if (enteredPinNumber == getPinNumber()) {
            return true; // Return true if the correct PIN is entered
          } else {
            if (getPinEnterLimit() == 1) {
              Formating.printDash();
              Formating.redColor("You exceeded your pin limit...");
              return false; // Return false if the pin limit is exceeded
            } else {
              Formating.printDash();
              Formating.redColor(
                "Please enter the correct 4-Digit ATM pin Number"
              );
              Formating.printDash();
              setPinEnterLimit(getPinEnterLimit() - 1);
              // Continue the loop if the incorrect PIN is entered
            }
          }
        } else {
          if (getPinEnterLimit() == 1) {
            Formating.printDash();
            Formating.redColor("You exceeded your pin limit...");
            return false;
          } else {
            Formating.printDash();
            Formating.redColor("Please Enter 4 digit PIN number only");
            Formating.printDash();
            setPinEnterLimit(getPinEnterLimit() - 1);
          }
        }
      } catch (InputMismatchException e) {
        Formating.printDash();
        Formating.redColor(
          "Invalid input. Please enter a valid 4-digit PIN number."
        );
        Formating.printDash();
        scanner.next(); // Consume the invalid input to avoid an infinite loop
        setPinEnterLimit(getPinEnterLimit() - 1);
      }
    }
    return false; // Return false if the loop exits without the correct PIN being entered
  }

  // Account number value check
  boolean accountDigit(long accountNumber) {
    int digits = String.valueOf(accountNumber).length();
    if (digits == 2) {
      return true;
    } else {
      return false;
    }
  }

  boolean pinDigit(int pinNumber) {
    int digits = String.valueOf(pinNumber).length();
    if (digits == 4) {
      return true;
    } else {
      return false;
    }
  }

  boolean otpDigit(int otpNumber) {
    int digits = String.valueOf(otpNumber).length();
    if (digits == 4) {
      return true;
    } else {
      return false;
    }
  }
}
