package atm_cli_project;

import java.util.Scanner;

public class Features extends Account {

  Scanner scanner = new Scanner(System.in);
  boolean exit = true;
  int exitIterateCount = 3;
  int otpIterateCount = 3;
  int accountNumberIterationCount = 3;
  int tempPinCounter = 3;
  int mobileIterateCount = 3;

  ExceptionCheck exceptionCheck = new ExceptionCheck();

  public int selectOperation() {
    Formating.printDash();
    Formating.greenColor("Please Select one option from the below");
    Formating.printDash();
    System.out.println("1 => Cash Withdrawal");
    System.out.println("2 => Balance Enquiry");
    System.out.println("3 => Pin Change");
    System.out.println("4 => Add money to account");
    Formating.printDash();
    int selectedOperationIs = this.scanner.nextInt();
    return selectedOperationIs;
  }

  void withdrawal() {
    // TODO Auto-generated method stub
    // First Thing is to enter the Formating pin number
    if (exceptionCheck.pinCheck()) {
      Formating.printDash();
      Formating.greenColor("Please select the below abount to windrawal");
      Formating.printDash();
      System.out.println("1 => 100");
      System.out.println("2 => 500");
      System.out.println("3 => 1000");
      System.out.println("4 => 2000");
      System.out.println("5 => Enter manual amount");
      Formating.printDash();
      int choice = this.scanner.nextInt();
      // return selectedWithdrawalOptionIs;

      if (choice == 1) {
        setBalance(getBalance() - 100);
        Formating.printDash();
        System.out.println(
          "An amount of " +
          Formating.boldYellowColor(100) +
          " is withdrawed successfully"
        );

        Formating.printDash();
        Formating.greenColor(
          "Please Collect Your Cash ... \nThankYou for Banking with Us..."
        );
        Formating.printDash();
        exitOrContinue();
      } else if (choice == 2) {
        setBalance(getBalance() - 500);
        Formating.printDash();
        System.out.println(
          "An amount of " +
          Formating.boldYellowColor(500) +
          " is withdrawed successfully"
        );
        Formating.printDash();
        Formating.greenColor(
          "Please Collect Your Cash ... \nThankYou for Banking with Us..."
        );
        Formating.printDash();
        // this.exit = false;
        exitOrContinue();
      } else if (choice == 3) {
        setBalance(getBalance() - 1000);
        Formating.printDash();
        System.out.println(
          "An amount of " +
          Formating.boldYellowColor(1000) +
          " is withdrawed successfully"
        );
        Formating.printDash();
        Formating.greenColor(
          "Please Collect Your Cash ... \nThankYou for Banking with Us..."
        );
        Formating.printDash();
        exitOrContinue();
      } else if (choice == 4) {
        setBalance(getBalance() - 2000);
        Formating.printDash();
        System.out.println(
          "An amount of " +
          Formating.boldYellowColor(2000) +
          " is withdrawed successfully"
        );
        Formating.printDash();
        Formating.greenColor(
          "Please Collect Your Cash ... \nThankYou for Banking with Us..."
        );
        Formating.printDash();
        exitOrContinue();
      } else if (choice == 5) {
        Formating.printDash();
        System.out.println("Please Enter the amount you want to withdrawal");
        Formating.printDash();
        int amountToWithdraw = this.scanner.nextInt();
        int remainingBalance = getBalance() - amountToWithdraw;
        if (remainingBalance > 0) {
          setBalance(remainingBalance);
          Formating.printDash();
          System.out.println(
            "An amount of " +
            Formating.ANSI_BOLD +
            Formating.ANSI_YELLOW +
            amountToWithdraw +
            Formating.ANSI_RESET +
            " is withdrawed successfully"
          );
          Formating.printDash();
          Formating.greenColor(
            "Please Collect Your Cash ... \nThankYou for Banking with Us..."
          );
          Formating.printDash();
          exitOrContinue();
        } else {
          Formating.printDash();
          System.out.println("You dont have sufficient balance to withdraw");
          Formating.printDash();
        }
      }
    } else {
      Formating.redColor("Try again");
    }
  }

  void balance() {
    if (exceptionCheck.pinCheck()) {
      Formating.printDash();
      System.out.println(
        "Your Account balance is " +
        Formating.ANSI_BOLD +
        Formating.ANSI_YELLOW +
        getBalance() +
        Formating.ANSI_RESET +
        "."
      );
      Formating.printDash();
      exitOrContinue();
    } else {
      Formating.redColor("Try again");
    }
  }

  void pinChange() {
    tempPinCounter = 3;
    mobileIterateCount = 3;
    if (exceptionCheck.pinCheck()) {
      Formating.printDash();
      Formating.greenColor("Please enter Your mobile number :");
      Formating.printDash();
      while (mobileIterateCount > 0) {
        Long mobileNumber = scanner.nextLong();
        if (Long.valueOf(mobileNumber).equals(getMobileNumber())) {
          otpIterateCount = 3;
          Formating.printDash();
          Formating.greenColor("Enter the otp which was send to the number");
          Formating.printDash();
          while (otpIterateCount > 0) {
            int otp = scanner.nextInt();
            if (exceptionCheck.otpDigit(otp)) {
              if (otp == 1111) {
                while (tempPinCounter > 0) {
                  Formating.printDash();
                  Formating.greenColor("Enter Your new PIN :");
                  Formating.printDash();
                  int changedPin = scanner.nextInt();
                  if (exceptionCheck.pinDigit(changedPin)) {
                    setPinNumber(changedPin);
                    Formating.printDash();
                    System.out.println(
                      "New pin Number is : " +
                      Formating.boldYellowColor(changedPin)
                    );
                    Formating.printDash();
                    exitOrContinue();
                    break;
                  } else {
                    if (tempPinCounter == 1) {
                      Formating.printDash();
                      Formating.redColor(
                        "Tried too many times please try again"
                      );
                      break;
                    } else {
                      Formating.printDash();
                      Formating.redColor("Please set only 4-digit pin Number");
                      tempPinCounter = tempPinCounter - 1;
                      continue;
                    }
                  }
                  // break;
                }
              } else if (otp != 1111) {
                if (otpIterateCount == 1) {
                  Formating.printDash();
                  Formating.redColor("Exceeded the otp Entering Limit");
                  Formating.printDash();
                  exitOrContinue();
                  break;
                } else {
                  Formating.printDash();
                  Formating.redColor("Entered wrong otp ");
                  Formating.printDash();
                  otpIterateCount = otpIterateCount - 1;
                  continue;
                }
              }
              break;
            } else {
              if (otpIterateCount == 1) {
                Formating.printDash();
                Formating.redColor(
                  "You have Exceeded the otp Entring Limit \nTry again "
                );
                break;
              } else {
                Formating.printDash();
                Formating.redColor("Please enter 4-digit Otp number only ");
                Formating.printDash();
                otpIterateCount = otpIterateCount - 1;
                continue;
              }
            }
          }
        } else {
          if (mobileIterateCount == 1) {
            Formating.printDash();
            Formating.redColor("You have exceeded the limit ... Pls try again");
            break;
          } else {
            Formating.printDash();
            Formating.redColor("Pls enter correct 10 digit mobile number");
            Formating.printDash();
            mobileIterateCount = mobileIterateCount - 1;
            continue;
          }
        }
        break;
      }
    } else {
      Formating.redColor("Try again");
    }
  }

  void addMoney() {
    if (exceptionCheck.pinCheck()) {
      // Account Number
      Formating.printDash();
      Formating.greenColor(
        "Enter 16 digit account number. Where you want \nto add money "
      );
      Formating.printDash();
      while (accountNumberIterationCount > 0) {
        long enteredAccountNum = scanner.nextLong();
        // setAddAccountNumber(scanner.nextLong());
        if (enteredAccountNum == getAccountNumber()) {
          int balance = getBalance();
          Formating.printDash();
          Formating.greenColor("Enter amount to add in account");
          Formating.printDash();
          int addingAmount = scanner.nextInt();
          setBalance(balance + addingAmount);
          Formating.printDash();
          Formating.greenColor("Amount added successfully...");
          System.out.println(
            Formating.ANSI_GREEN +
            "New Remaining balance is => " +
            Formating.ANSI_RESET +
            Formating.boldYellowColor(getBalance())
          );
          break;
        } else {
          if (accountNumberIterationCount == 1) {
            Formating.printDash();
            Formating.redColor("Tried too many times pls try again...");
            break;
          } else {
            Formating.printDash();
            Formating.redColor(
              "Please Enter 16 digit Correct account number :"
            );
            Formating.printDash();
            accountNumberIterationCount = accountNumberIterationCount - 1;
          }
        }
      }
    } else {
      Formating.redColor("Try again");
    }
  }

  void exitOrContinue() {
    System.out.println(
      "Click" +
      Formating.ANSI_RED +
      " 0 " +
      Formating.ANSI_RESET +
      "to exit ||" +
      Formating.ANSI_GREEN +
      " 1 " +
      Formating.ANSI_RESET +
      "to continue"
    );
    Formating.printDash();
    while (exitIterateCount > 0) {
      int choice = scanner.nextInt();
      if (choice == 0) {
        Formating.printDash();
        Formating.greenColor("Thankyou for banking with us ... \nSee you soon");
        Formating.printDash();
        this.exit = false;
        break;
      } else if (choice == 1) {
        this.exit = true;
        break;
      } else if (exitIterateCount == 1) {
        Formating.printDash();
        Formating.redColor("You have entered wrong input too many time...");
        break;
      } else {
        Formating.printDash();
        System.out.println(
          "Please enter " +
          Formating.ANSI_RED +
          "0" +
          Formating.ANSI_RESET +
          " &&" +
          Formating.ANSI_GREEN +
          " 1 " +
          Formating.ANSI_RESET +
          "only "
        );
        Formating.printDash();
        exitIterateCount = exitIterateCount - 1;
      }
    }
  }
}
