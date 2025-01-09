public class Split{
  public User user;
  private double amount;

  public Split(User user, double amount){
    this.user = user;
    this.amount = amount;
  }

  // getter and setters
  public User getUser(){
    return user;
  }
  public double getAmount(){
    return amount;
  }
}