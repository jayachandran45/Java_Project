package atm_cli_project;

public class Formating {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BOLD = "\u001B[1m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";

  static void printDash() {
    System.out.println("------------------------------------------------");
  }

  static void redColor(String value) {
    System.out.println(ANSI_RED + value + ANSI_RESET);
  }

  static String boldYellowColor(int value) {
    return ANSI_BOLD + ANSI_YELLOW + value + ANSI_RESET;
  }

  static void greenColor(String value) {
    System.out.println(ANSI_GREEN + value + ANSI_RESET);
  }
}
