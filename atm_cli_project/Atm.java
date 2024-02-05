package atm_cli_project;

public class Atm {

  public static void main(String[] args) {
    Features feature = new Features();
    // User selecting what performance via Atm

    while (feature.exit) {
      int choice = feature.selectOperation();
      if (choice > 0 && choice < 5) {
        switch (choice) {
          case 1:
            feature.withdrawal();
            break;
          case 2:
            feature.balance();
            break;
          case 3:
            feature.pinChange();
            break;
          case 4:
            feature.addMoney();
          default:
            break;
        }
      } else {
        Formating.printDash();
        Formating.redColor("Please Enter correct choice between 0 to 4.");
        Formating.printDash();
      }
    }
  }
}
