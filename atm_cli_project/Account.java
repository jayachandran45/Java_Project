package atm_cli_project;

abstract class Account {

  private int balance = 50000;
  private int pinNumber = 1111;
  private int pinEnterLimit = 3;
  private Long accountNumber = 1234567890987654l;
  private Long mobileNumber = 7871660463l;

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public int getPinNumber() {
    return pinNumber;
  }

  public void setPinNumber(int pinNumber) {
    this.pinNumber = pinNumber;
  }

  public int getPinEnterLimit() {
    return pinEnterLimit;
  }

  public void setPinEnterLimit(int pinEnterLimit) {
    this.pinEnterLimit = pinEnterLimit;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
